package com.ams.isnuts;

import android.app.Activity;
import android.os.Bundle;

import com.ams.isnuts.dao.SqliteServiceDao;
import com.ams.isnuts.model.Service;

import de.akquinet.android.androlog.Log;

public class HelloAndroidActivity extends Activity {

	private SqliteServiceDao sqliteServiceDao = new SqliteServiceDao(this);
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initializes the logging
        Log.init();
        // Log a message (only on dev platform)
        Log.i(this, "onCreate");
        setContentView(R.layout.main);
        
        Service service = new Service();
        service.setTitle("Service # 1");
        sqliteServiceDao.insert(service);
        
        
        
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	sqliteServiceDao.close();
    }

}

