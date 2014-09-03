package com.cy.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * FileOutputStream 文件输出流的简单使用演示 文件复制功能
 * 节点流
 * @author CY
 * @version 2014年8月23日
 */
public class FileOutputStreamDemo {

	public static void main(String[] args) {
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("D:/test.txt");
			out = new FileOutputStream("D:/other.txt");

			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		} finally {
			// 关闭输入输出流,释放资源
			try {
				in.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
