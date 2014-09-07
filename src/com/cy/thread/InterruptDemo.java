package com.cy.thread;

import java.util.Date;

/**
 * 线程的sleep函数以及Interrupt函数的简单使用演示。
 * @author CY
 * @version 2014年9月5日
 */
public class InterruptDemo {

	public static void main(String[] args) {
		T t = new T();
		t.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		t.interrupt();
	}

}

class T extends Thread {
	
	
	public void run() {
		while(true) {
			System.out.println("====n"+new Date()+"====");
			try {
				//这个异常必须捕获，不能throws抛出，因为是重写的run方法，重写的方法不能抛出与被重写方法不同的异常。
				Thread.sleep(1000);	
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}