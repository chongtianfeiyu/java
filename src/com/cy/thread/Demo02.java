package com.cy.thread;

/**
 * 线程同步问题
 * @author CY
 * @version 2014年9月4日
 */
public class Demo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketWindow tw = new TicketWindow();
		Thread t1 = new Thread(tw);
		Thread t2 = new Thread(tw);
		Thread t3 = new Thread(tw);
		t1.start();
		t2.start();
		t3.start();
	}

}

class TicketWindow implements Runnable{
	private int total = 100;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (this) {
				if(total <= 0){
					break;
				}
				System.out.println(Thread.currentThread().getName()+"正在出售第"+(101-total)+"张票！");
				total--;
			}
		}
	}
	
	
}