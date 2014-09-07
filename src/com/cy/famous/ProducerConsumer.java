package com.cy.famous;

/**
 * 生产者和消费者问题
 * @author CY
 * @version 2014年9月5日
 */
public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		Producer p = new Producer(store);
		Consumer c = new Consumer(store);
		new Thread(p).start();
		new Thread(c).start();
	}

}

/**
 * 产品类
 * @author CY
 * @version 2014年9月5日
 */
class Goods {
	int id; 
	
	public Goods(int id) {
		this.id = id;
	}
}

/**
 * 仓库类
 * 用于存放商品
 * 栈，先生产的后消费。
 * @author CY
 * @version 2014年9月5日
 */
class Store {
	// 用于存放商品的数组
	Goods [] store = new Goods[6];
	// 记录商品数量
	int index = 0;
	
	/**
	 * 入库
	 * @param g
	 */
	public synchronized void push(Goods g) {
		// 仓库已满
		while(index == store.length) {
			try {
				// 线程等待,会释放被锁定的对象
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		store[index] = g;
		index++;
		System.out.println("商品--" + g.id + "--入库了！");
		//唤醒在此对象监视器上等待的单个线程
		this.notify();
	}
	
	/**
	 * 出库
	 * @return
	 */
	public synchronized Goods pop() {
		//仓库已空
		while(index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		index--;
		System.out.println("商品--" + store[index].id + "--出库了！");
		this.notify();
		return store[index];
	}
}

/**
 * 生产者
 * @author CY
 * @version 2014年9月5日
 */
class Producer implements Runnable {
	//仓库
	Store store;
	
	public Producer(Store store) {
		this.store = store;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			store.push(new Goods(i));
		}
	}
	
}

/**
 * 消费者
 * @author CY
 * @version 2014年9月5日
 */
class Consumer implements Runnable {
	//仓库
	Store store;
	
	public Consumer(Store store) {
		this.store = store;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++){
			store.pop();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}




