package com.cy.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * FileInputStream 文件读取流的简单使用演示
 * 节点流
 * @author CY
 * @version 2014年8月23日
 */
public class FileInputStreamDemo {

	public static void main(String[] args) {
		FileInputStream in = null;
		try {
			in = new FileInputStream("D:/test.txt");
			int b;
			while ((b = in.read()) != -1) {
				System.out.print((char)b);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		} finally {
			//关闭输出流,释放资源
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
