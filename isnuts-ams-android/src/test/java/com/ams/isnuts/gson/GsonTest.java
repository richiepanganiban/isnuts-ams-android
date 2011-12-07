package com.ams.isnuts.gson;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ams.isnuts.model.ServiceApplication;
import com.google.gson.Gson;

public class GsonTest {
	@Test
	public void JsonTest() {
		String json = "{\"activePromo\":true,\"serviceType\":\"SMS\",\"title\":\"Balance Inquiry\",\"description\":\"Inquire your balance.  Cost: Free\",\"serviceNumber\":\"222\",\"appendMobileToServiceNumber\":false,\"keywordItems\":[{\"itemType\":\"LITERAL\",\"literalValue\":\"BAL\"}],\"categories\":[{\"id\":\"0001\",\"name\":\"General\"}]}";
		Gson gson = new Gson();
		ServiceApplication serviceApp = gson.fromJson(json, ServiceApplication.class);
		assertEquals(
				"ServiceApplication [activePromo=true, serviceType=SMS, title=Balance Inquiry, description=Inquire your balance.  Cost: Free, serviceNumber=222, appendMobileToServiceNumber=false, keywordItems=[InputParams [itemType=LITERAL, literalValue=BAL]], categories=[Category [id=1, name=General]]]",
				serviceApp.toString());
	}
}
