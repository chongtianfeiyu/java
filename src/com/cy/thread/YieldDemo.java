package com.cy.thread;

/**
 * 线程 Yield方法的简单使用演示。
 * @author CY
 * @version 2014年9月5日
 */
public class YieldDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		V t = new V();
		V t1 = new V();
		t.start();
		t1.start();
	}

}
class V extends Thread {
	public void run() {
		for(int i = 0; i < 100 ; i++) {
			System.out.println(i);
			if(i % 10 == 0) {
				System.out.println("让出权限");
				yield();
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
