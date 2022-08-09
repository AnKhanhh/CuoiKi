package com.example.cuoiki;

import com.example.cuoiki.Customer.UserInformation;
import com.example.cuoiki.Drink.DrinkConst;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends JFrame {
	static ServerSocket ss, ssObj, ssChat;
	static Socket s, sObj, sChat;
	static DataInputStream din, dinChat;
	static ObjectInputStream oin;

	int port = 4000, portChat = 8000, portObj = 8888;

	private JTextField fieldMsg;
	private JPanel mainPn;
	private JTextPane paneChat;
	private JButton btnSend;

	public Server() {
		this.setContentPane(mainPn);
		paneChat.setContentType("text/html");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);

		String msg = "";
		try {
			ss = new ServerSocket(port);
			ssChat = new ServerSocket(portChat);
			ssObj = new ServerSocket(portObj);
			s=ss.accept();
			sChat=ssChat.accept();
			sObj = ssObj.accept();
			din = new DataInputStream(s.getInputStream());
			dinChat = new DataInputStream(sChat.getInputStream());
			oin=new ObjectInputStream(sObj.getInputStream());

			while (!msg.equals("exit")){
				msg = din.readUTF();
				System.out.println("command received:" + msg);
				if(msg.equals("message")){
					appendToPane(paneChat,dinChat.readUTF());
				} else if(msg.equals("order")){
					try {
						@SuppressWarnings("unchecked")
						ArrayList<SerialReceipt> serialReceipts = (ArrayList<SerialReceipt>) oin.readObject();
						for (SerialReceipt serialReceipt : serialReceipts) {
							System.out.println(serialReceipt.display());
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
;		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void appendToPane(JTextPane tp, String msg) {
		HTMLDocument doc = (HTMLDocument) tp.getDocument();
		HTMLEditorKit editorKit = (HTMLEditorKit) tp.getEditorKit();
		try {
			editorKit.insertHTML(doc, doc.getLength(), msg, 0, 0, null);
			tp.setCaretPosition(doc.getLength());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
	}
}