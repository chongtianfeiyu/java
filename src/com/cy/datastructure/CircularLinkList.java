package com.cy.datastructure;

/**
 * 循环链表
 * 
 * @author CY
 * @version 2014年7月15日
 */
public class CircularLinkList {
	// 尾节点
	private Node end = null;
	// 头节点
	private Node head = null;
	// 用于遍历循环链表
	private Node pointer = null;
	// 循环链表长度
	private int length = 0;

	/**
	 * 初始化函数 <br/>
	 * 在第一次调用next()方法时，必需先调用该方法。<br/>
	 * 调用该方法后 ，next()方法将从头节点开始遍历。
	 */
	public void init() {
		this.pointer = head;
	}

	/**
	 * 指向下一个结点，并返回该节点。
	 * 
	 * @return 当前的节点
	 */
	public Node next() {
		pointer = pointer.getNext();
		return pointer;
	}

	/**
	 * 返回当前节点
	 * 
	 * @return 当前节点
	 */
	public Node getPointer() {
		return pointer;
	}

	/**
	 * 添加节点
	 * 
	 * @param elem
	 *            要添加的元素
	 * @return 该结点的位置
	 */
	public int add(Object elem) {
		// 创建循环链表结点
		Node n;
		// 空循环链表
		if (length == 0) {
			n = new Node(elem, null);
			n.setNext(n);
			head = new Node(null, n);
		} else { // 非空循环链表
			n = new Node(elem, head.getNext());
			this.end.setNext(n);
		}
		// 赋值
		this.end = n;
		return ++length;
	}

	/**
	 * 通过位置来获取获取节点
	 * 
	 * @param location
	 *            节点的位置
	 * @return 指定位置的节点
	 */
	public Node getNode(int location) {
		// 节点位置超出范围
		if (location > length) {
			return null;
		} else {
			Node n = head;
			for (int i = 0; i < location; i++) {
				n = n.getNext();
			}
			return n;
		}
	}

	/**
	 * 查找某个节点的位置
	 * 
	 * @param target
	 *            要查找的节点
	 * @return 节点的位置
	 */
	public int getLocation(Object target) {
		Node n = head;
		for (int i = 0; i < length; i++) {
			n = n.getNext();
			if (n.getElem().equals(target)) {
				return ++i;
			}
		}
		return -1;
	}

	/**
	 * 判断循环链表是否为空
	 * 
	 * @return true 为空，false 不为空。
	 */
	public boolean isEmpty() {
		if (length <= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 得到循环链表的长度
	 * 
	 * @return 循环链表的长度
	 */
	public int getLength() {
		return length;
	}

	/**
	 * 修改节点
	 * 
	 * @param location
	 *            要被修改节点的位置
	 * @param elem
	 *            新的元素
	 * @return 修改结构;true 修改成功;false 修改失败;
	 */
	public boolean updateNode(int location, Object elem) {
		if (this.isEmpty() || this.length < location) {
			return false;
		} else {
			Node n = head;
			for (int i = 0; i < location; i++) {
				n = n.getNext();
			}
			n.setElem(elem);
			return true;
		}
	}

	/**
	 * 通过要删除的对象来删除节点
	 * 
	 * @param target
	 *            要被删除的对象
	 * @return 被删除元素的位置。 如果为-1表示元素不存在，删除失败。
	 */
	public int deleteByElem(Object target) {
		Node n = head.getNext();
		if (length == 1 && n.getElem().equals(target)) { // 要删除仅有的一个元素
			head = null;
			end = null;
			length--;
			return 1;
		} else if (n.getElem().equals(target)) { // 要删除的是头元素
			head.setNext(n.getNext());
			end.setNext(n.getNext());
			length--;
			return 1;
		} else {
			for (int i = 1; i < length; i++) {
				// 要删除的n.getNext()节点
				if (n.getNext().getElem().equals(target)) {
					// 要删除的是尾节点
					if (++i == length) { 
						end = n;
					}
					n.setNext(n.getNext().getNext());
					length--;
					return i;
				} else {
					n = n.getNext();
				}
			}
			return -1;
		}
	}

	/**
	 * 通过位置来删除节点
	 * 
	 * @param location
	 *            被删除的位置
	 * @return 被删除的结点
	 */
	public Node deleteByLocation(int location) {
		// 位置超出范围
		if (location > length) {
			return null;
		} else {
			Node n = head.getNext();
			if (length == 1 && location ==1) { // 删除仅有的一个元素
				Node temp = end;
				head = null;
				end = null;
				length--;
				return temp;
			} else if (location == 1) { // 删除第一个元素
				head.setNext(n.getNext());
				end.setNext(n.getNext());
				length--;
				return n;
			} else {
				for (int i = 2; i < location; i++) {
					n = n.getNext();
				}
				Node temp = n.getNext();
				n.setNext(n.getNext().getNext());
				if (location == length) { // 删除尾节点
					end = n;
				}
				length--;
				return temp;
			}
		}
	}

	/**
	 * 循环链表的节点
	 * 
	 * @author CY
	 * @version 2014年7月15日
	 */
	public class Node {
		private Object elem = null;
		private Node next = null;

		public Node(Object node, Node next) {
			this.elem = node;
			this.next = next;
		}

		public Object getElem() {
			return elem;
		}

		public void setElem(Object elem) {
			this.elem = elem;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}
}
