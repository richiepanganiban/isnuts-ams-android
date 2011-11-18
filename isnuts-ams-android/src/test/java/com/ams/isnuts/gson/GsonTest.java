package com.ams.isnuts.gson;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.ams.isnuts.model.Category;
import com.ams.isnuts.model.InputParams;
import com.ams.isnuts.model.ServiceApplication;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest {
	@Test
	public void JsonSingleServiceTest() {
		String json = "{\"activePromo\":true,\"serviceType\":\"SMS\",\"title\":\"Balance Inquiry\",\"description\":\"Inquire your balance.  Cost: Free\",\"serviceNumber\":\"222\",\"appendMobileToServiceNumber\":false,\"keywordItems\":[{\"itemType\":\"LITERAL\",\"literalValue\":\"BAL\"}],\"categories\":[{\"id\":\"0001\",\"name\":\"General\"}]}";
		Gson gson = new Gson();
		ServiceApplication serviceApp = gson.fromJson(json, ServiceApplication.class);
		assertEquals(
				"ServiceApplication [activePromo=true, serviceType=SMS, title=Balance Inquiry, description=Inquire your balance.  Cost: Free, serviceNumber=222, appendMobileToServiceNumber=false, keywordItems=[InputParams [itemType=LITERAL, literalValue=BAL, label=null]], categories=[Category [id=1, name=General]]]",
				serviceApp.toString());
	}

	@Test
	public void JsonListServiceTest() {
		String json2 = "[{\"activePromo\":true,\"serviceType\":\"SMS\",\"title\":\"Balance Inquiry\",\"description\":\"Inquire your balance.  Cost: Free\",\"serviceNumber\":\"222\",\"appendMobileToServiceNumber\":false,\"keywordItems\":[{\"itemType\":\"LITERAL\",\"literalValue\":\"BAL\"}],\"categories\":[{\"name\":\"General\"}]},{\"activePromo\":true,\"serviceType\":\"SMS\",\"title\":\"DUO\",\"description\":\"Unlimited calls to Globe Landlines and selected landlines for only P450/30days\",\"serviceNumber\":\"8888\",\"appendMobileToServiceNumber\":false,\"keywordItems\":[{\"itemType\":\"SPACE\"},{\"itemType\":\"LITERAL\",\"literalValue\":\"450\"},{\"itemType\":\"SPACE\"},{\"itemType\":\"LITERAL\",\"literalValue\":\"DUO\"},{\"itemType\":\"USER_INPUT\",\"label\":\"Area\"}],\"categories\":[{\"name\":\"Text Offers\"},{\"name\":\"Call Offers\"}]}]";

		ServiceApplication serviceApp = new ServiceApplication();
		serviceApp.setActivePromo(true);
		serviceApp.setServiceType("SMS");
		serviceApp.setTitle("DUO");
		serviceApp.setDescription("Unlimited calls to Globe Landlines and selected landlines for only P450/30days");
		serviceApp.setServiceNumber("8888");
		LinkedList<InputParams> keywords = new LinkedList<InputParams>();
		InputParams input1 = new InputParams();
		input1.setItemType("SPACE");
		keywords.add(input1);

		InputParams input2 = new InputParams();
		input2.setItemType("LITERAL");
		input2.setLiteralValue("450");
		keywords.add(input2);
		// another space
		keywords.add(input1);

		InputParams input3 = new InputParams();
		input3.setItemType("LITERAL");
		input3.setLiteralValue("DUO");
		keywords.add(input3);

		InputParams input4 = new InputParams();
		input4.setItemType("USER_INPUT");
		input4.setLabel("Area");
		keywords.add(input4);

		Category category1 = new Category();
		category1.setName("Text Offers");
		Category category2 = new Category();
		category2.setName("Call Offers");

		List<Category> categories = new ArrayList<Category>();
		categories.add(category1);
		categories.add(category2);

		serviceApp.setKeywordItems(keywords);
		serviceApp.setCategories(categories);
		serviceApp.setAppendMobileToServiceNumber(false);

		Gson gson = new Gson();

		List<ServiceApplication> serviceApps = gson.fromJson(json2, new TypeToken<List<ServiceApplication>>() {
		}.getType());

		assertTrue(serviceApps.size() == 2);
		assertTrue(serviceApps.get(1).equals(serviceApp));
	}
}
