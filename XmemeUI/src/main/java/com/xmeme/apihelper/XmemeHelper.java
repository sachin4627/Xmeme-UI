package com.xmeme.apihelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xmeme.model.Meme;



public class XmemeHelper {

	private static final String BASEUSRL="https://xmeme-4627-api.herokuapp.com/";
	private static final String Endpoint="memes";

	public static String getMemesData() throws IOException {
		String readLine=null;
		URL url = new URL(BASEUSRL+Endpoint);
		HttpURLConnection getConnection = (HttpURLConnection) url.openConnection();
		if(getConnection.getResponseCode()==200) {
			InputStream is = getConnection.getInputStream();
			BufferedReader br =new BufferedReader(new InputStreamReader(is));
			readLine=br.readLine();
		}
		return readLine;
	}	

	@SuppressWarnings("unused")
	public static String postReq(Meme meme) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target(BASEUSRL).path(Endpoint);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		String res  = invocationBuilder.post(Entity.entity(mapper.writeValueAsString(meme), MediaType.APPLICATION_JSON),String.class);
		return null;
	}

}
