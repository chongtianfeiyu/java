package com.cy.thread;

/**
 * 线程优先级的函数简单使用演示！
 * @author CY
 * @version 2014年9月5日
 */
public class PriorityDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t = new Thread(new W());
		Thread t1 = new Thread(new W());
		//提高线程t的优先级
		t.setPriority(Thread.NORM_PRIORITY+3);
		t.start();
		t1.start();
	}

}

class W implements Runnable {
	public void run() {
		for(int i = 0; i < 1000; i++) {
			System.out.println(i);
		}
	}
}