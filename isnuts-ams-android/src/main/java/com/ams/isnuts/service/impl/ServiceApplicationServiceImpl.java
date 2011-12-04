package com.ams.isnuts.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;

import com.ams.isnuts.model.InputParams;
import com.ams.isnuts.model.ServiceApplication;
import com.ams.isnuts.service.MobileNumberFormatException;
import com.ams.isnuts.service.ServiceApplicationService;
import com.ams.isnuts.util.SmsSender;

import de.akquinet.android.androlog.Log;

public class ServiceApplicationServiceImpl implements ServiceApplicationService {

	public void sendServiceSms(Context context, ServiceApplication serviceApplication) {
		String composedMessage = composeSmsMessage(context, serviceApplication);
		String serviceNumber = serviceApplication.getServiceNumber();
		SmsSender.sendSms(context, serviceNumber, composedMessage);
	}

	private String composeSmsMessage(Context context, ServiceApplication serviceApplication) {
		List<InputParams> inputParams = serviceApplication.getKeywordItems();
		final StringBuilder stringBuilder = new StringBuilder();
		for(InputParams parameter : inputParams) {
			if(parameter.getLiteralValue() == null){
				AlertDialog.Builder inputDialog = new AlertDialog.Builder(context);

				inputDialog.setTitle("Add Parameter");
				inputDialog.setMessage(parameter.getPromptMessage());
				final EditText input = new EditText(context);
				inputDialog.setView(input);

				inputDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
				  stringBuilder.append(input.getText().toString());
				  }
				});

				inputDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
				  public void onClick(DialogInterface dialog, int id) {
				    dialog.cancel();
				  }
				});

				inputDialog.show();
			} else {
				stringBuilder.append(parameter.getLiteralValue());
			}
		}
		return stringBuilder.toString();
	}

	public void callService(Context context, ServiceApplication serviceApplication) throws MobileNumberFormatException {
		String mobileNumber = parseMobileNumber(serviceApplication);
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("tel:");
		stringBuilder.append(serviceApplication.getServiceNumber());
		stringBuilder.append(mobileNumber);
		
		try {
			Intent callIntent = new Intent(Intent.ACTION_CALL);
			callIntent.setData(Uri.parse(stringBuilder.toString()));
			context.startActivity(callIntent);
		} catch (ActivityNotFoundException activityException) {
			Log.e("AmsMainActivity is not found.", "Call failed",
					activityException);
		}

	}

	private String parseMobileNumber(ServiceApplication serviceApplication)
			throws MobileNumberFormatException {
		
		String mobileNumber = serviceApplication.getTargetMobileNumber();
		
		if(mobileNumber.length() > 13 || mobileNumber.length() < 9) {
			throw new MobileNumberFormatException("Invalid mobile number format.");
		}

		String trimmedMobileNumber = "";
		
		if(serviceApplication.isAppendMobileToServiceNumber()) {
			Pattern p = Pattern.compile("9(\\d{9})");
			Matcher m = p.matcher(mobileNumber);
			while(m.find()) {
				trimmedMobileNumber = m.group();
			}
			
			if(trimmedMobileNumber == null) {
				throw new MobileNumberFormatException("Invalid mobile number format.");
			}
		}
		return trimmedMobileNumber;
	}

}
