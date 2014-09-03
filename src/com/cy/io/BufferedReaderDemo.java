package com.cy.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 * BufferedReader 从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
 * 缓冲流
 * @author CY
 * @version 2014年9月3日
 */
public class BufferedReaderDemo {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader("d:/test.txt");
			br = new BufferedReader(fr);
			br.mark(100);
			System.out.println(br.readLine()); //读取一行
			br.reset();
			System.out.println((char)br.read());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
