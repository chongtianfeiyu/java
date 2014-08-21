package com.cy.container;

import java.util.HashSet;
import java.util.Set;

/**
 * Set接口的使用
 * Set中的数据对象没有顺序且不可以重复
 * @author CY
 * @version 2014年8月10日
 */
public class SetDemo {

	public static void main(String[] args) {
		Set s = new HashSet();
		s.add("xiaomi");
		s.add("huawei");
		s.add("HTC");
		s.add("xiaomi"); // 不可以重复，添加无效
		System.out.println(s);
		System.out.println("\n\n\n");
		
		Set s1 = new HashSet();
		Set s2 = new HashSet();
		s1.add(1); s1.add(2); s1.add(3);
		s2.add(1); s2.add(2); s2.add(4);
		Set s3 = new HashSet(s1);
		s3.retainAll(s2); // 交集
		System.out.println(s3);
		Set s4 = new HashSet(s1);
		s4.addAll(s2); // 并集
		System.out.println(s4);
	}

}
