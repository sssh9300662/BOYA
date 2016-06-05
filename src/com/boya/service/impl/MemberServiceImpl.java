package com.boya.service.impl;

import com.boya.restapi.response.MemberResponse;
import com.boya.service.CallBack;

public class MemberServiceImpl implements CallBack  {

	@Override
	public Object callBack(Object output) {
		MemberResponse response = (MemberResponse)output;
		//......some logic process
		return response;
	}

}
