package com.ams.isnuts;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.ams.isnuts.mock.MockDataFactory;
import com.ams.isnuts.model.ActionItem;
import com.ams.isnuts.model.CustomServiceApplication;
import com.ams.isnuts.model.QuickAction;
import com.ams.isnuts.model.ServiceApplication;
import com.ams.isnuts.service.ServiceApplicationService;
import com.ams.isnuts.service.impl.ServiceApplicationServiceImpl;

import de.akquinet.android.androlog.Log;

public class AmsMainActivity extends Activity implements OnTouchListener {

	private List<CustomServiceApplication> favoriteServices = MockDataFactory.mockFavoriteApplications;
	private ArrayAdapter<CustomServiceApplication> favoritesAdapter;
	private ListView favoriteServicesListView;
	
	private List<ServiceApplication> serviceApplications = MockDataFactory.mockServiceApplications;
	private ArrayAdapter<ServiceApplication> callAndTextServicesAdapter;
	private ListView callAndTextServicesListView;
	
	private ServiceApplicationService serviceApplicationService = new ServiceApplicationServiceImpl();

	
	private float downXValue;
	
	private QuickAction serviceAppQuickAction;
	
	private QuickAction favoriteAppQuickAction;

//	private ServiceApplicationDao serviceDao = new SqliteServiceApplicationDao(
//			this);
//
//	private CategoriesDao categoriesDao = new SqliteCategoriesDao(this);
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.init();
		Log.i(this, "onCreate");
		setContentView(R.layout.main);
		
		RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayoutMain);
		relativeLayout.setOnTouchListener(this);
		
		favoriteServicesListView  = (ListView) findViewById(R.id.favoriteServicesList);
		favoriteServicesListView.setOnItemClickListener(useServiceOnItemClickListener);
		favoriteServicesListView.setOnItemLongClickListener(favoritesQuickActionOnItemLongClickListener);
		favoritesAdapter = new ArrayAdapter<CustomServiceApplication>(this,android.R.layout.simple_list_item_1, favoriteServices);
		favoriteServicesListView.setAdapter(favoritesAdapter);
		
		callAndTextServicesListView = (ListView) findViewById(R.id.callAndTextServicesList);
		callAndTextServicesListView.setOnItemClickListener(useServiceOnItemClickListener);
		callAndTextServicesListView.setOnItemLongClickListener(serviceApplicationOnItemLongClickListener);
		callAndTextServicesAdapter = new ArrayAdapter<ServiceApplication>(this,android.R.layout.simple_list_item_1, serviceApplications);
		callAndTextServicesListView.setAdapter(callAndTextServicesAdapter);
		
		ActionItem invokeService = new ActionItem();
		invokeService.setTitle("Use Service");
		invokeService.setIcon(getResources().getDrawable(R.drawable.ic_accept));

		ActionItem addToFavorites = new ActionItem();
		addToFavorites.setTitle("Add to Favorites");
		addToFavorites.setIcon(getResources().getDrawable(R.drawable.ic_add));
		serviceAppQuickAction = new QuickAction(this);
		
		serviceAppQuickAction.addActionItem(invokeService);
		serviceAppQuickAction.addActionItem(addToFavorites);
		serviceAppQuickAction.setOnActionItemClickListener(serviceAppQuickActionListener);
		
		ActionItem invokeFavoriteService = new ActionItem();
		invokeFavoriteService.setTitle("Use Service");
		invokeFavoriteService.setIcon(getResources().getDrawable(R.drawable.ic_accept));
		
		ActionItem editFavoriteService = new ActionItem();
		editFavoriteService.setTitle("Edit");
		editFavoriteService.setIcon(getResources().getDrawable(R.drawable.ic_up));

		
		ActionItem removeFromFavorites = new ActionItem();
		removeFromFavorites.setTitle("Remove");
		removeFromFavorites.setIcon(getResources().getDrawable(R.drawable.ic_add));
		
		favoriteAppQuickAction = new QuickAction(this);
		
		favoriteAppQuickAction.addActionItem(invokeFavoriteService);
		favoriteAppQuickAction.addActionItem(editFavoriteService);
		favoriteAppQuickAction.addActionItem(removeFromFavorites);
		
	}

	public boolean onTouch(View arg0, MotionEvent arg1) {
		switch (arg1.getAction()) {
		case MotionEvent.ACTION_DOWN: {
			downXValue = arg1.getX();
			break;
		}

		case MotionEvent.ACTION_UP: {
			float currentX = arg1.getX();
			if (downXValue < currentX) {
				ViewFlipper vf = (ViewFlipper) findViewById(R.id.flipper);
				vf.setAnimation(AnimationUtils.loadAnimation(this,
						R.anim.push_left_out));
				vf.showPrevious();
			}

			if (downXValue > currentX) {
				ViewFlipper vf = (ViewFlipper) findViewById(R.id.flipper);
				vf.setInAnimation(AnimationUtils.loadAnimation(this,
						R.anim.push_left_in));
				vf.showNext();
			}
			break;
		}
		}
		return true;
	}
	
	private OnItemLongClickListener serviceApplicationOnItemLongClickListener = new OnItemLongClickListener() {

		public boolean onItemLongClick(AdapterView<?> context, View view,
				int position, long id) {
//			Toast.makeText(AmsMainActivity.this,
//					"Item in position " + position + " clicked",
//					Toast.LENGTH_LONG).show();
			serviceAppQuickAction.show(view);
			serviceAppQuickAction.setAnimStyle(QuickAction.ANIM_GROW_FROM_CENTER);
			return true;
			
			
		}
	}; 
	
	private OnItemLongClickListener favoritesQuickActionOnItemLongClickListener = new OnItemLongClickListener() {

		public boolean onItemLongClick(AdapterView<?> context, View view,
				int position, long id) {
//			Toast.makeText(AmsMainActivity.this,
//					"Item in position " + position + " clicked",
//					Toast.LENGTH_LONG).show();
			favoriteAppQuickAction.show(view);
			favoriteAppQuickAction.setAnimStyle(QuickAction.ANIM_GROW_FROM_CENTER);
			return true;
		}
	}; 
	
	private QuickAction.OnActionItemClickListener favoriteAppQuickActionListener = new QuickAction.OnActionItemClickListener() {
		
		public void onItemClick(int pos) {
			if (pos == 0) { //Add item selected
				Toast.makeText(AmsMainActivity.this, "Invoke Service selected", Toast.LENGTH_SHORT).show();
			} else if (pos == 1) { //Accept item selected
				Toast.makeText(AmsMainActivity.this, "Add to favorites selected", Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	private QuickAction.OnActionItemClickListener serviceAppQuickActionListener = new QuickAction.OnActionItemClickListener() {			
		
		public void onItemClick(int pos) {
			
			if (pos == 0) { //Add item selected
				Toast.makeText(AmsMainActivity.this, "Invoke Service selected", Toast.LENGTH_SHORT).show();
			} else if (pos == 1) { //Accept item selected
				Toast.makeText(AmsMainActivity.this, "Add to favorites selected", Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	private OnItemClickListener useServiceOnItemClickListener = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> arg0, View arg1,
				final int position, long id) {
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AmsMainActivity.this);
			alertDialogBuilder.setMessage("Are you sure you want to use this service?");
			alertDialogBuilder.setCancelable(false);
			alertDialogBuilder.setPositiveButton("Yes",	new DialogInterface.OnClickListener() {
						
				public void onClick(DialogInterface dialog, int id) {
					ServiceApplication serviceApplication = (ServiceApplication) callAndTextServicesListView.getItemAtPosition(position);
					serviceApplicationService.sendServiceSms(AmsMainActivity.this, serviceApplication);
						}
					});

			alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
						
				public void onClick(DialogInterface dialog, int id) {
							dialog.cancel();
						}
					});
			alertDialogBuilder.create().show();
		};
	};

}
