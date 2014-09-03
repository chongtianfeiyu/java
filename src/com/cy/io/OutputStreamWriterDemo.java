package com.cy.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * OutputStreamWriter 是字符流通向字节流的桥梁：可使用指定的 charset 将要写入流中的字符编码成字节。
 * 转换流 (字节->字符)
 * @author CY
 * @version 2014年9月3日
 */
public class OutputStreamWriterDemo {
	
	public static void main(String[] args) {
		OutputStreamWriter osw = null;
		OutputStreamWriter osw1 = null;
		try {
			osw = new OutputStreamWriter(new FileOutputStream("d:/test.txt"));
			osw.write("中国你好!");
			System.out.println(osw.getEncoding());
			osw1 = new OutputStreamWriter(new FileOutputStream("d:/test.txt",true),"gbk");
			osw1.write("中国你好!");
			System.out.println(osw1.getEncoding());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				osw.close();
				osw1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
