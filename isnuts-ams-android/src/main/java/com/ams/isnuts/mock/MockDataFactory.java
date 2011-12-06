package com.ams.isnuts.mock;

import java.util.ArrayList;
import java.util.List;

import com.ams.isnuts.model.CustomServiceApplication;
import com.ams.isnuts.model.InputParams;
import com.ams.isnuts.model.ServiceApplication;

public class MockDataFactory {
	
	static {
		initFavoriteApplications();
		initServiceApplications();
	}
	
	public static List<CustomServiceApplication> mockFavoriteApplications;
	public static List<ServiceApplication> mockServiceApplications;
	
	private static void initFavoriteApplications() {
		mockFavoriteApplications = new ArrayList<CustomServiceApplication>();
		ServiceApplication pasaLoad = new ServiceApplication();
		pasaLoad.setTitle("Pasa Load");
		pasaLoad.setDescription("Load Transfer");
		pasaLoad.setServiceNumber("2");
		pasaLoad.setServiceType("TEXT");
		pasaLoad.setAppendMobileToServiceNumber(true);
		pasaLoad.setActivePromo(true);
		pasaLoad.setTargetMobileNumber("63905734915");
		
		InputParams amount = new InputParams();
		amount.setItemType("STRING");
		amount.setLiteralValue("20");
		amount.setPromptMessage("Pasaload amount");
		
		
		InputParams space = new InputParams();
		space.setItemType("STRING");
		space.setLiteralValue(" ");
		
		InputParams password = new InputParams();
		password.setItemType("STRING");
		password.setLiteralValue("1234");
		password.setPromptMessage("Pasaload Password");
		
		List<InputParams> pasaLoadKeywords = new ArrayList<InputParams>();
		
		pasaLoadKeywords.add(amount);
		pasaLoadKeywords.add(space);
		pasaLoadKeywords.add(password);
		
		pasaLoad.setKeywordItems(pasaLoadKeywords);
		
		CustomServiceApplication pasaLoadBunso = new CustomServiceApplication();
		pasaLoadBunso.setServiceApplication(pasaLoad);
		pasaLoadBunso.setTitle("Pasaload bunso");
		
		mockFavoriteApplications.add(pasaLoadBunso);
		
		ServiceApplication balInquiry = new ServiceApplication();
		balInquiry.setTitle("Balance Inquiry");
		balInquiry.setDescription("Balance Inquiry");
		balInquiry.setServiceNumber("222");
		balInquiry.setServiceType("TEXT");
		balInquiry.setAppendMobileToServiceNumber(false);
		balInquiry.setActivePromo(true);
		
		List<InputParams> balInquiryKeywords = new ArrayList<InputParams>();
		
		InputParams balKeyword = new InputParams();
		balKeyword.setItemType("STRING");
		balKeyword.setLiteralValue("Bal");
		
		balInquiry.setKeywordItems(balInquiryKeywords);
		
		CustomServiceApplication balanceInquiry = new CustomServiceApplication();
		balanceInquiry.setServiceApplication(balInquiry);
		balanceInquiry.setTitle("Balance Inquiry");
		
		
		mockFavoriteApplications.add(balanceInquiry);
		
		ServiceApplication tenCentsPerSecondCall = new ServiceApplication();
		tenCentsPerSecondCall.setTitle("10c Per Seconds Call");
		tenCentsPerSecondCall.setDescription("10 cents per call Globe to Globe");
		tenCentsPerSecondCall.setServiceNumber("232");
		tenCentsPerSecondCall.setServiceType("CALL");
		tenCentsPerSecondCall.setAppendMobileToServiceNumber(true);
		tenCentsPerSecondCall.setActivePromo(true);
		tenCentsPerSecondCall.setTargetMobileNumber("63905734915");
		
		CustomServiceApplication tipidCallToGf = new CustomServiceApplication();
		tipidCallToGf.setServiceApplication(tenCentsPerSecondCall);
		tipidCallToGf.setTitle("Tipid call to GF");
		
		mockFavoriteApplications.add(tipidCallToGf);
		
	}

	private static void initServiceApplications() {
		mockServiceApplications = new ArrayList<ServiceApplication>();
		ServiceApplication pasaLoad = new ServiceApplication();
		pasaLoad.setTitle("Pasa Load");
		pasaLoad.setDescription("Load Transfer");
		pasaLoad.setServiceNumber("2");
		pasaLoad.setServiceType("TEXT");
		pasaLoad.setAppendMobileToServiceNumber(true);
		pasaLoad.setActivePromo(true);
		
		InputParams amount = new InputParams();
		amount.setItemType("STRING");
		amount.setLiteralValue(null);
		amount.setPromptMessage("Pasaload amount");
		
		
		InputParams space = new InputParams();
		space.setItemType("STRING");
		space.setLiteralValue(" ");
		
		InputParams password = new InputParams();
		password.setItemType("STRING");
		password.setLiteralValue(null);
		password.setPromptMessage("Pasaload Password");
		
		List<InputParams> pasaLoadkeywords = new ArrayList<InputParams>();
		
		pasaLoadkeywords.add(amount);
		pasaLoadkeywords.add(space);
		pasaLoadkeywords.add(password);
		
		pasaLoad.setKeywordItems(pasaLoadkeywords);
		
		mockServiceApplications.add(pasaLoad);
		
		ServiceApplication balInquiry = new ServiceApplication();
		balInquiry.setTitle("Balance Inquiry");
		balInquiry.setDescription("Balance Inquiry");
		balInquiry.setServiceNumber("222");
		balInquiry.setServiceType("TEXT");
		balInquiry.setAppendMobileToServiceNumber(false);
		balInquiry.setActivePromo(true);
		
		List<InputParams> balInquiryKeywords = new ArrayList<InputParams>();
		
		InputParams balKeyword = new InputParams();
		balKeyword.setItemType("STRING");
		balKeyword.setLiteralValue("Bal");
		
		balInquiryKeywords.add(balKeyword);
		
		balInquiry.setKeywordItems(balInquiryKeywords);
		
		mockServiceApplications.add(balInquiry);
		
		ServiceApplication tenCentsPerSecondCall = new ServiceApplication();
		tenCentsPerSecondCall.setTitle("10c Per Seconds Call");
		tenCentsPerSecondCall.setDescription("10 cents per call Globe to Globe");
		tenCentsPerSecondCall.setServiceNumber("232");
		tenCentsPerSecondCall.setServiceType("CALL");
		tenCentsPerSecondCall.setAppendMobileToServiceNumber(true);
		tenCentsPerSecondCall.setActivePromo(true);
		
		mockServiceApplications.add(tenCentsPerSecondCall);
		
		ServiceApplication unlitxt20 = new ServiceApplication();
		unlitxt20.setTitle("Unlitxt20");
		unlitxt20.setDescription("Unli for 1 day");
		unlitxt20.setServiceNumber("8888");
		unlitxt20.setServiceType("TEXT");
		unlitxt20.setAppendMobileToServiceNumber(false);
		unlitxt20.setActivePromo(true);
		
		List<InputParams> unlitxtKeywords = new ArrayList<InputParams>();
		
		InputParams unlitxtKeyword = new InputParams();
		unlitxtKeyword.setItemType("STRING");
		unlitxtKeyword.setLiteralValue("unlitxt20");
		unlitxtKeywords.add(unlitxtKeyword);
		
		unlitxt20.setKeywordItems(unlitxtKeywords);
		
		mockServiceApplications.add(unlitxt20);
	} 
	
}
