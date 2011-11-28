package com.ams.isnuts;

import android.app.Activity;
import android.os.Bundle;

import com.ams.isnuts.dao.CategoriesDao;
import com.ams.isnuts.dao.ServiceApplicationDao;
import com.ams.isnuts.dao.sqlite.SqliteCategoriesDao;
import com.ams.isnuts.dao.sqlite.SqliteServiceApplicationDao;
import com.ams.isnuts.testdata.TestData;

import de.akquinet.android.androlog.Log;

public class HelloAndroidActivity extends Activity {

	private ServiceApplicationDao serviceDao = new SqliteServiceApplicationDao(
			this);
	
	private CategoriesDao categoriesDao = new SqliteCategoriesDao(this);

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Initializes the logging
		Log.init();
		// Log a message (only on dev platform)
		Log.i(this, "onCreate");
		setContentView(R.layout.main);
		
		serviceDao.insertServiceApplication(TestData.serviceApplication);
		
		
//		List<ServiceApplication> pulledServices = sqliteServiceDao
//				.getAllApplicationServices();
//		
//		ServiceApplication pulledService = pulledServices.get(0);
//
//		TextView idTextView = (TextView) findViewById(R.id.serviceAppId);
//		TextView titleTextView = (TextView) findViewById(R.id.title);
//		TextView descTextView = (TextView) findViewById(R.id.description);
//		TextView serviceTypeTextView = (TextView) findViewById(R.id.serviceType);
//		TextView serviceNumberTextView = (TextView) findViewById(R.id.serviceNumber);
//		TextView activePromoTextView = (TextView) findViewById(R.id.activePromo);
//		TextView appendTextView = (TextView) findViewById(R.id.appendToMobile);
//		TextView categoryTextView = (TextView) findViewById(R.id.category);
//		TextView keywordTextView = (TextView) findViewById(R.id.keyword);
//		
//		idTextView.setText(categoriesDao.getCategory(3).getName());
//		titleTextView.setText(category2.getName());
//		descTextView.setText(pulledService.getDescription());
//		serviceTypeTextView.setText(pulledService.getServiceType());
//		serviceNumberTextView.setText(pulledService.getServiceNumber());
//		activePromoTextView.setText(pulledService.isActivePromo() + "");
//		appendTextView.setText(pulledService.isAppendMobileToServiceNumber()+ "");
//		categoryTextView.setText(pulledService.getCategories().get(0).getName());
//		keywordTextView.setText(pulledService.getKeywordItems().get(0).getLiteralValue());

	}

}
