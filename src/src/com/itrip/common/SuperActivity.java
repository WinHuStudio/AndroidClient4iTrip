package com.itrip.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import roboguice.activity.RoboActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.itrip.R;
import com.itrip.widget.MyProgresss;

public abstract class SuperActivity extends RoboActivity
{
	protected TextView txt_Title;
	protected ImageView image_back;
	protected ImageView image_set;
	protected static final int ProgressMy = 1;// 自定义对话框
	protected Dialog mdialog = null;

	public boolean isNetWorkConnected()
	{
		NetworkInfo localNetworkInfo = ((ConnectivityManager) getSystemService("connectivity"))
				.getActiveNetworkInfo();
		return (localNetworkInfo != null) && (localNetworkInfo.isConnected());
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	protected Dialog onCreateDialog(int id)
	{

		switch (id)
		{
			case ProgressMy: // system
				MyProgresss myDialog = new MyProgresss(getThisContext());
				myDialog.setCancelable(true);
				mdialog = myDialog;
				break;

		}
		return mdialog;
	}

	private Activity getThisContext()
	{
		if (getParent() != null)
		{
			return getParent();
		} else
		{
			return this;
		}
	}

	protected void dialogDismiss()
	{
		if (mdialog != null && mdialog.isShowing())
		{
			dismissDialog(ProgressMy);
		}
	}

	protected void showDialog()
	{
		showDialog(ProgressMy);
	}

	protected void ShowAcitivity(Class<?> clss)
	{
		Intent intent = new Intent();
		intent.setClass(SuperActivity.this, clss);
		startActivity(intent);
	}

	// private final static boolean PRINT_LOG = true;
	// protected MyApplication myApplication;
	// private int startX = 0;
	// private long startTime = 0L;
	// private int endX = 0;
	// protected int px_width;
	// protected int px_height;
	// protected int windowWidth;
	// protected int windowHeight;
	// protected static final int ProgressMy = 1;// 自定义对话框
	// protected ImageButton ib_back;
	// protected ImageButton ib_type;
	// protected ImageView iv_title;
	// protected LinearLayout ll_bg;
	// protected ImageView iv_icon;
	//
	// @Override
	// protected void onCreate(Bundle savedInstanceState)
	// {
	// super.onCreate(savedInstanceState);
	// myApplication = (MyApplication) getApplication();
	// int[] screenSize = ScreenSizeUtil.getScreenSize(this);
	// px_width = screenSize[0];
	// px_height = screenSize[1];
	//
	// int[] windowSize = ScreenSizeUtil.getWindowSize(this);
	// windowWidth = windowSize[0];
	// windowHeight = windowSize[1];
	// setUpView();
	// setListener();
	// initData();
	//
	// }
	//
	// protected void adapterView(boolean isAdaptMore)
	// {
	// if (isAdaptMore)
	// {
	// ll_bg = (LinearLayout) findViewById(R.id.ll_header_function_bg);
	// iv_icon = (ImageView) findViewById(R.id.iv_header_function_icon);
	//
	// AdaptViewUitl.AdaptSpecialView(this, ll_bg, 518f, "LinearLayout");
	// AdaptViewUitl.AdaptSmallView(this, iv_icon, 268, 273.0f, "LinearLayout");
	// }
	// iv_title = (ImageView) findViewById(R.id.iv_header_title);
	// ib_back = (ImageButton) findViewById(R.id.ib_header_back);
	// ib_type = (ImageButton) findViewById(R.id.ib_header_type);
	//
	// AdaptViewUitl.AdaptHugeView(this, iv_title, 992f, 137.0f, "FrameLayout");
	// AdaptViewUitl.AdaptSmallView(this, ib_back, 76, 55.0f, "LinearLayout");
	// AdaptViewUitl.AdaptSmallView(this, ib_type, 66, 67.0f, "LinearLayout");
	// }
	//
	// protected abstract void setUpView();
	//
	// protected abstract void setListener();
	//
	// protected abstract void initData();
	//
	// @Override
	// protected Dialog onCreateDialog(int id)
	// {
	// Dialog dialog = null;
	// switch (id)
	// {
	// case ProgressMy: // system
	// MyProgresss myDialog = new MyProgresss(getThisContext());
	// myDialog.setCancelable(true);
	// dialog = myDialog;
	// break;
	//
	// }
	// return dialog;
	// }
	//
	// private Activity getThisContext()
	// {
	// if (getParent() != null)
	// {
	// return getParent();
	// } else
	// {
	// return this;
	// }
	// }
	//
	// public void startActivity(Intent intent, boolean isAnimation)
	// {
	// super.startActivity(intent);
	// if (isAnimation)
	// {
	// overridePendingTransition(R.anim.in_to_left, R.anim.out_to_right);
	// }
	// }
	//
	// public void startActivityForResult(Intent intent, int requestCode,
	// boolean isAnimation)
	// {
	// super.startActivityForResult(intent, requestCode);
	// if (isAnimation)
	// {
	// overridePendingTransition(R.anim.in_to_left, R.anim.out_to_right);
	// }
	// }
	//
	// public void setResult(Intent intent, int resultCode, boolean isAnimation)
	// {
	// super.setResult(resultCode, intent);
	// finish(isAnimation);
	// }
	//
	// public void finish(boolean isAnimation)
	// {
	// super.finish();
	// if (isAnimation)
	// {
	// overridePendingTransition(R.anim.exit_from_right, R.anim.exit_to_left);
	// }
	// }
	//
	// public static void log_e(String tag, String msg)
	// {
	// if (PRINT_LOG)
	// {
	// Log.e(tag, msg);
	// }
	// }
	//
	// public static void log_i(String tag, String msg)
	// {
	// if (PRINT_LOG)
	// {
	// LogUtil.i(tag, msg);
	// }
	// }
	//
	// @Override
	// public boolean onTouchEvent(MotionEvent event)
	// {
	// switch (event.getAction())
	// {
	// case MotionEvent.ACTION_DOWN:
	// startTime = System.currentTimeMillis();
	// startX = (int) event.getRawX();
	// break;
	// case MotionEvent.ACTION_MOVE:
	// endX = (int) event.getRawX();
	// // 两个判断，1、滑动的距离，这里按大于屏幕的1/4 。2、滑动的时间小于1秒
	// if (endX - startX > getWindowManager().getDefaultDisplay().getWidth() / 5
	// && System.currentTimeMillis() - startTime < 1000l)
	// {
	// // finish(true);
	// }
	// break;
	// case MotionEvent.ACTION_UP:
	//
	// break;
	// }
	// return true;
	// }
	//
	// @Override
	// protected void onStop()
	// {
	// // TODO Auto-generated method stub
	// super.onStop();
	// }
	//
	// public void showActivity(Context context, Class<?> clazz)
	// {
	// // TODO Auto-generated method stub
	// Intent intent = new Intent();
	// intent.setClass(context, clazz);
	// startActivity(intent);
	//
	// }
	//
	// // 判断是否登录
	// protected boolean isLogin(boolean isNeedLogin)
	// {
	// // String account = GetAccount();
	// // String pwd = getAppInfo(PASSWORD);
	// String tokenString = GetToken();
	// if (isNeedLogin)
	// {
	// if (!StringUtil.isNullOrEmpty(tokenString))
	// {
	//
	// // 去服务器验证是否登陆或登陆是否过期
	// // AccountServiceImpl serviceImpl = new
	// // AccountServiceImpl(MyApplication.getBaseURL());
	// // ComResult result = serviceImpl.IsSignIn(tokenString);
	// // boolean falg = result.isSuccess();
	// // if (!falg)
	// // Toast.makeText(BaseActivity.this, result.getMessage(),
	// // Toast.LENGTH_LONG).show();
	// // return falg;
	// return true;
	// } else
	// {
	// return false;
	// }
	// } else
	// {
	// return true;
	// }
	//
	// }
	//
	// protected SystemUser GetUser()
	// {
	// Object object = ((MyApplication) getApplication()).get("systemUser");
	// if (object != null)
	// return (SystemUser) (object);
	// else
	// return null;
	// }
	//
	// protected String GetSno()
	// {
	// SystemUser user = GetUser();
	// if (user != null)
	// return user.Sno;
	// else
	// return null;
	//
	// }
	//
	// protected int GetID()
	// {
	// SystemUser user = GetUser();
	// if (user != null)
	// return user.id;
	// else
	// return 0;
	//
	// }
	//
	// protected String GetName()
	// {
	// SystemUser user = GetUser();
	// if (user != null)
	// return user.Name;
	// else
	// return null;
	//
	// }
	//
	// protected String GetAccount()
	// {
	// SystemUser user = GetUser();
	// if (user != null)
	// return user.Account;
	// else
	// return null;
	//
	// }
	//
	// /**
	// * 获取登录账户的校园卡号
	// *
	// * @return 校园卡号
	// */
	// protected String GetCardNo()
	// {
	// SystemUser user = GetUser();
	// if (user != null)
	// return user.CardNo;
	// else
	// return null;
	// // return "1100";
	// }
	//
	// protected String GetSchoolCode()
	// {
	// if (MyApplication.schoolInfo != null)
	// return MyApplication.schoolInfo.getSchoolCode();
	// else
	// return "";
	// }
	//
	// /**
	// * Description:获取登录后的票据
	// *
	// * @return
	// * @author pjc
	// * @Create at: 2013-8-17 下午11:45:49
	// */
	// public String GetToken()
	// {
	// return getAppInfo(Const.COOKIEKEY);
	// }
	//
	// // 获取登录成功后保存在Application（Map集合）中的账号和密码所对应的值。
	//
	// protected String getAppInfo(String param)
	// {
	//
	// Object object = getAppValue(param);
	// if (object != null)
	// return object.toString();
	// else
	// return "";
	// }
	//
	// protected void setAppValue(String key, Object value)
	// {
	// ((MyApplication) getApplication()).put(key, value);
	// }
	//
	// protected Object getAppValue(String key)
	// {
	// return ((MyApplication) getApplication()).get(key);
	// }
	//
	// public String GetServerUrl()
	// {
	// return MyApplication.getBaseURL();
	// }
	//
	/**
	 * Description:提示对话框
	 * 
	 * @param title
	 *            对话框的标题
	 * @param msg
	 *            对话框提示内容
	 * @param icoint
	 *            对话框的图标
	 * @author pjc
	 * @Create at: 2013-7-24 上午9:30:56
	 */
	public void openDialog(String title, String msg, int icoint)
	{
		new AlertDialog.Builder(this).setIcon(R.drawable.ic_launcher)
				.setTitle(title).setMessage(msg).setIcon(icoint)
				.setPositiveButton("确认", new DialogInterface.OnClickListener()
				{

					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						dialog.dismiss();
						// Intent intent=new Intent(context, getClass())
					}
				}).show();
	}

	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;

	/** Create a file Uri for saving an image or video */
	public static Uri getOutputMediaFileUri(int type)
	{
		return Uri.fromFile(getOutputMediaFile(type));
	}

	/** Create a File for saving an image or video */
	public static File getOutputMediaFile(int type)
	{
		// To be safe, you should check that the SDCard is mounted
		// using Environment.getExternalStorageState() before doing this.

		File mediaStorageDir = new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				"MyCameraApp");
		// This location works best if you want the created images to be shared
		// between applications and persist after your app has been uninstalled.

		// Create the storage directory if it does not exist
		if (!mediaStorageDir.exists())
		{
			if (!mediaStorageDir.mkdirs())
			{
				Log.d("MyCameraApp", "failed to create directory");
				return null;
			}
		}

		// Create a media file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date());
		File mediaFile;
		if (type == MEDIA_TYPE_IMAGE)
		{
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "IMG_" + timeStamp + ".jpg");
		} else if (type == MEDIA_TYPE_VIDEO)
		{
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "VID_" + timeStamp + ".mp4");
		} else
		{
			return null;
		}
		Log.i("SuperActivity", (mediaFile != null) + "");
		return mediaFile;
	}
	// protected String Encrypt(String pwd)
	// {
	//
	// // String newpwd;
	// //
	// // newpwd = URLEncoder.encode(CrptHelper.EnCrypt(pwd));
	// // // newpwd = Base64.encodeToString(pwd.getBytes("utf-8"),
	// // // Base64.DEFAULT);
	// // // String newpwd2 = org.kobjects.base64.Base64.encode(pwd
	// // // .getBytes("utf-8"));
	// // // org.kobjects.base64.Base64.encode(data)
	// // Log.i("password", newpwd);
	// // return newpwd;
	//
	// return pwd;
	// // return newpwd;
	// }

}
