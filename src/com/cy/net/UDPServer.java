package com.cy.net;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UPD连接 （服务端）
 * @author CY
 * @version 2014年9月8日
 */
public class UDPServer {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		DatagramPacket dp = null;
		byte[] buf = new byte[1024];
		try {
			dp = new DatagramPacket(buf, buf.length);
			ds = new DatagramSocket(8888);
			while(true){
				ds.receive(dp);
//				System.out.println(new String (buf,0,dp.getLength()));
				//接收long类型数据
				ByteArrayInputStream bais = new ByteArrayInputStream(buf);
				DataInputStream dis = new DataInputStream(bais);
				System.out.println(dis.readLong());
			}
		} catch (SocketException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ds.close();
		}
	}

}
