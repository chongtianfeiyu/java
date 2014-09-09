package com.cy.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 聊天工具服务端
 * @author CY
 * @version 2014年9月8日
 */
public class TCPServer1 {
	ServerSocket ss = null;
	Socket s = null;
	
	public TCPServer1() {
		try {
			// 监听8888端口
			ss = new ServerSocket(8888);
			// 等待客户端连接
			s = ss.accept();
			//开启读取信息的线程
			new Read(s.getInputStream(),"Client").start();
			//开启发送信息的线程
			new Write(s.getOutputStream()).start();
		} catch (IOException e) {
			System.out.println("8888端口被占用（"+e.getMessage()+")");
			System.exit(-1);
		}
	}
	public static void main(String[] args) {
		new TCPServer1();
	}
}



