package com.ams.isnuts.test.dao;

import android.database.Cursor;
import android.test.ActivityInstrumentationTestCase2;

import com.ams.isnuts.HelloAndroidActivity;
import com.ams.isnuts.dao.SqliteServiceApplicationDao;
import com.ams.isnuts.model.ServiceApplication;
import com.ams.isnuts.test.data.ServiceApplicationTestData;

public class SqliteServiceApplicationDaoTest extends ActivityInstrumentationTestCase2<HelloAndroidActivity>{

	
	private SqliteServiceApplicationDao sqliteServiceApplicationDao;
	
	public SqliteServiceApplicationDaoTest() {
        super("com.ams.isnuts", HelloAndroidActivity.class);
//        sqliteServiceApplicationDao = new SqliteServiceApplicationDao(getActivity());
    }
    
    public void testActivity() {
        HelloAndroidActivity activity = getActivity();
        assertNotNull(activity);
        
    }
	

	public void testInsertNewServiceApplication() {
		sqliteServiceApplicationDao = new SqliteServiceApplicationDao(getActivity());
		sqliteServiceApplicationDao.insert(ServiceApplicationTestData.getServiceApplicationTestData());
		Cursor cursor = sqliteServiceApplicationDao.getReadableDatabase().rawQuery("select * from services where serviceApplicationId=1001", null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()) {
			cursor.moveToNext();
		}
		sqliteServiceApplicationDao.close();
	}
	public void testGetServiceApplicationById() {
		sqliteServiceApplicationDao = new SqliteServiceApplicationDao(getActivity());
		sqliteServiceApplicationDao.insert(ServiceApplicationTestData.getServiceApplicationTestData());
		ServiceApplication serviceApplication = sqliteServiceApplicationDao.getServiceApplicationById(1001L);
		assertNotNull(serviceApplication);
		sqliteServiceApplicationDao.close();
	}
	
	
//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
//		sqliteServiceApplicationDao.insert(ServiceApplicationTestData.getServiceApplicationTestData());
//	}
//	
//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
//		
//	}
//	@Override
//	protected void tearDown() throws Exception {
//		super.tearDown();
//		sqliteServiceApplicationDao.close();
//	}

}
