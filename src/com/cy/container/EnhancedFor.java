package com.cy.container;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强for循环演示、说明
 * @author CY
 * @version 2014年8月10日
 */
public class EnhancedFor {

	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5};
		for(int i : arr) {
			System.out.println(i);
		}
		Collection c = new ArrayList();
		c.add("xiaomi");
		c.add("meizu");
		c.add("huawei");
		for(Object o : c){
			System.out.println(o);
			//只能看不能删，在内部调用的Iterator
		}
	}

}
