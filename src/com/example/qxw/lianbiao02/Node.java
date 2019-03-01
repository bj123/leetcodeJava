package com.example.qxw.lianbiao02;

/**
 * 单链的节点模型
 * 
 * @author qinxuewu 2019年2月1日下午4:08:45
 *
 */
public class Node {
	Object element; // 数据域
	Node next; // 指针域

	// 头结点的构造方法
	public Node(Node nextval) {
		this.next = nextval;
	}

	// 非头结点的构造方法
	public Node(Object obj, Node nextval) {
		this.element = obj;
		this.next = nextval;
	}

	// 获得当前结点的指针域
	public Node getNext() {
		return this.next;
	}

	// 获得当前结点数据域的值
	public Object getElement() {
		return this.element;
	}

	// 设置当前结点的指针域
	public void setNext(Node nextval) {
		this.next = nextval;
	}

	// 设置当前结点数据域的值
	public void setElement(Object obj) {
		this.element = obj;
	}

	public String toString() {
		return this.element.toString();
	}
}
