package com.cy.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BufferedOutputStream 缓冲的输出流
 * 将字母a~z输出到文件d:/test.txt
 * 缓冲流
 * @author CY
 * @version 2014年9月3日
 */
public class BufferedOutputStreamDemo {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("d:/test.txt");
			bos = new BufferedOutputStream(fos);
			for(int i = 97 ; i <= 122; i++) {
				bos.write(i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
