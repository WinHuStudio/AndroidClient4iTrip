package com.itrip.activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import roboguice.inject.InjectView;
import synjones.common.utils.DebugLog;
import synjones.core.domain.ComResult;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.itrip.R;
import com.itrip.common.SuperActivity;
import com.itrip.service.AccountService;
import com.itrip.utils.Const;

public class LoginActivity extends SuperActivity
{
	private AQuery aQuery;
	@InjectView(R.id.et_login_username)
	TextView usernameEditText;
	@InjectView(R.id.et_login_pwd)
	TextView passwordEditText;

	// @InjectView(R.id.btnLogin)
	// Button btnloginButton;
	@InjectView(R.id.btnToRegister)
	Button registerButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		aQuery = new AQuery(this);
		usernameEditText.setText("admin");
		passwordEditText.setText("888888");
		SetUpView();
		// usernameEditText.setText("123123");
		// login(this);

	}

	private void SetUpView()
	{
		aQuery.id(R.id.btnLogin).clicked(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				login();
			}
		});
		aQuery.id(R.id.btnToRegister).clicked(this, "ToRegister");

	}

	public void ToRegister()
	{
		ShowAcitivity(RegisterActivity.class);
	}

	public void login()
	{
		showDialog();
		Map<String, String> params = new HashMap<String, String>();
		params.put("account", usernameEditText.getText().toString());
		params.put("password", passwordEditText.getText().toString());
		params.put("signType", "SynDream");
		aQuery.ajax(Const.SignInUrlString, params, JSONObject.class,
				new AjaxCallback<JSONObject>()
				{
					@Override
					public void callback(String url, JSONObject object,
							AjaxStatus status)
					{// 回调函数
						// TODO Auto-generated method stub
						super.callback(url, object, status);
						DebugLog.i("jsonreturn", object);
						AccountService service = new AccountService();
						ComResult result = service
								.GetResultFromNormalJsonObj(object);
						if (result.isSuccess())
						{
							ShowAcitivity(MainActivity.class);
						} else
						{
							Toast.makeText(LoginActivity.this,
									result.getMessage(), Toast.LENGTH_LONG)
									.show();
						}
						// registerButton.setText("123");
						dialogDismiss();
					}
				});
	}
}
