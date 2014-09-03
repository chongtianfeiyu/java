package com.cy.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * PrintStream 的简单使用。
 * 字节打印流
 * @author CY
 * @version 2014年9月3日
 */
public class PrintStreamDemo {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		PrintStream ps = null;
		try {
			fos = new FileOutputStream("d:/test.txt");
			ps = new PrintStream(fos);
			System.setOut(ps);
			System.out.println("你好我是你哥哥！");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
