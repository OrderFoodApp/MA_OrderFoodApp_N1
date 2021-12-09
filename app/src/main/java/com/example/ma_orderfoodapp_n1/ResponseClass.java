package com.example.ma_orderfoodapp_n1;

import com.google.gson.annotations.SerializedName;

public class ResponseClass{

	@SerializedName("password")
	private String password;

	@SerializedName("username")
	private String username;

	public String getPassword(){
		return password;
	}

	public String getUsername(){
		return username;
	}
}