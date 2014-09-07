package com.cy.thread;

/**
 * 死锁的产生。
 * @author CY
 * @version 2014年9月5日
 */
public class DeadlockDemo implements Runnable {

	A a = new A();
	B b = new B();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeadlockDemo dld = new DeadlockDemo();
		Thread t = new Thread(dld);
		t.start();
		dld.a.a(dld.b);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		b.b(a);
	}

}

class A {
	public  synchronized void a(B b) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.test();
	}
	
	public synchronized void test() {
		
	}
}

class B {
	public  synchronized void b(A a) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.test();
	}
	
	public synchronized void test() {
		
	}
}