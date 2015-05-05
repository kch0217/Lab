package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
	private static int counter = 0;
	
	public static void main(String[] args){
		try {
			ServerSocket ser = new ServerSocket(3021);
			while (true){
				Socket sersoc = ser.accept();
				counter++;
				Thread newthread = new Thread(new ThreadHandler(sersoc, counter));
				newthread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
