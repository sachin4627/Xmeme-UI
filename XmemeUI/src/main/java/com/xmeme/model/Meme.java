package com.xmeme.model;

public class Meme {
	
	private Integer pkId;
	private String ownerName;
	private String caption;
	private String memeUrl;
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public String getMemeUrl() {
		return memeUrl;
	}
	public void setMemeUrl(String memeUrl) {
		this.memeUrl = memeUrl;
	}
	public Integer getPkId() {
		return pkId;
	}
	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}
}
