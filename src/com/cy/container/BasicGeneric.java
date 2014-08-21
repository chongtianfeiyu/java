package com.cy.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 演示泛型的基本使用方法
 * @author CY
 * @version 2014年8月21日
 */
public class BasicGeneric {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("bbb");
		l.add("aaa");
		l.add("ccc");
		for(String s : l) {
			System.out.println(s);
		}
		System.out.println("*****************************************");
		Collection<String> c = new HashSet<String>();
		c.add("aaa");
		c.add("bbb");
		c.add("ccc");
		for(Iterator<String> i = c.iterator(); i.hasNext(); System.out.println(i.next())) {
		}
		System.out.println("******************************************");
		List<S> ll = new LinkedList<S>();
		ll.add(new S("aaaaaaaa"));
		ll.add(new S("a"));
		ll.add(new S("aaa"));
		ll.add(new S("aa"));
		System.out.println("排序前:"+ll);
		Collections.sort(ll);
		System.out.println("排序后:"+ll);
	}

}
class S implements Comparable<S> {
	String s;
	S (String s) {
		this.s = s;
	}
	@Override
	public int compareTo(S o) {
		if(s.length() > o.s.length()) {
			return 1;
		} else if (s.length() < o.s.length()) {
			return -1;
		} else {
			return 0;
		}
	}
	@Override
	public String toString() {
		return "S [s=" + s + "]";
	}
}
