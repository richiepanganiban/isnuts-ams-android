package com.ams.isnuts.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ams.isnuts.model.Category;
import com.ams.isnuts.model.InputParams;
import com.ams.isnuts.model.ServiceApplication;

public class SqliteServiceApplicationDao extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "ams.db";

	private static final int VERSION = 1;

	public SqliteServiceApplicationDao(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL("CREATE TABLE services(serviceApplicationId INTEGER PRIMARY KEY," +
				"title TEXT, description TEXT, serviceType TEXT, " +
				"serviceNumber TEXT, activePromo INTEGER, appendMobileToServiceNumber " +
				"INTEGER)");
		database.execSQL("CREATE TABLE keywords (serviceApplicationReferenceId INTEGER, itemType TEXT," +
				" literalValue TEXT, FOREIGN KEY(serviceApplicationReferenceId) REFERENCES " +
				"services(serviceApplicationId) ON DELETE CASCADE)");
		database.execSQL("CREATE TABLE categories (categoryId categoryId INTEGER PRIMARY KEY, " +
				"name TEXT)");
		database.execSQL("CREATE TABLE serviceCategoriesLookup (serviceApplicationReferenceId INTEGER, " +
				"categoryReferenceId INTEGER, FOREIGN KEY(serviceApplicationReferenceId) REFERENCES " +
				"services(serviceApplicationId) ON DELETE CASCADE, FOREIGN KEY(categoryReferenceId) REFERENCES categories(categoryId) ON DELETE CASCADE)");
//		database.execSQL("CREATE TRIGGER serviceCategoryTrigger BEFORE INSERT OF serviceApplicationId ON services" +
//				"BEGIN " +
//					"INSERT INTO serviceCategoriesLookup values (   "
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// No implementation
	}
	
	public void insert(ServiceApplication serviceApplication) {
		
		ContentValues contentValues = new ContentValues();
		contentValues.put("serviceApplicationId", serviceApplication.getServiceApplicationId());
		contentValues.put("title", serviceApplication.getTitle());
		contentValues.put("description", serviceApplication.getDescription());
		contentValues.put("serviceType", serviceApplication.getServiceType());
		contentValues.put("serviceNumber", serviceApplication.getServiceNumber());
		contentValues.put("activePromo", parseBooleanToInt(serviceApplication.isActivePromo()));
		contentValues.put("appendMobileToServiceNumber", parseBooleanToInt(serviceApplication.isAppendMobileToServiceNumber()));
		insertKeywords(serviceApplication);
		
//		contentValues.put("categories", serializeToByteArrayObject(serviceApplication.getCategories()));
//		contentValues.put("keywordItems", serializeToByteArrayObject(serviceApplication.getKeywordItems()));
		
		getWritableDatabase().insert("services", null, contentValues);
		
		
	}
	
	private void insertKeywords(ServiceApplication serviceApplication) {
		ContentValues contentValues = new ContentValues();
		contentValues.put("serviceApplicationId", serviceApplication.getServiceApplicationId());
		List<InputParams> inputParams = serviceApplication.getKeywordItems();
		
		for(InputParams inputParam : inputParams ) {
			contentValues.put("itemType", inputParam.getItemType());
			contentValues.put("literalValue", inputParam.getLiteralValue());
			getWritableDatabase().insert("keywords", null , contentValues);
		}
		
	}

	public List<ServiceApplication> getAllApplicationServices(){
		Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM services ORDER BY serviceApplicationId", null);
		cursor.moveToFirst();
		List<ServiceApplication> serviceApplications = new ArrayList<ServiceApplication>();
		while (!cursor.isAfterLast()) {
			mapServiceApplicationFromCursor(cursor);
			cursor.moveToNext();
		}
		return serviceApplications;
	}
	
	public ServiceApplication getServiceApplicationById(long id) {
		Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM services WHERE serviceApplicationId="+id, null);
		cursor.moveToFirst();
		ServiceApplication serviceApplication = mapServiceApplicationFromCursor(cursor);
		return serviceApplication;
	}

	@SuppressWarnings("unchecked")
	private ServiceApplication mapServiceApplicationFromCursor(Cursor cursor) {
		ServiceApplication serviceApplication = new ServiceApplication();
		serviceApplication.setServiceApplicationId(cursor.getInt((cursor.getColumnIndex("serviceApplicationId"))));
		serviceApplication.setTitle(cursor.getString(cursor.getColumnIndex("title")));
		serviceApplication.setDescription(cursor.getString(cursor.getColumnIndex("description")));
		serviceApplication.setServiceType(cursor.getString(cursor.getColumnIndex("serviceType")));
		serviceApplication.setServiceNumber(cursor.getString(cursor.getColumnIndex("serviceNumber")));
		serviceApplication.setActivePromo(parseIntToBoolean(cursor.getInt(cursor.getColumnIndex("activePromo"))));
		serviceApplication.setAppendMobileToServiceNumber(parseIntToBoolean(cursor.getInt(cursor.getColumnIndex("appendMobileToServiceNumber"))));
		
		Object deserializedCategories = deserializeBlob(cursor.getBlob(cursor.getColumnIndex("categories")));
		if(deserializedCategories instanceof ArrayList<?> ) {
			serviceApplication.setCategories((List<Category>) deserializedCategories);
		}
		
		Object deserializedKeywordItems = deserializeBlob(cursor.getBlob(cursor.getColumnIndex("keywordItems")));
		if(deserializedKeywordItems instanceof ArrayList<?>) {
			serviceApplication.setKeywordItems((List<InputParams>)deserializedKeywordItems);				
		}
		return serviceApplication;
	}
	

	
	public static byte [] serializeToByteArrayObject(Object serializableOject) {
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
			objectOutputStream.writeObject(serializableOject);
			objectOutputStream.close();
		} catch (IOException e) {
			//TODO Implement logger here
		}
		
		return byteOutputStream.toByteArray();
	}
	
	private static Object deserializeBlob (byte [] blob) {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(blob);
		Object deserializedBlobContainer = null;
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			deserializedBlobContainer = objectInputStream.readObject();
			objectInputStream.close();
			byteArrayInputStream.close();
		} catch (IOException e) {
			// TODO logging
		} catch (ClassNotFoundException e) {
			// TODO logging
		}
		return deserializedBlobContainer;
	}

	private static int parseBooleanToInt(boolean parameterIsTrue) {
		if(parameterIsTrue) {
			return 1;
		}
		return 0;
	}
	
	private static boolean parseIntToBoolean(int integerFlag) {
		if(integerFlag == 1) {
			return true;
		}
		return false;
	}
	
}
