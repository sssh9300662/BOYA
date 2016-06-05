package com.boya.restapi;

import com.boya.app.AppServer;
import com.boya.restapi.request.MemberRequest;
import com.boya.service.impl.AppServerServiceImpl;

public class MemberResourceTest {
	
	public static void main(String args[]){
		
		Thread t = new Thread(new Runnable() {
            public void run() {
            	AppServer.start();
            }     
        });
        t.start();
		
		MemberResource memberResource = new MemberResource();
		memberResource.setService(new AppServerServiceImpl());
		
		MemberRequest request = new MemberRequest();
		request.setName("Henry");
		request.setEmail("henrys@test.com");
		request.setPwd("1234");
		memberResource.add(request);
	}

}
