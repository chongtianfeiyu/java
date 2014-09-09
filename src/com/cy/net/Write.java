package com.cy.net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * 发送消息线程
 * @author CY
 * @version 2014年9月8日
 */
class Write extends Thread {
	DataOutputStream dos = null;
	
	public Write(OutputStream os) {
		this.dos = new DataOutputStream(os);
	}
	
	public void run() {
		String str = "";
		//用来读取用户输入的数据
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			//如果输入exit 则退出循环
			while(!str.equals("exit")) {
				//读取消息
				str = br.readLine();
				//发送消息
				dos.writeUTF(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//关闭资源
				br.close();
				dos.close();
				System.exit(-1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
