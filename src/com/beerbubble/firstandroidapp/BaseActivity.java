package com.beerbubble.firstandroidapp;

import com.beerbubble.firstandroidapp.R;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }
    
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		
		final LayoutInflater factory = getLayoutInflater();

		final View baseactivity_threepart = factory.inflate(R.layout.baseactivity_threepart, null);
		
		final RelativeLayout body_Layout = (RelativeLayout)baseactivity_threepart.findViewById(R.id.body_Layout);
		
		final View v = factory.inflate(layoutResID, null);
		
		body_Layout.addView(v);
		
		super.setContentView(baseactivity_threepart);
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
