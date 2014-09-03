package com.cy.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 数据流（处理流） DataInputStream DataOutputStream
 * 字节数组流（节点流）ByteArrayOutputStream ByteArrayInputStream
 * @author CY
 * @version 2014年9月3日
 */
public class DataStreamByteArrayStream {

	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		ByteArrayInputStream bais = null;
		DataInputStream dis = null;
		
		
		try {
			dos.writeDouble(Math.random());
			dos.writeBoolean(true);
			bais = new ByteArrayInputStream(baos.toByteArray());
			dis = new DataInputStream(bais);
			System.out.println(bais.available());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				dos.close();
				baos.close();
				dis.close();
				bais.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
