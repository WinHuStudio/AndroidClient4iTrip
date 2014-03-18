package com.itrip.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidquery.AQuery;
import com.itrip.R;
import com.itrip.activity.TestActivity;
import com.itrip.common.SuperFragment;

public class SysConfigFragment extends SuperFragment
{
	private View view;
	private Button sys_btn_test;
	private AQuery aQuery;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_sysconfig, null);
		aQuery = new AQuery(getActivity());
		setUpView();
		setLinseter();
		return view;
	}

	private void setUpView()
	{
		sys_btn_test = (Button) view.findViewById(R.id.sys_btn_test);
		aQuery.id(R.id.img_test_btn)
				.image("http://d.hiphotos.baidu.com/image/w%3D2048/sign=6cf2267a9f16fdfad86cc1ee80b78d54/a9d3fd1f4134970afb53cd7e97cad1c8a7865dbb.jpg");
	}

	private void setLinseter()
	{
		sys_btn_test.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				startActivity(new Intent(getActivity(), TestActivity.class));
			}
		});
	}
}
