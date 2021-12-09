package com.example.ma_orderfoodapp_n1;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResponseRegisterClass implements Serializable {

	@SerializedName("password")
	private String password;

	@SerializedName("id")
	private int id;

	@SerializedName("username")
	private String username;

	public String getPassword(){
		return password;
	}

	public int getId(){
		return id;
	}

	public String getUsername(){
		return username;
	}

	public ResponseRegisterClass(String password, String username) {
		this.password = password;
		this.username = username;
	}

	public ResponseRegisterClass(String password, int id, String username) {
		this.password = password;
		this.id = id;
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}