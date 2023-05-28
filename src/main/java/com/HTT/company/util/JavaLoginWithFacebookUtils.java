package com.HTT.company.util;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Component;

import com.HTT.company.constant.FacebookLoginTokenConstant;
import com.HTT.company.dto.FacebookDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.User;

@Component
public class JavaLoginWithFacebookUtils {

	public String getToken(final String code) throws ClientProtocolException, IOException {

		String link = String.format(FacebookLoginTokenConstant.FACEBOOK_LINK_GET_TOKEN, FacebookLoginTokenConstant.FACEBOOK_APP_ID,
				FacebookLoginTokenConstant.FACEBOOK_APP_SECRET, FacebookLoginTokenConstant.FACEBOOK_REDIRECT_URL, code);
		String response = Request.Get(link).execute().returnContent().asString();
		JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
		return jobj.get("access_token").toString().replaceAll("\"", "");
	}

	public User getUserInfo(final String accessToken) throws ClientProtocolException, IOException {
		FacebookClient facebookClient = new DefaultFacebookClient(accessToken,
				FacebookLoginTokenConstant.FACEBOOK_APP_SECRET, Version.LATEST);
		return facebookClient.fetchObject("me", User.class);
		//, Parameter.with("fields","id,first_name,last_name,middle_name, name,name_format,short_name")
	}
}
