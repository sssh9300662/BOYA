package com.boya.restapi.response;

import java.io.Serializable;

public class RestResponse implements Serializable {
	
	private static final long serialVersionUID = -6131224707548561971L;
	
	private int status = 200;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
