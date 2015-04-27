package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class BlogServer {
	public static final int PORT = 3021;
	
	public static void main(String[] args){
		try {
			ServerSocket serv = new ServerSocket(PORT);
			Socket socket = serv.accept();
			BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String temp;
			while ((temp = buf.readLine())!= null){
				System.out.println(temp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
