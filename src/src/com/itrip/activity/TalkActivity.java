package com.itrip.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.itrip.R;
import com.itrip.common.SuperActivity;

public class TalkActivity extends SuperActivity implements OnClickListener
{
	// private TextView textView_username;
	private Button btn_sendButton;
	private ImageButton img_select;
	private ImageButton img_video;
	private EditText txt_input;

	private final int Medio_Picture_Result = 100;
	private final int Medio_Audio_Result = 200;
	private Uri fileUri;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_talk);

		setUpView();
		setClickListener();
		setData();
	}

	private void setUpView()
	{
		txt_Title = (TextView) this.findViewById(R.id.header_txt_title);
		btn_sendButton = (Button) this.findViewById(R.id.talk_btn_send);
		img_select = (ImageButton) this.findViewById(R.id.footter_img_select);
		img_video = (ImageButton) this.findViewById(R.id.footter_img_video);
		txt_input = (EditText) this.findViewById(R.id.talk_txt_input);
	}

	private void setClickListener()
	{
		btn_sendButton.setOnClickListener(this);
		img_select.setOnClickListener(this);
		img_video.setOnClickListener(this);
	}

	private void setData()
	{
		String usernameString = getIntent().getExtras().get("username")
				.toString();
		txt_Title.setText(usernameString);
	}

	@Override
	public void onClick(View arg0)
	{
		// TODO Auto-generated method stub
		switch (arg0.getId())
		{
			case R.id.footter_img_select:
				TakePhoto();
				break;
			case R.id.footter_img_video:
				TakeVideo();
				break;
			default:
				break;
		}
	}

	public void TakePhoto()
	{
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
		startActivityForResult(intent, Medio_Picture_Result);
	}

	public void TakeVideo()
	{
		Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
		intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
		startActivityForResult(intent, Medio_Audio_Result);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		// TODO Auto-generated method stub
		// super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode)
		{
			case Medio_Picture_Result:
				if (resultCode == RESULT_OK)
				{
					Toast.makeText(this, "Image saved to:\n" + data.getData(),
							Toast.LENGTH_LONG).show();
				}
				break;
			case Medio_Audio_Result:
				if (resultCode == RESULT_OK)
				{
					Toast.makeText(this, "Video saved to:\n" + data.getData(),
							Toast.LENGTH_LONG).show();
				}
			default:
				break;
		}
	}
}
