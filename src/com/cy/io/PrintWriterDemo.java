package com.cy.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;

/**
 * PrintWriter 简单使用
 * 字符打印流
 * @author CY
 * @version 2014年9月3日
 */
public class PrintWriterDemo {

	public static void main(String[] args) {
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			pw = new PrintWriter(new FileWriter("d:/test.txt",true));
			br = new BufferedReader(new InputStreamReader(System.in));
			String s;
			while((s = br.readLine()) != null) {
				if(s.equals("exit")){
					break;
				}
				pw.println("----------");
				pw.println(s);
				pw.flush();
			}
			pw.print("====="+new Date()+"=====");
			pw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
