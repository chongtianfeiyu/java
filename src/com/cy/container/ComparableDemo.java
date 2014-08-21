package com.cy.container;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 所有可以排序的类都实现java.lang.Comparable接口，Comparable接口中只有一个方法
 * public int compareTo(Object obj)该方法
 * 返回0表示this==obj
 * 返回正数表示this>obj
 * 返回负数表示this<obj
 * 实现了Comparable接口的类通过实现CompareTo方法从而确定改类对象的排序方式
 * @author CY
 * @version 2014年8月11日
 */
public class ComparableDemo {
	public static void main(String [] args) {
		LinkedList ll = new LinkedList();
		// Dog类来自CollectionDemo.java
		ll.add(new Dog("Mary"));
		ll.add(new Dog("Tom"));
		ll.add(new Dog("Cary"));
		ll.add(new Dog("Mali"));
		System.out.println("排序前"+ll);
		Collections.sort(ll);
		System.out.println("排序后"+ll);
	}
}
