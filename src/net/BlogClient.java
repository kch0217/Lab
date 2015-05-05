package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

import base.Post;

public class BlogClient {
	public static final String IP = "127.0.0.1";
	public static final int PORT = 3021;
	
	public static void main(String[] args){
		try {
			Socket socket = new Socket(IP, PORT);
			Scanner scanner = new Scanner(System.in);
			PrintWriter wri = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String temp;
			do{
				temp = scanner.nextLine();
				wri.println(temp);
				if (temp.equals("quit"))
					break;
				temp = read.readLine();
				System.out.println(temp);
			} while (!temp.equals("quit"));
//			Post post = new Post(new Date(), "Testing");
//			wri.println(post);
			wri.close();
			read.close();
			scanner.close();
			socket.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
