package com.boya.restapi.request;

import java.io.Serializable;

public class MemberRequest implements Serializable {
	
	private static final long serialVersionUID = 4322285745519836289L;
	
	private String name;
	
	private String email;
	
	public String pwd;
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("name:" + name);
		sb.append(",email:" + email);
		sb.append(",pwd:" + pwd);
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
