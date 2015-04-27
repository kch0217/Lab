package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

import base.Post;

public class BlogClient {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args){
		try {
			Socket socket = new Socket(IP, PORT);
			PrintWriter wri = new PrintWriter(socket.getOutputStream(), true);
			Post post = new Post(new Date(), "Testing");
			wri.println(post);
			wri.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
