package com.itrip.activity;

import roboguice.inject.InjectView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.androidquery.AQuery;
import com.itrip.R;
import com.itrip.common.SuperActivity;

public class LoginActivity extends SuperActivity
{

	@InjectView(R.id.et_login_username)
	EditText usernameEditText;
	@InjectView(R.id.et_login_pwd)
	EditText passwordEditText;

	@InjectView(R.id.btnLogin)
	Button btnloginButton;
	@InjectView(R.id.btnToRegister)
	Button registerButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

	}

	private void SetUpView()
	{
		AQuery aQuery = new AQuery(LoginActivity.this);
		// aQuery.id(R.id.btnLogin).clicked(handler, method)
	}
}
