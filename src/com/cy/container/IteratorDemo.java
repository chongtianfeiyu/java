package com.cy.container;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Iterator演示说明
 * @author CY
 * @version 2014年8月10日
 */
public class IteratorDemo {

	public static void main(String[] args) {

		Collection c = new HashSet();
		c.add("xiaomi");
		c.add("huawei");
		c.add("HTC");
		Iterator i = c.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
			i.remove(); // 这里不能用 c.remove()
		}
		i = c.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}
	}

}
