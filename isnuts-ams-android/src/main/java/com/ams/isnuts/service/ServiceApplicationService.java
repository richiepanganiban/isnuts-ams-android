package com.ams.isnuts.service;

import android.content.Context;

import com.ams.isnuts.model.ServiceApplication;

public interface ServiceApplicationService {
	
	void sendServiceSms(Context context, ServiceApplication serviceApplication);
	
	void callService(Context context, ServiceApplication serviceApplication) throws MobileNumberFormatException;

}
