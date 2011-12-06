package com.ams.isnuts.test.data;

import java.util.ArrayList;
import java.util.List;

import com.ams.isnuts.model.Category;
import com.ams.isnuts.model.InputParams;
import com.ams.isnuts.model.ServiceApplication;

public class ServiceApplicationTestData {
	
	public static final ServiceApplication getServiceApplicationTestData (){
		ServiceApplication serviceApplication = new ServiceApplication();
        serviceApplication.setServiceApplicationId(1001L);
        serviceApplication.setTitle("Unlitxt 40");
        serviceApplication.setDescription("P40.00 lang, unli ka na!");
        serviceApplication.setServiceType("TEXT");
        serviceApplication.setServiceNumber("8888");
        serviceApplication.setActivePromo(true);
        serviceApplication.setAppendMobileToServiceNumber(false);
        
        InputParams inputParams = new InputParams();
        inputParams.setItemType("Unlitxt For 2 Days Keyword");
        inputParams.setLiteralValue("Unlitxt40");
        List<InputParams> inputParamsList = new ArrayList<InputParams>();
        inputParamsList.add(inputParams);
        serviceApplication.setKeywordItems(inputParamsList);
        
        Category category = new Category();
        category.setId(2000L);
        category.setName("Txt promos");
        List<Category> categoriesList = new ArrayList<Category>();
        categoriesList.add(category);
        serviceApplication.setCategories(categoriesList);
        
        return serviceApplication;
	}
}
