package com.itrip.activity;

import synjones.common.extension.StringUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.itrip.R;
import com.itrip.common.SuperActivity;

public class RegisterActivity extends SuperActivity
{
	private EditText edt_username;
	private EditText edt_password;
	private Button btn_register;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}

	private void SetUpView()
	{
		edt_password = (EditText) this.findViewById(R.id.edt_password);
		edt_username = (EditText) this.findViewById(R.id.edt_username);
		btn_register = (Button) this.findViewById(R.id.btn_register);
	}

	private void setListener()
	{
		btn_register.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View arg0)
			{
				// TODO Auto-generated method stub
				String usernameString = edt_username.getText().toString();
				String passwordString = edt_password.getText().toString();
				if (StringUtil.isNullOrEmpty(usernameString)
						|| StringUtil.isNullOrEmpty(passwordString))
				{
					openDialog("提示信息", "用户名或密码不能为空", R.drawable.dialog_error);
				}
			}
		});
	}
}
