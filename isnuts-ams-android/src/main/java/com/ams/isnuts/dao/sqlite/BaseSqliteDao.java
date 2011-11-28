package com.ams.isnuts.dao.sqlite;

import static com.ams.isnuts.constant.SqliteConstants.CREATE_TABLE_CATEGORIES;
import static com.ams.isnuts.constant.SqliteConstants.CREATE_TABLE_CUSTOM_KEYWORDS;
import static com.ams.isnuts.constant.SqliteConstants.CREATE_TABLE_CUSTOM_SERVICE_APPLICATION;
import static com.ams.isnuts.constant.SqliteConstants.CREATE_TABLE_KEYWORDS;
import static com.ams.isnuts.constant.SqliteConstants.CREATE_TABLE_SERVICE_APPLICATIONS;
import static com.ams.isnuts.constant.SqliteConstants.CREATE_TABLE_SERVICE_CATEGORIES_LOOKUP;
import static com.ams.isnuts.constant.SqliteConstants.CREATE_TRIGGER_CATEGORY;
import static com.ams.isnuts.constant.SqliteConstants.CREATE_TRIGGER_CUSTOM_SERVICE_APPLICATION;
import static com.ams.isnuts.constant.SqliteConstants.CREATE_TRIGGER_SERVICE_APPLICATION;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class BaseSqliteDao extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "ams.db";

	private static final int VERSION = 1;
	
	public BaseSqliteDao(Context context) {
		super(context, DATABASE_NAME, null, VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(CREATE_TABLE_CATEGORIES);
		database.execSQL(CREATE_TABLE_SERVICE_APPLICATIONS);
		database.execSQL(CREATE_TABLE_CUSTOM_SERVICE_APPLICATION);
		database.execSQL(CREATE_TABLE_CUSTOM_KEYWORDS);
		database.execSQL(CREATE_TABLE_KEYWORDS);
		database.execSQL(CREATE_TABLE_SERVICE_CATEGORIES_LOOKUP);
		database.execSQL(CREATE_TRIGGER_CUSTOM_SERVICE_APPLICATION);
		database.execSQL(CREATE_TRIGGER_CATEGORY);
		database.execSQL(CREATE_TRIGGER_SERVICE_APPLICATION);
	}

	@Override
	public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1,
			int paramInt2) {
		//No Implementation.. Yet.
	}
	
}
