package com.boya.app;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppServer {

	private static AppServer server;

	public void listenRequest() {
		ServerSocket serverSocket = null;
		ExecutorService executorService = Executors.newCachedThreadPool();
		try {
			serverSocket = new ServerSocket(8083);
			while (true) {
				Thread.sleep(60000L);
				Socket socket = serverSocket.accept();
				executorService.execute(new RequestThread(socket));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (executorService != null)
				executorService.shutdown();
			if (serverSocket != null)
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public static void start() {
		if (server == null) {
			server = new AppServer();
			server.listenRequest();
		}
	}

	public static void main(String args[]) {
		start();
	}

	class RequestThread implements Runnable {

		private Socket clientSocket;

		public RequestThread(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {

			ObjectOutputStream output = null;
			ObjectInputStream input = null;

			try {
				System.out.println("Request from" + clientSocket.getRemoteSocketAddress());
				input = new ObjectInputStream(this.clientSocket.getInputStream());

				Object response = this.handle(input);

				output = new ObjectOutputStream(this.clientSocket.getOutputStream());
				output.writeObject(response);
				output.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (input != null)
						input.close();
					if (output != null)
						output.close();
					if (clientSocket != null && !clientSocket.isClosed())
						clientSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		private Object handle(ObjectInputStream input) throws ClassNotFoundException, IOException {
			// if we can get service name and invoke method name from input, get
			// service from spring context and invoke method
			MemberService service = new MemberService();
			return service.addMember(input.readObject());
		}
	}
}
