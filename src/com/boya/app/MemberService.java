package com.boya.app;

import com.boya.restapi.request.MemberRequest;
import com.boya.restapi.response.MemberResponse;

public class MemberService {
	
	public MemberResponse addMember(Object request){
		 MemberRequest memberRequest = (MemberRequest) request;
		 System.out.println("Add member by " + memberRequest);
		//Some logic to add member by request
		//Some logic to handle fail response, e.g. set status except 200
		MemberResponse response = new MemberResponse();
		response.setId("test1");
		response.setMessage("success");
		
		return response;
	}

}
