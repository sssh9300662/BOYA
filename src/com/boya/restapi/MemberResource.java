package com.boya.restapi;

import com.boya.restapi.request.MemberRequest;
import com.boya.restapi.response.MemberResponse;
import com.boya.service.AppServerService;
import com.boya.service.impl.MemberServiceImpl;

public class MemberResource {
	
	private AppServerService service;
	
	/**
	 * The precondition for this rest api are:
	 * 1) The filter or framework already help us to handle Marshalling and Unmarshalling request/response to specified class
	 * 2) If we use servlet, the api URI should be defined in web.xml and implement related method by http methods
	 * 3) If we use Spring MVC, Oracle Jersey or other JAX-RS framework, this api should have related rest annotation 
	 *   (e.g. @Pqth, @PUT, @GET, @Produces, @Consumes) 
	 * @param MemberRequest
	 * @return MemberResponse
	 */
	public MemberResponse add(MemberRequest request){
		MemberResponse response = (MemberResponse) this.service.callServerApi(request, new MemberServiceImpl());
		System.out.println("Response is [" + response + "]");
		//set http status from response.getStatus()
		return response;
	}

	public AppServerService getService() {
		return service;
	}

	public void setService(AppServerService service) {
		this.service = service;
	}

}
