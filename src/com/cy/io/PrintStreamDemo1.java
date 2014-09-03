package com.cy.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * PrintStream 流的简单使用
 * 给定指定文件，输出文件内容
 * @author CY
 * @version 2014年9月3日
 */
public class PrintStreamDemo1 {

	public static void main(String[] args) {
		String filename = args[0];
		print(filename, System.out);
	}
	
	public static void print (String filename, PrintStream ps) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filename));
			String s = null;
			while((s = br.readLine()) != null) {
				ps.print(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ps.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
