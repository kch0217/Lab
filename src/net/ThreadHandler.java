package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadHandler implements Runnable{
	
	private int numOfVisitor;
	
	private Socket socket;
	
	public ThreadHandler(Socket soc, int num){
		socket = soc;
		numOfVisitor = num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter write = new PrintWriter(socket.getOutputStream(), true);
			String temp;
			while (true){
				temp = read.readLine();
				if (temp.equals("visitor")){
					write.println("You're the "+numOfVisitor+ " visitor today");
				}
				else if (temp.equals("quit")){
					break;
				}
				else{
					write.println("echo: " + temp);
				}
			}
			read.close();
			write.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
