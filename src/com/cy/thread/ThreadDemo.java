package com.cy.thread;

/**
 * 线程演示
 * @author CY
 * @version 2014年9月4日
 */
public class ThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat = new Cat();
		cat.start();
		Dog dog = new Dog();
		Thread t = new Thread(dog);
		t.start();
		System.out.println("ok");
	}

}

class Cat extends Thread{
	
	//重写run函数
	public void run(){
		while(true){
			//休眠一秒
			//1000表示1000毫秒
			//sleep就会让该线程进入到Blocked状体，并释放资源。
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hello,world");
		}
		
	}
}
class Dog implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("hello,china");
		}
	}
	
}