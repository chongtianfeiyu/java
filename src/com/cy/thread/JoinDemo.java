package com.cy.thread;

/**
 * 线程join方法的使用
 * @author CY
 * @version 2014年9月5日
 */
public class JoinDemo {

	public static void main(String[] args) {
		U t = new U("JoinThread");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(i);
		}
	}

}

class U extends Thread {
	
	U(String name) {
		super(name);
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			System.out.println("I am "+getName());
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}