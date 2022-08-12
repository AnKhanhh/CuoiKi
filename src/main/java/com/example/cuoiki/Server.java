package com.example.cuoiki;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public Server() {
		ServerSocket ssCmd=null, ssMsg=null, ssObj=null;
		Socket sObj, sCmd, sMsg;
		try {
			ssCmd = new ServerSocket(4000);
			ssMsg = new ServerSocket(8000);
			ssObj = new ServerSocket(8001);
		} catch (IOException e) {
			System.out.println("ERROR: failed to setup connection!");
		}

		while (true){
			try {
				sCmd=ssCmd.accept();
				sMsg=ssMsg.accept();
				sObj=ssObj.accept();
				System.out.println("Established new connections.");
				ServerThread serverThread = new ServerThread(sCmd,sObj,sMsg);
				serverThread.start();
			} catch (IOException e) {
				System.out.println("Failed to establish new connections");
			} catch (NullPointerException ex){
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
	}
}

class ServerThread extends Thread {
	Socket sObj, sCmd, sMsg;
	DataInputStream dinCmd, dinMsg;
	DataOutputStream dout;
	ObjectInputStream oin;
	String line = "";

	public ServerThread(Socket sCmd, Socket sObj, Socket sMsg) {
		this.sCmd = sCmd;
		this.sObj = sObj;
		this.sMsg = sMsg;
	}

	public void run() {
		try {
			dinCmd = new DataInputStream(sCmd.getInputStream());
			dinMsg = new DataInputStream(sMsg.getInputStream());
			oin = new ObjectInputStream(sObj.getInputStream());
		} catch (IOException e) {
			System.out.println("ERROR: failure in thread " + this.getName());
		}

		try {
			while (!line.equals("exit")){
				line=dinCmd.readUTF();
				if (line.equals("message")){
					System.out.println("Client: "+dinMsg.readUTF());
				} else if (line.equals("order")) {
					try {
						@SuppressWarnings("unchecked")
						ArrayList<SerialReceipt> serialReceipts = (ArrayList<SerialReceipt>) oin.readObject();
						System.out.println("you have ordered the following items:");
						for (SerialReceipt serialReceipt : serialReceipts) {
							System.out.println("	" + serialReceipt.display());
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}

			}
		} catch (IOException e) {
			System.out.println("ERROR: client terminated in "+ this.getName());
		} finally {
			try {
				dinMsg.close();
				dinCmd.close();
				oin.close();
				dout.close();
				sCmd.close();
				sMsg.close();
				sObj.close();
				System.out.println("Connections closed in "+this.getName());
			} catch (IOException e) {
				System.out.println("ERROR: failed to close connection in "+this.getName());
			}
		}
	}
}