package com.cy.mix;

/**
 * 演示 instanceof 运算符的用法
 * 
 * @author CY
 * @version 2014年7月14日
 */
public class InstanceofDemo {
	public int i;

	public static void main(String[] args) {
		// InstanceofDemo instanceofDemo = null; // no
		InstanceofDemo instanceofDemo = new InstanceofDemo(); // ok
		if (instanceofDemo instanceof InstanceofDemo) {
			System.out.println("ok");
		} else {
			System.out.println("no");
		}
	}

}
