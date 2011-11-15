package com.ams.isnuts.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ams.isnuts.model.Service;

public class SqliteServiceDao extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "ams.db";

	private static final int VERSION = 1;

	public SqliteServiceDao(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL("CREATE TABLE services(_id INTEGER PRIMARY AUTO INCREMENT, " +
				"title TEXT, description TEXT, serviceType TEXT, serviceNumber TEXT, " +
				"activePromo INTEGER, appendNumber INTEGER, categories BLOB, " +
				"keywordItems BLOB)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// No implementation
	}
	
	public void insert(Service service) {
		
		ContentValues contentValues = new ContentValues();
		contentValues.put("title", service.getTitle());
		contentValues.put("description", service.getDescription());
		contentValues.put("serviceType", service.getServiceType());
		contentValues.put("serviceNumber", service.getServiceNumber());
		contentValues.put("activePromo", service.isActivePromo());
		contentValues.put("appendNumber", service.isAppendMobileToServiceNumber());
		contentValues.put("categories", serializeToByteArrayObject(service.getCategories()));
		contentValues.put("keywordItems", serializeToByteArrayObject(service.getKeywordItems()));
		
		getWritableDatabase().insert("services", "name", contentValues);
		
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

}
