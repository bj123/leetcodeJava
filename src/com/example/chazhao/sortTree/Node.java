package com.example.chazhao.sortTree;

public class Node {
	private int value;// 结点值
	protected Node leftChild;// 左孩子结点
	protected Node rightChild;// 右孩子结点

	public Node(int value) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
