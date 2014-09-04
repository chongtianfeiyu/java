package com.cy.thread;

/**
 * 线程对象只能启动一个线程
 * 如果启动一个以上线程，后抛出异常;
 * @author CY
 * @version 2014年9月4日
 */
public class ThreadDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Cat cat = new Cat();
//		cat.start();
//		cat.start();
		Dog dog = new Dog();
		Thread th = new Thread(dog);
		Thread th1 = new Thread(dog);
		Thread th2 = new Thread(dog);
		th.start();
		th1.start();
		th2.start();
	}
	
}
