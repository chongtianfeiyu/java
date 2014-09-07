package com.cy.thread;

/**
 * 线程同步问题。锁
 * @author CY
 * @version 2014年9月5日
 */
public class SynchronizedDemo1 implements Runnable{

//	Timer timer = new Timer();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynchronizedDemo1 sd = new SynchronizedDemo1();
		Thread t = new Thread(sd);
		Thread t1 = new Thread(sd);
		t.setName("a");
		t1.setName("b");
		t.start(); 
		t1.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		new Timer().add(Thread.currentThread().getName());
//		timer.add(Thread.currentThread().getName());
	}

}

class Timer {
	private static int i = 0;
	private String flag = "";
	//如果用的是同步函数 synchronized ，锁住的是这个类所创建的对象。
	//如果一个对象被锁住，那么用该对象的做标志的同步代码块将不会被执行。
//	public synchronized void add(String name) {
	public void add(String name) {
		//另一个用法是在方法前加synchronized关键字
		synchronized (flag) {
			i++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + "你是第" + i + "个使用timer的线程！");
		}
	}
}