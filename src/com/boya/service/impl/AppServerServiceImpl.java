package com.boya.service.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.boya.restapi.response.MemberResponse;
import com.boya.service.AppServerService;
import com.boya.service.CallBack;

public class AppServerServiceImpl implements AppServerService {

	@Override
	public Object callServerApi(Object request, CallBack callBack) {
		Socket socket = null;
		ObjectOutputStream output = null;
		ObjectInputStream input = null;
		MemberResponse response = null;

		try {
			socket = new Socket("localhost", 8083);
			
			output = new ObjectOutputStream(socket.getOutputStream());
			output.writeObject(request);
			output.flush();

			input = new ObjectInputStream(socket.getInputStream());
			return callBack.callBack(input.readObject());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null)
					input.close();
				if (output != null)
					output.close();
				if (socket != null && !socket.isClosed())
					socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return response;
	}

}
