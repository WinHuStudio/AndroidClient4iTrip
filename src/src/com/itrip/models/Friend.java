package com.itrip.models;

public class Friend extends BaseModel
{
	private String name;
	private String pic;
	private String desc;
	private String latestTime;
	private String latestTalk;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPic()
	{
		return pic;
	}

	public void setPic(String pic)
	{
		this.pic = pic;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public String getLatestTime()
	{
		return latestTime;
	}

	public void setLatestTime(String latestTime)
	{
		this.latestTime = latestTime;
	}

	public String getLatestTalk()
	{
		return latestTalk;
	}

	public void setLatestTalk(String latestTalk)
	{
		this.latestTalk = latestTalk;
	}

}
