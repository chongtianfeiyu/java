package com.cy.container;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection接口的使用演示
 * Collection接口-定义了存取一组对象的方法，其子接口Set和List分别定义了存取方式。
 * @author CY
 * @version 2014年8月10日
 */
public class CollectionDemo {

	public static void main(String[] args) {
		Collection c = new ArrayList();
		c.add("hello");
		c.add(new Integer(2));
		c.add(new Dog("Tom"));
		c.remove("hello");
		c.remove(new Integer(2));
		System.out.println(c.remove(new Dog("Tom")));
		System.out.println(c.size());
		System.out.println(c);
	}
}

class Dog implements Comparable{
	String name;

	Dog(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		Dog d = (Dog)o;
		return name.compareTo(d.name);
	}

}