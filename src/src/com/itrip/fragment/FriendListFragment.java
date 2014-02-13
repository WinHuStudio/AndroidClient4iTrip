package com.itrip.fragment;

import java.util.ArrayList;
import java.util.List;

import synjones.common.extension.DateHelper;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.itrip.R;
import com.itrip.activity.TalkActivity;
import com.itrip.adapter.FriendListAdapter;
import com.itrip.common.SuperFragment;
import com.itrip.models.Friend;

public class FriendListFragment extends SuperFragment implements
		OnClickListener
{
	private View view;
	private ListView gv;
	private ImageView testImageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.fragment_friendlist, null);
		setUpView();
		setData();
		return view;
	}

	private void setUpView()
	{
		gv = (ListView) view.findViewById(R.id.gv_friendlist);
		// ScrollListView mScrollView = (ScrollListView) view
		// .findViewById(R.id.friend_scrollView);
		// testImageView = (ImageView) view.findViewById(R.id.testimageview);
		// mScrollView.setImageView(testImageView);
		gv.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3)
			{
				// TODO Auto-generated method stub
				TextView txt_nameTextView = (TextView) arg1
						.findViewById(R.id.friend_txt_name);
				String nameString = txt_nameTextView.getText().toString();
				Intent intent = new Intent();
				intent.setClass(getActivity(), TalkActivity.class);
				intent.putExtra("username", nameString);
				startActivity(intent);
			}
		});
	}

	private void setData()
	{
		List<Friend> friends = getFriends();
		gv.setAdapter(new FriendListAdapter(friends, getActivity()));
	}

	@Override
	public void onClick(View v)
	{
		// TODO Auto-generated method stub

	}

	private List<Friend> getFriends()
	{
		List<Friend> list = new ArrayList<Friend>();
		for (int i = 0; i < 10; i++)
		{
			Friend friend = new Friend();
			friend.setDesc("测试" + i);
			friend.setName("姓名" + i);
			friend.setLatestTime(DateHelper.GetCurrentDay());
			friend.setLatestTalk("上次说了...");
			friend.setPic("/pic/" + i);
			list.add(friend);
		}
		return list;
	}
}
