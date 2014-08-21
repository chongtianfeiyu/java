package com.cy.container;

import java.util.LinkedList;
/**
 * 演示List接口的一些常用方法！
 * List中的数据对象有顺序且可以重复
 * @author CY
 * @version 2014年8月11日
 */
public class ListDemo {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		for(int i = 0; i < 5; i++) {
			ll.add("a"+i);
		}
		System.out.println(ll);
		ll.add("a5");
		System.out.println(ll);
		ll.add(2,"new");
		System.out.println(ll);
		System.out.println(ll.set(3, "new3"));
		System.out.println(ll);
		System.out.println(ll.get(0));
		System.out.println(ll.indexOf("a5"));
	}

}
