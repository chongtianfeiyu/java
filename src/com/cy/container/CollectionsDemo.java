package com.cy.container;

import java.util.Collections;
import java.util.LinkedList;
/**
 * 类java.util.Collections提供了一些静态方法实现了基于List容器的一些常用算法
 * @author CY
 * @version 2014年8月11日
 */
public class CollectionsDemo {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		for(int i = 0 ; i < 10; i++) {
			ll.add("a"+i);
		}
		System.out.println(ll);
		Collections.shuffle(ll); //随机排序
		System.out.println(ll);
		Collections.reverse(ll); //逆序
		System.out.println(ll);
		Collections.sort(ll); //排序
		System.out.println(ll);
		System.out.println(Collections.binarySearch(ll,"a3"));//二分法查找
	}

}
