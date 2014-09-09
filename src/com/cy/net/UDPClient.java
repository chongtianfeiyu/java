package com.cy.net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * UDP连接 （客户端）
 * @author CY
 * @version 2014年9月8日
 */
public class UDPClient {

	public static void main(String[] args) {
		DatagramSocket ds = null;
		DatagramPacket dp = null;
//		byte [] buf = "nihao".getBytes();
		//发送long类型数据
		long l = 8;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		try {
			dos.writeLong(l);
			byte [] buf = baos.toByteArray();
			dp = new DatagramPacket(buf, buf.length, new InetSocketAddress("127.0.0.1", 8888));
			ds = new DatagramSocket(8979);
			ds.send(dp);
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			ds.close();
		}
	}

}
