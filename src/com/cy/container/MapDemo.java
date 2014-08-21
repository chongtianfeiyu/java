package com.cy.container;

import java.util.HashMap;
import java.util.Map;

/**
 * 演示Map接口的方法使用
 * @author CY
 * @version 2014年8月12日
 */
public class MapDemo {

	public static void main(String[] args) {
		Map m1 = new HashMap();
		m1.put(1, "one");
		m1.put(2, "two");
		m1.put(3, "three");
		m1.put("four",4);
		int i = (Integer)m1.get("four");
		System.out.println(i);
		System.out.println(m1.size());
		System.out.println(m1.containsKey(1));
		System.out.println(m1.containsValue("twoo"));
		System.out.println(m1.get(1));
		Map m2 = new HashMap();
		m2.putAll(m1);
		System.out.println(m2);
		m1.clear();
		System.out.println(m1.isEmpty());
		
	}

}
