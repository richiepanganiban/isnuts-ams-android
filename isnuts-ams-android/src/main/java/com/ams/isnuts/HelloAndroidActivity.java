package com.ams.isnuts;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.ams.isnuts.dao.SqliteServiceApplicationDao;
import com.ams.isnuts.model.ServiceApplication;

import de.akquinet.android.androlog.Log;

public class HelloAndroidActivity extends Activity {

	private SqliteServiceApplicationDao sqliteServiceDao = new SqliteServiceApplicationDao(this);
	

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initializes the logging
        Log.init();
        // Log a message (only on dev platform)
        Log.i(this, "onCreate");
        setContentView(R.layout.main);
        
//        List<ServiceApplication> pulledServices = sqliteServiceDao.getAllApplicationServices();
//        ServiceApplication pulledService = pulledServices.get(0);
//        Log.d("After pulling");
        
//        TextView idTextView = (TextView) findViewById(R.id.serviceAppId);
//        TextView titleTextView = (TextView) findViewById(R.id.title);
//        TextView descTextView = (TextView) findViewById(R.id.description);
//        TextView serviceTypeTextView = (TextView) findViewById(R.id.serviceType);
//        TextView serviceNumberTextView = (TextView) findViewById(R.id.serviceNumber);
//        TextView activePromoTextView = (TextView) findViewById(R.id.activePromo);
//        TextView appendTextView = (TextView) findViewById(R.id.appendToMobile);
//        TextView categoryTextView = (TextView) findViewById(R.id.category);
//        TextView keywordTextView = (TextView) findViewById(R.id.keyword);
//
//        idTextView.setText(pulledService.getServiceApplicationId()+"");
//        titleTextView.setText(pulledService.getTitle());
//        descTextView.setText(pulledService.getDescription());
//        serviceTypeTextView.setText(pulledService.getServiceType());
//        serviceNumberTextView.setText(pulledService.getServiceNumber());
//        activePromoTextView.setText(pulledService.isActivePromo()+"");
//        appendTextView.setText(pulledService.isAppendMobileToServiceNumber()+"");
//        categoryTextView.setText(pulledService.getCategories().get(0).getName());
//        keywordTextView.setText(pulledService.getKeywordItems().get(0).getLiteralValue());
        
        
    }
	
    public SqliteServiceApplicationDao getSqliteServiceDao() {
		return sqliteServiceDao;
	}

	public void setSqliteServiceDao(SqliteServiceApplicationDao sqliteServiceDao) {
		this.sqliteServiceDao = sqliteServiceDao;
	}

    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	sqliteServiceDao.close();
    }

}

