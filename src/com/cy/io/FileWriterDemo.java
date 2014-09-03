package com.cy.io;

import java.io.FileWriter;
import java.io.IOException;
/**
 * FileWriter 文件写入流的简单使用演示
 * 处理流
 * @author CY
 * @version 2014年8月23日
 */
public class FileWriterDemo {

	public static void main(String[] args) {
		FileWriter writer = null;
		try {
			writer = new FileWriter("d:/test.txt");
			for(int i = 0; i <= 5000; i++) {
				writer.write(i);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(-1);
			}
		}
	}

}
