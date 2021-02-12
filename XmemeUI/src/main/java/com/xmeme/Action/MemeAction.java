package com.xmeme.Action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.xmeme.apihelper.XmemeHelper;
import com.xmeme.model.Meme;

public class MemeAction {

	private String ownerName;
	private String caption;
	private String memeUrl;
	List<Meme> listdata = new ArrayList<Meme>();

	public String getMemes() throws IOException {
		String memes =XmemeHelper.getMemesData();
		getjsonData(memes);
		return "success";
	}

	@SuppressWarnings("unused")
	public String postMeme() throws IOException {
		if(caption!=null) {
		Meme meme =new Meme();
		meme.setCaption(caption);
		meme.setMemeUrl(memeUrl);
		meme.setOwnerName(ownerName);
		String memes =XmemeHelper.postReq(meme);
		}
		getMemes();
		return "success";
	}

	private void getjsonData(String memes) {
		try {            
			memes.replace("\\", "");
			JSONArray jsonMainArr = new JSONArray(memes);
			for (int i = 0; i < jsonMainArr.length(); ++i) {                     
				JSONObject jsonObj = jsonMainArr.getJSONObject(i);
				Meme meme=new Meme();
				meme.setOwnerName(jsonObj.get("ownerName").toString());
				meme.setCaption( jsonObj.get("caption").toString());
				meme.setMemeUrl(jsonObj.get("memeUrl").toString());
				listdata.add(meme);
			}                                                       
		} catch (JSONException e) {
			e.printStackTrace();
		} 
	}

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



	public List<Meme> getListdata() {
		return listdata;
	}



	public void setListdata(List<Meme> listdata) {
		this.listdata = listdata;
	}

}
