package com.example.qxw.lianbiao02;

/**
 * https://www.cnblogs.com/smyhvae/p/4761593.html
 * 
 * @author qinxuewu 2019年2月1日下午6:20:58
 *
 */
public class MyLinkList {
	Node head; // 头指针
	Node current;// 当前结点对象
	int size;// 结点个数

	public MyLinkList() {
		// 初始化头结点，让头指针指向头结点。并且让当前结点对象等于头结点。
		this.head = current = new Node(null);
		this.size = 0;// 单向链表，初始长度为零。
	}

	// 定位函数，实现当前操作对象的前一个结点，也就是让当前结点对象定位到要操作结点的前一个结点。
	// 比如我们要在a2这个节点之前进行插入操作，那就先要把当前节点对象定位到a1这个节点，然后修改a1节点的指针域
	public void index(int index) throws Exception {
		if (index < -1 || index > size - 1) {
			throw new Exception("参数错误！");
		}
		// 说明在头结点之后操作。
		if (index == -1) // 因为第一个数据元素结点的下标是0，那么头结点的下标自然就是-1了。
			return;
		current = head.next;
		int j = 0;// 循环变量
		while (current != null && j < index) {
			current = current.next;
			j++;
		}

	}


	public void delete(int index) throws Exception {
		// 判断链表是否为空
		if (isEmpty()) {
			throw new Exception("链表为空，无法删除！");
		}
		if (index < 0 || index > size) {
			throw new Exception("参数错误！");
		}
		index(index - 1);// 定位到要操作结点的前一个结点对象。
		current.setNext(current.next.next);
		size--;
	}

	public Object get(int index) throws Exception {
		if (index < -1 || index > size - 1) {
			throw new Exception("参数非法！");
		}
		index(index);

		return current.getElement();
	}


	public void insert(int index, Object obj) throws Exception {
		if (index < 0 || index > size) {
			throw new Exception("参数错误！");
		}
		index(index - 1);// 定位到要操作结点的前一个结点对象。
		current.setNext(new Node(obj, current.next));
		size++;
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public int size() {

		return this.size;
	}

}
