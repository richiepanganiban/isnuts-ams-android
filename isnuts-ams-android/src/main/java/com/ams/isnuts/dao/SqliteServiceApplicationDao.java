package com.ams.isnuts.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ams.isnuts.model.ServiceApplication;

import de.akquinet.android.androlog.Log;

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
				"INTEGER, categories BLOB, keywordItems BLOB)");
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
		contentValues.put("activePromo", parseActivePromo(serviceApplication));
		contentValues.put("appendMobileToServiceNumber", serviceApplication.isAppendMobileToServiceNumber());
		contentValues.put("categories", serializeToByteArrayObject(serviceApplication.getCategories()));
		contentValues.put("keywordItems", serializeToByteArrayObject(serviceApplication.getKeywordItems()));
		
		getWritableDatabase().insert("services", "name", contentValues);
		
	}

	private static int parseActivePromo(ServiceApplication service) {
		if(service.isActivePromo()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
	private static byte [] serializeToByteArrayObject(Object serializableOject) {
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();

		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteOutputStream);
			objectOutputStream.writeObject(serializableOject);
		} catch (IOException e) {
			//TODO Implement logger here
		}
		
		return byteOutputStream.toByteArray();
	}
	
	public List<ServiceApplication> getAllApplicationServices(){
		Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM services ORDER BY serviceApplicationId", null);
		Log.i("Get string(1)" + cursor.getString(1));
		return null;
	}
	
}
