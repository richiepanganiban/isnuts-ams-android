package com.ams.isnuts.dao.sqlite;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ams.isnuts.dao.ServiceApplicationDao;
import com.ams.isnuts.model.Category;
import com.ams.isnuts.model.InputParams;
import com.ams.isnuts.model.ServiceApplication;

public class SqliteServiceApplicationDao extends BaseSqliteDao implements ServiceApplicationDao {

	private static final String APPEND_MOBILE_TO_SERVICE_NUMBER_COLUMN = "append_mobile_to_service_number";
	private static final String ACTIVE_PROMO_COLUMN = "active_promo";
	private static final String SERVICE_NUMBER_COLUMN = "service_number";
	private static final String SERVICE_TYPE_COLUMN = "service_type";
	private static final String DESCRIPTION_COLUMN = "description";
	private static final String TITLE_COLUMN = "title";
	private static final String SERVICE_APPLICATION_ID_COLUMN = "service_application_id";

	public SqliteServiceApplicationDao(Context context) {
		super(context);
	}
	
	private SQLiteDatabase sqliteDb;
	
	public void insertServiceApplication(ServiceApplication serviceApplication) {
		ContentValues content = new ContentValues();
		content.put(SERVICE_APPLICATION_ID_COLUMN,serviceApplication.getServiceApplicationId());
		content.put(TITLE_COLUMN, serviceApplication.getTitle());
		content.put(DESCRIPTION_COLUMN, serviceApplication.getDescription());
		content.put(SERVICE_TYPE_COLUMN, serviceApplication.getServiceType());
		content.put(SERVICE_NUMBER_COLUMN, serviceApplication.getServiceNumber());
		content.put(ACTIVE_PROMO_COLUMN, parseBooleanToInt(serviceApplication.isActivePromo()));
		content.put(APPEND_MOBILE_TO_SERVICE_NUMBER_COLUMN,parseBooleanToInt(serviceApplication.isAppendMobileToServiceNumber()));
		
		sqliteDb = getWritableDatabase();
		sqliteDb.insert("service_applications", null, content);
		insertToLookupTable(serviceApplication);
		sqliteDb.close();
	}
	
	private void insertToLookupTable(ServiceApplication serviceApplication) {
		ContentValues content = new ContentValues();
		for(Category category : serviceApplication.getCategories()) {
			content.put("service_application_reference_id", serviceApplication.getServiceApplicationId());
			content.put("category_reference_id", category.getId());
			sqliteDb.insert("service_categories_lookup", null, content);
		}
	}


	public List<ServiceApplication> getAllApplicationServices() {
		Cursor cursor = getReadableDatabase()
				.rawQuery(
						"SELECT * FROM service_applications ORDER BY service_application_id",
						null);
		cursor.moveToFirst();
		List<ServiceApplication> serviceApplications = new ArrayList<ServiceApplication>();
		while (!cursor.isAfterLast()) {
			mapServiceApplicationFromCursor(cursor);
			cursor.moveToNext();
		}
		return serviceApplications;
	}

	public ServiceApplication getServiceApplicationById(long id) {
		Cursor cursor = getReadableDatabase().rawQuery(
				"SELECT * FROM service_applications WHERE service_application_id="
						+ id, null);
		cursor.moveToFirst();
		ServiceApplication serviceApplication = mapServiceApplicationFromCursor(cursor);
		return serviceApplication;
	}

	private ServiceApplication mapServiceApplicationFromCursor(Cursor cursor) {
		ServiceApplication serviceApplication = new ServiceApplication();
		serviceApplication.setServiceApplicationId(cursor.getInt((cursor.getColumnIndex(SERVICE_APPLICATION_ID_COLUMN))));
		serviceApplication.setTitle(cursor.getString(cursor.getColumnIndex(TITLE_COLUMN)));
		serviceApplication.setDescription(cursor.getString(cursor.getColumnIndex(DESCRIPTION_COLUMN)));
		serviceApplication.setServiceType(cursor.getString(cursor.getColumnIndex(SERVICE_TYPE_COLUMN)));
		serviceApplication.setServiceNumber(cursor.getString(cursor.getColumnIndex(SERVICE_NUMBER_COLUMN)));
		serviceApplication.setActivePromo(parseIntToBoolean(cursor.getInt(cursor.getColumnIndex(ACTIVE_PROMO_COLUMN))));
		serviceApplication.setAppendMobileToServiceNumber(parseIntToBoolean(cursor.getInt(cursor.getColumnIndex(APPEND_MOBILE_TO_SERVICE_NUMBER_COLUMN))));

		return serviceApplication;
	}
	
//	private List<>

	private static int parseBooleanToInt(boolean parameterIsTrue) {
		if (parameterIsTrue) {
			return 1;
		}
		return 0;
	}

	private static boolean parseIntToBoolean(int integerFlag) {
		if (integerFlag == 1) {
			return true;
		}
		return false;
	}



	

}
