package com.example.chazhao.sortTree;
import java.util.Stack;
public class SortTree {
	// 递归实现二叉排序树的插入
	public void insertBST(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			root.leftChild = null;
			root.rightChild = null;
		}

		//大于根节点则 分配在右子树
		if (value > root.getValue()) {
			//如果右子树为空则直接赋值给右子树
			if (root.rightChild == null) {
				root.rightChild = new Node(value);
			} else {
				//右子树不为空，则递归判断，以右子树为父节点的
				insertBST(root.rightChild, value);
			}
		} else {
			//左子树分配原理同上
			if (root.leftChild == null) {
				root.leftChild = new Node(value);
			} else {
				insertBST(root.leftChild, value);
			}
		}
	}

	// 递归实现二叉排序树查找
	public Node searchBSTByRecursion(Node root, int value) {
		if (root == null) {
			return null;
		}

		if (root.getValue() == value) {// 步骤1
			return root;
		} else if (value < root.getValue()) {// 步骤2
			return searchBST(root.leftChild, value);
		} else if (value > root.getValue()) {// 步骤3
			return searchBST(root.rightChild, value);
		}

		return null;// 如果没找到，就返回null
	}

	// 非递归实现二叉排序树查找
	public Node searchBST(Node root, int value) {
		Node temp = root;
		while (temp != null) {
			if (temp.getValue() == value) {
				return temp;
			}
			if (value < temp.getValue()) {
				temp = temp.leftChild;
			} else {
				temp = temp.rightChild;
			}
		}

		return null;
	}

	// 二叉排序树的删除
	public Node deleteBST(Node root, int value) {
		Node cur = root; // 当前结点
		Node parent = null; // 待删结点的父结点
		Node delNode = null; // 在后面用来引用待删结点
		Node temp = null; // 作为一个局域内的根结点

		// 查找待删结点p和待删结点的父结点f
		while (cur != null) {
			if (value == cur.getValue()) {
				break;
			}
			parent = cur;
			if (value > cur.getValue()) {
				cur = cur.rightChild;
			} else {
				cur = cur.leftChild;
			}
		}

		// 当前结点为null，即没有找到待删结点。 此时cur指向待删结点
		if (cur == null) {
			return null;
		}
		// 待删结点只有右子树
		if (cur.leftChild == null) {
			// 待删结点的父结点为null，即待删结点为根结点
			if (parent == null) {
				// 根结点为待删结点的右子树
				root = cur.rightChild;
			} else if (parent.leftChild == cur) { // 待删结点为父结点的左子树
				// 把待删结点的右子树作为待删结点父结点的左子树
				parent.leftChild = cur.rightChild;
			} else { // 待删结点为父结点的右子树
				parent.rightChild = cur.rightChild;
			}
		} else {// 待删结点有左子树，要找左子树的最右下角的结点
			temp = cur;
			delNode = cur.leftChild; // 此时s指向待删结点
			while (delNode.rightChild != null) {// 查找待删结点的最右下角结点
				temp = delNode;
				delNode = delNode.rightChild;
			}
			if (temp == cur) {// 即，待删结点没有右子树，把左子树向上移动
				temp.leftChild = delNode.leftChild;
			} else {// 即，待删结点有右子树
				temp.rightChild = delNode.leftChild;
			}
			cur.setValue(delNode.getValue());
		}

		return root;
	}

	//先序遍历
    public void preOrder(Node root) {
        if(root != null) {
            System.out.print(root.getValue() + " ");
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }
    /**
     * 先序遍历
     * 非递归
     */
    public void preOrder1(Node root){
        Stack<Node> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null) {
                System.out.print(root.getValue() + "   ");
                stack.push(root);
                root = root.leftChild;
            }
            if(!stack.empty()){
            	root = stack.pop();
            	root = root.rightChild;
            }
        }
    }
    //中序遍历
    public void inOrder(Node root) {
        if(root != null) {
            inOrder(root.leftChild);
            System.out.print(root.getValue() + " ");
            inOrder(root.rightChild);
        }
    }
    
    /**
     * 中序遍历
     * 非递归
     */
    public void inOrder1(Node root) {
        Stack<Node> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while (root != null){
                stack.push(root);
                root = root.leftChild;
            }
            if(!stack.empty()){
            	root = stack.pop();
                System.out.print(root.getValue() + "   ");
                root = root.rightChild;
            }
        }
    }
    //后序遍历
    public void postOrder(Node root) {
        if(root != null) {
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.print(root.getValue() + " ");
        }
    }



    /**
     * 后序遍历
     * 非递归
     */
    public void posOrder1(Node root){
        Stack<Node> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while(root != null || !stack1.empty()){
            while (root != null){
                stack1.push(root);
                stack2.push(0);
                root = root.leftChild;
            }

            while(!stack1.empty() && stack2.peek() == i){
                stack2.pop();
                System.out.print(stack1.pop().getValue() + "   ");
            }

            if(!stack1.empty()){
                stack2.pop();
                stack2.push(1);
                root = stack1.peek();
                root = root.rightChild;
            }
        }
    }
	public static void main(String[] args) {
		SortTree t=new SortTree();
		Node root=new Node(44); //根节点
		t.insertBST(root, 21); //左子树		
		t.insertBST(root, 65); //右子树
		t.insertBST(root, 14);
		t.insertBST(root, 72);
		t.insertBST(root, 32);
		t.insertBST(root, 58);
		t.insertBST(root, 80);
		t.postOrder(root);
		System.out.println("-----------------");
		t.posOrder1(root);
//		t.deleteBST(root, 44);
		System.out.println();
//		t.preOrder(t.deleteBST(root, 44));
	}
}
