package com.ams.isnuts;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.ams.isnuts.dao.SqliteServiceApplicationDao;
import com.ams.isnuts.model.Category;
import com.ams.isnuts.model.InputParams;
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
        
        ServiceApplication serviceApplication = new ServiceApplication();
        serviceApplication.setServiceApplicationId(1000L);
        serviceApplication.setTitle("Unlitxt 20");
        serviceApplication.setDescription("P20.00 lang, unli ka na!");
        serviceApplication.setServiceType("TEXT");
        serviceApplication.setServiceNumber("8888");
        serviceApplication.setActivePromo(true);
        serviceApplication.setAppendMobileToServiceNumber(false);
        
        InputParams inputParams = new InputParams();
        inputParams.setItemType("Unlitxt For 1 Day Keyword");
        inputParams.setLiteralValue("Unlitxt20");
        List<InputParams> inputParamsList = new ArrayList<InputParams>();
        inputParamsList.add(inputParams);
        serviceApplication.setKeywordItems(inputParamsList);
        
        Category category = new Category();
        category.setId(2000L);
        category.setName("Txt promos");
        List<Category> categoriesList = new ArrayList<Category>();
        categoriesList.add(category);
        serviceApplication.setCategories(categoriesList);
        
//        sqliteServiceDao.insert(serviceApplication);
        List<ServiceApplication> pulledServices = sqliteServiceDao.getAllApplicationServices();
        
        
        
    }
    
    @Override
    public void onDestroy() {
    	super.onDestroy();
    	sqliteServiceDao.close();
    }

}

