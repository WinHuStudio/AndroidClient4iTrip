package com.itrip.activity;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import com.itrip.R;

public class TestActivity extends RoboActivity {

	@InjectView(R.id.txt_text)
	TextView sysTextView;

	@InjectResource(R.drawable.bg)
	Drawable bg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		sysTextView.setText("11111");
	}
}
