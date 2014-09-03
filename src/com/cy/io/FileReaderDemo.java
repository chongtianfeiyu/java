package com.cy.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * FileReader 文件读取流简单使用演示
 * 处理流
 * @author CY
 * @version 2014年8月23日
 */
public class FileReaderDemo {

	public static void main(String[] args) {
		FileReader reader = null;
		try {
			reader = new FileReader("D:/test.txt");
			int c;
			while((c = reader.read()) != -1) {
				System.out.print((char)c);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		} finally {
			//关闭输入流,并释放资源
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(-1);
			}
		}
	}

}
