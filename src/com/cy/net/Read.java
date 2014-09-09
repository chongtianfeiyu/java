package com.cy.net;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读取消息的线程
 * @author CY
 * @version 2014年9月8日
 */
class Read extends Thread{
	DataInputStream dis = null;
	String name = null;
	
	public Read(InputStream is, String name) {
		this.dis = new DataInputStream(is);
		this.name = name;
	}
	
	public void run() {
		String str = "";
		try {
			//如果接受到exit，则推出循环
			while(!str.equals("exit")) {
				//发送消息
				str = dis.readUTF();
				System.out.println(name + ":" + str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭资源
				dis.close();
				System.exit(-1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}