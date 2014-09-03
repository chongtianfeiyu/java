package com.cy.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
/**
 * BufferedInputStream 演示
 *  为另一个输入流添加一些功能
 *  缓冲流
 * @author CY
 * @version 2014年9月2日
 */
public class BufferedInputStreamDemo {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			fis = new FileInputStream("d:/test.txt");
//			bis = new BufferedInputStream(fis);
			bis = new BufferedInputStream(fis,3);	//设置换成去的大小为1

			//在没掉用bis.read()之前(即没有缓冲),关闭节点流或处理流bis.read()都将无法使用
//			bis.close();	
//			fis.close();
			
			System.out.println(bis.markSupported());//测试此输入流是否支持 mark 和 reset 方法。
			
			System.out.println((char)bis.read());
			//注意:缓冲流调用mark 如果readlimit 小于缓冲流区的大小,则按缓冲区的大小计算
			bis.mark(2); //做标记,3代表从当前位置开始,可以往下读取3个字节,如果超过3个自己标记失效.
			System.out.println((char)bis.read());
			System.out.println((char)bis.read());
			System.out.println((char)bis.read());
			bis.reset(); //返回到标记
			System.out.println((char)bis.read());
			System.out.println((char)bis.read());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		} finally {
			try {
				//节点流和处理流都关闭 .  
				//如果关闭了处理流(bis) 那么fis也将关闭 .
				//如果关闭了节点流(fis) 那么bis也将关闭 , 
				//但是你如果在调用fis.close()之前,调用了bis.read() , 
				//那么bis缓冲的数据依然可以使用 , 除非你调用bis.close() .
				bis.close();
				fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				System.exit(-1);
			}
		}
	}

}
