package com.itrip.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.itrip.R;

public class MyProgresss extends AlertDialog
{
	TextView textview;
	Context context;

	public MyProgresss(Context context)
	{
		super(context, R.style.dialog_Translucent_NoTitle);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.progressbar);

	}

}
