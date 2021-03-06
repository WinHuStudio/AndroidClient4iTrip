package com.itrip.fragment;

import roboguice.inject.InjectView;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.itrip.R;
import com.itrip.common.SuperFragment;
import com.itrip.utils.Const;

public class DemoFragment extends SuperFragment implements OnClickListener {
	private String Tag = "DemoFragment";
	private View view;
	@InjectView(R.id.btn_startService)
	Button btnStartButton;
	@InjectView(R.id.btn_stopService)
	Button btnStopButton;
	@InjectView(R.id.btn_bindService)
	Button btnBindButton;
	@InjectView(R.id.btn_unbindService)
	Button btnUnbindButton;
	@InjectView(R.id.btn_senBroadcast)
	Button btn_broadcastButton;
	private boolean isBind = false;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i("DemoFragment", "onCreateView");
		view = inflater.inflate(R.layout.fragment_demo, null);
		super.onCreateView(inflater, container, savedInstanceState);
		// SetUpView();
		return view;
		// return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onViewCreated(view, savedInstanceState);
		SetUpView();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.i("DemoFragment", "OnCreate");
		super.onCreate(savedInstanceState);
		// SetUpView();
	}

	private void SetUpView() {
		btnStartButton.setText("1111");
		// btnStartButton = (Button) view.findViewById(R.id.btn_startService);
		// btnStopButton = (Button) view.findViewById(R.id.btn_stopService);
		// btnBindButton = (Button) view.findViewById(R.id.btn_bindService);
		// btnUnbindButton = (Button) view.findViewById(R.id.btn_unbindService);
		btnStartButton.setOnClickListener(this);
		btnStopButton.setOnClickListener(this);
		btnBindButton.setOnClickListener(this);
		btnUnbindButton.setOnClickListener(this);
		//
		// // 广播
		// // Button btn_broadcastButton = (Button) view
		// // .findViewById(R.id.btn_senBroadcast);
		// btn_broadcastButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.btn_startService:
			StartService();
			break;
		case R.id.btn_stopService:
			StopService();
			break;
		case R.id.btn_bindService:
			bindService();
			break;
		case R.id.btn_unbindService:
			unbindService();
			break;
		case R.id.btn_senBroadcast:
			sendBroadCast();
			break;
		default:
			break;
		}

	}

	private void sendBroadCast() {
		Intent intent = new Intent();
		intent.setAction(Const.myBroadcastAction);
		intent.putExtra("msg", "地瓜地瓜,我是土豆，收到请回复");
		getActivity().sendBroadcast(intent);
	}

	private void StartService() {
		Intent intent = new Intent();
		intent.setAction(Const.myServiceAction);
		getActivity().startService(intent);
	}

	private void StopService() {
		Intent intent = new Intent();
		intent.setAction(Const.myServiceAction);
		getActivity().stopService(intent);
	}

	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.i(Tag, "onServiceDisconnected.................");
			Toast.makeText(getActivity(), "onServiceDisconnected", 0).show();
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.i(Tag, "onServiceConnected.................");
			Toast.makeText(getActivity(), "onServiceConnected", 0).show();
		}
	};

	private void bindService() {
		Intent intent = new Intent();
		intent.setAction(Const.myServiceAction);
		getActivity().bindService(intent, connection, Service.BIND_AUTO_CREATE);
		isBind = true;
	}

	private void unbindService() {

		if (isBind) {
			isBind = false;
			Intent intent = new Intent();
			intent.setAction(Const.myServiceAction);
			getActivity().unbindService(connection);
		} else {
			Toast.makeText(getActivity(), "未绑定，请先绑定", Toast.LENGTH_LONG).show();
		}
	}

}
