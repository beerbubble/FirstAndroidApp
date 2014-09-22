package com.beerbubble.firstandroidapp;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.MenuItem;
import com.beerbubble.firstandroidapp.R;
import com.beerbubble.firstandroidapp.R.color;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BaseActivity extends SlidingFragmentActivity {

	private int mTitleRes;
	protected Fragment mFrag;
	
	public BaseActivity(int titleRes) {
		mTitleRes = titleRes;
	}

	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView(R.layout.activity_main);
        
        
		// set the Behind View
		setBehindContentView(R.layout.menu_frame);
		if (savedInstanceState == null) {
			FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
			mFrag = new MenuFragment();
			t.replace(R.id.menu_frame, mFrag);
			t.commit();
		} else {
			mFrag = (ListFragment)this.getSupportFragmentManager().findFragmentById(R.id.menu_frame);
		}

		// customize the SlidingMenu
		final SlidingMenu sm = getSlidingMenu();
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setFadeDegree(0.35f);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		
		final LayoutInflater factory = getLayoutInflater();

		final View baseactivity_threepart = factory.inflate(R.layout.baseactivity_threepart, null);
		
		final RelativeLayout body_Layout = (RelativeLayout)baseactivity_threepart.findViewById(R.id.body_Layout);
		
		final View v = factory.inflate(layoutResID, null);
		
		body_Layout.addView(v);
		
		super.setContentView(baseactivity_threepart);
		
		//Menu Click
		ImageView menu_img = (ImageView) findViewById(R.id.menu_img);
		menu_img.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				toggle();
			}
		});
		
		//Swich Tab
		final RelativeLayout home_layout = (RelativeLayout) findViewById(R.id.footer_home_Lin);
		final RelativeLayout menu_layout = (RelativeLayout) findViewById(R.id.footer_menu_Lin);
		final RelativeLayout stores_layout = (RelativeLayout) findViewById(R.id.footer_stores_Lin);
		
		final TextView home_text = (TextView)findViewById(R.id.footer_home_text);
		final TextView menu_text = (TextView)findViewById(R.id.footer_menu_text);
		final TextView stores_text = (TextView)findViewById(R.id.footer_stores_text);
		
		final ImageView home_bottomline = (ImageView)findViewById(R.id.footer_home_bottomline);
		final ImageView menu_bottomline = (ImageView)findViewById(R.id.footer_menu_bottomline);
		final ImageView stores_bottomline = (ImageView)findViewById(R.id.footer_stores_bottomline);
		
		home_layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				menu_text.setTextColor(getResources().getColor(R.color.white));
				menu_bottomline.setVisibility(View.GONE);
				stores_text.setTextColor(getResources().getColor(R.color.white));
				stores_bottomline.setVisibility(View.GONE);
				
				home_text.setTextColor(getResources().getColor(R.color.menutab));
				home_bottomline.setVisibility(View.VISIBLE);
			}
		});
		
		menu_layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				home_text.setTextColor(getResources().getColor(R.color.white));
				home_bottomline.setVisibility(View.GONE);
				stores_text.setTextColor(getResources().getColor(R.color.white));
				stores_bottomline.setVisibility(View.GONE);
				
				menu_text.setTextColor(getResources().getColor(R.color.menutab));
				menu_bottomline.setVisibility(View.VISIBLE);
			}
		});
		
		stores_layout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				menu_text.setTextColor(getResources().getColor(R.color.white));
				menu_bottomline.setVisibility(View.GONE);
				home_text.setTextColor(getResources().getColor(R.color.white));
				home_bottomline.setVisibility(View.GONE);
				
				stores_text.setTextColor(getResources().getColor(R.color.menutab));
				stores_bottomline.setVisibility(View.VISIBLE);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		switch (item.getItemId()) {
//		case android.R.id.home:
//			toggle();
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}
    
}
