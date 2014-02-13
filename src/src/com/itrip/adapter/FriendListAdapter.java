package com.itrip.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itrip.R;
import com.itrip.models.Friend;

public class FriendListAdapter extends BaseAdapter
{
	private final List<Friend> friends;
	private final LayoutInflater inflater;
	private final Context context;

	public FriendListAdapter(List<Friend> friends, Context context)
	{
		this.friends = friends;
		this.context = context;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount()
	{
		// TODO Auto-generated method stub
		return friends.size();
	}

	@Override
	public Object getItem(int arg0)
	{
		// TODO Auto-generated method stub
		return friends.get(arg0);
	}

	@Override
	public long getItemId(int arg0)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		// TODO Auto-generated method stub
		ViewHolder viewHolder = null;
		if (convertView == null)
		{
			convertView = inflater.inflate(R.layout.item_friendlist, null);
			viewHolder = new ViewHolder();
			viewHolder.imag_friend_pic = (ImageView) convertView
					.findViewById(R.id.friend_img_pic);
			viewHolder.tv_friend_name = (TextView) convertView
					.findViewById(R.id.friend_txt_name);
			viewHolder.tv_friend_latestTalk = (TextView) convertView
					.findViewById(R.id.friend_txt_latestTalk);
			viewHolder.tv_friend_latestTime = (TextView) convertView
					.findViewById(R.id.friend_txt_latestTime);
			convertView.setTag(viewHolder);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}
		Friend friend = friends.get(position);
		viewHolder.tv_friend_latestTalk.setText(friend.getLatestTalk());
		viewHolder.tv_friend_latestTime.setText(friend.getLatestTime());
		viewHolder.tv_friend_name.setText(friend.getName());
		Drawable drable = context.getResources().getDrawable(
				R.drawable.ic_launcher);
		viewHolder.imag_friend_pic.setBackgroundDrawable(drable);
		return convertView;
	}

	public static class ViewHolder
	{
		public ImageView imag_friend_pic;
		public TextView tv_friend_name;
		public TextView tv_friend_latestTalk;
		public TextView tv_friend_latestTime;
		// public TextView tv_friend_name;

	}
}
