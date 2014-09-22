package com.beerbubble.firstandroidapp;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.actionbarsherlock.app.SherlockFragmentActivity;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {
    
	public MainActivity() {
		super(R.string.app_name);
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
    	//setSlidingActionBarEnabled(true);
        
        setContentView(R.layout.activity_main);
        

    }


    @Override
    public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
    	return onCreateOptionsMenu(menu);
    }
    
}
