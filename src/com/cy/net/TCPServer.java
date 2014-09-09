package com.cy.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * Java Socket编程简单演示
 * 服务端
 * @author CY
 * @version 2014年9月7日
 */
public class TCPServer {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ServerSocket ss = null;
		int port = 6666;
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("端口"+port+"被占用("+e.getMessage()+")");
			System.exit(-1);
		}
		Socket s = null;
		DataInputStream dis = null;
		while(true) {
			try {
				s = ss.accept();
				dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				System.out.println(str);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					dis.close();
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
