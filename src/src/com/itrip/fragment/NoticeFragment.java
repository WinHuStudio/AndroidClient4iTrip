package com.itrip.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.itrip.R;
import com.itrip.common.SuperFragment;

public class NoticeFragment extends SuperFragment {
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_notice, null);
		return view;

		// return super.onCreateView(inflater, container, savedInstanceState);
	}

	private void SetUpView() {
		Button btnSendNotice = (Button) view.findViewById(R.id.btn_sendNotice);
		btnSendNotice.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
	}
}
