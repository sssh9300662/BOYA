package com.boya.restapi.response;

public class MemberResponse extends RestResponse {
	
	private static final long serialVersionUID = -3594230692317822673L;

	public String id;
	
	public String message;
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("id:" + id);
		sb.append(",message:" + message);
		return sb.toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
