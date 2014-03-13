package com.itrip.service;

import org.json.JSONObject;

import synjones.common.extension.StringUtil;
import synjones.core.domain.ComResult;

public class BaseService
{
	protected final String successTag = "success";
	protected final String msgTag = "msg";
	protected final String objTag = "obj";
	protected final String nullTag = "null";
	protected final String netException = "网络异常，请稍后再试";
	protected final String systemException = "系统异常，请稍后再试";

	public ComResult GetResultFromNormalJsonString(String josnString)
	{
		ComResult result = null;
		try
		{
			if (StringUtil.isNullOrEmpty(josnString))
			{
				result = new ComResult(false, netException);
			} else
			{
				JSONObject jsonObject = new JSONObject(josnString);
				result = new ComResult(jsonObject.getBoolean(successTag),
						jsonObject.getString(msgTag));
				try
				{
					Object object = jsonObject.get(objTag);
					result.setObject(object);
				} catch (Exception e)
				{
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		} catch (Exception e)
		{
			result = new ComResult(false, "json数据解析错误");
		}
		return result;
	}

	public ComResult GetResultFromNormalJsonObj(JSONObject jsonObject)
	{
		ComResult result = null;
		try
		{
			if (jsonObject == null)
			{
				result = new ComResult(false, netException);
			} else
			{

				result = new ComResult(jsonObject.getBoolean(successTag),
						jsonObject.getString(msgTag));
				try
				{
					Object object = jsonObject.get(objTag);
					result.setObject(object);
				} catch (Exception e)
				{
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		} catch (Exception e)
		{
			result = new ComResult(false, "json数据解析错误");
		}
		return result;
	}
}
