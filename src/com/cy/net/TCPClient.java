package com.cy.net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
/**
 * Java Socket编程简单演示
 * 客户端
 * @author CY
 * @version 2014年9月7日
 */
public class TCPClient {
	public static void main(String [] args) {
		Socket s = null;
		DataOutputStream dos = null;
		try {
			s = new Socket("127.0.0.1", 6666);
			dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF("你好！中国！");
		} catch (IOException e) {
			System.out.println("无法连接到服务器("+e.getMessage()+")");
		} finally {
			try {
				dos.close();
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
