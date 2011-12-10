package com.xtremelabs.socialalarm;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.xtremelabs.socialalarm.util.FacebookUtil;
import com.xtremelabs.socialalarm.util.FacebookUtil.FacebookTaskListener;

public class LaunchActivity extends Activity {
	private static final String TAG = "LaunchActivity";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViewById(R.id.fbLoginButton).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				FacebookUtil.loginToFacebook(LaunchActivity.this, mLoginListener);
			}
		});
	}

	private FacebookUtil.FacebookTaskListener mLoginListener = new FacebookTaskListener() {

		@Override
		public void onComplete() {
			Toast.makeText(LaunchActivity.this, "Login complete - posting", Toast.LENGTH_SHORT).show();
			// Next screen
		}
	};

	public void onLaunchDismissAlarmActivityButtonPress(View view) {
		startActivity(new Intent(this, DismissAlarmActivity.class));
	}

	public void onSetAlarmButtonPress(View view) {
		Log.v(TAG, "set alarm button press");
		AlarmReceiver.setAlarm(this, 5);
	}

}