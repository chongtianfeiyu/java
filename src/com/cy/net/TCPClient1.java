package com.cy.net;

import java.io.IOException;
import java.net.Socket;

/**
 * 聊天工具客户端
 * @author CY
 * @version 2014年9月8日
 */
public class TCPClient1 {
	Socket s = null;
	
	public TCPClient1() {
		try {
			//连接服务器
			s = new Socket("127.0.0.1",8888);
			//开启读取信息的线程
			new Read(s.getInputStream(),"Server").start();
			//开启发送信息的线程
			new Write(s.getOutputStream()).start();
		} catch (IOException e) {
			System.out.println("无法连接到服务器("+ e.getMessage()+")");
		}
	}
	
	public static void main(String[] args) {
		new TCPClient1();
	}

}
