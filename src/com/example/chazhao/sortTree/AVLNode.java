package com.example.chazhao.sortTree;

public class AVLNode<T extends Comparable> {
	public AVLNode<T> left;//左结点

    public AVLNode<T> right;//右结点

    public T data;

    public int height;//当前结点的高度

    public AVLNode(T data) {
        this(null,null,data);
    }

    public AVLNode(AVLNode<T> left, AVLNode<T> right, T data) {
        this(left,right,data,0);
    }

    public AVLNode(AVLNode<T> left, AVLNode<T> right, T data, int height) {
        this.left=left;
        this.right=right;
        this.data=data;
        this.height = height;
    }
}
