package com.example.qxw;
import com.example.qxw.inteferce.MyList;
/**
 * 一个简单的泛型 线性表
 * @author qinxuewu
 * 2019年1月31日下午3:32:56

 */
public class MyArrayList<E> implements MyList<E> {
	
	//数组作为线性表的存储空间
	private  Object[] elementData;

	//线性表的当前长度
	private int size;

	public MyArrayList(int initialCapacity) {
		//初始化数据大小
		this.elementData=new Object[initialCapacity];
		
		this.size=0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(Object o) {
	     if (o == null){
	            for (int i = 0; i < size; i++)
	                if (elementData[i]==null)
	                    return true;
	        }else{
	            for (int i = 0; i < size; i++)
	                if (o.equals(elementData[i])){
	                	return true;
	                }   
	    }
		return false;
	}

	@Override
	public void add(int i, E e) throws Exception{
		if(size==elementData.length){
			  throw new Exception("存储空间已满");
		}
		if(i<0 || i>size){
			  throw new Exception("添加参数下标越界");
		}
	    for (int j = size; j > i; j--){
	    	// 插入位置及之后的元素后移  比如 123  插入元素4 到的2的位置
			 elementData[j] = elementData[j - 1]; ;
			 System.out.println("移动："+toArray());
		 }

	 	 elementData[i] = e; //插入
	     ++size; //长度增加
		 System.out.println("移动："+toArray());
	}

	@Override
	public void add(E e)throws Exception {
		if(size==elementData.length){
			throw new Exception("存储空间已满");
		}
		  elementData[size++] =e;

	}
	@Override
	public void remove(int i)throws Exception {
		if (i < 0 || i > size - 1){
			 throw new Exception("删除位置不合法");
		}
		for (int j = i; j < size - 1; j++)  {
			  elementData[j] = elementData[j + 1];// 被删除元素之后的元素左移  
		 }
		  size--; // 表长度减1  
	}
	@Override
	public String toArray() {
		StringBuilder str=new StringBuilder();
		str.append("toArray:[");
		for (int i = 0; i <size; i++) {
			str.append(elementData[i]+",");
		}
		str.append("]");
		return str.toString();
	}

	
	public static void main(String[] args) {
		MyList<Integer> list=new MyArrayList<>(10);
		try {
			list.add(1);
			list.add(2);
			list.add(3);
			System.out.println(list.size());
			System.out.println(list.toArray());
//			list.remove(0);
//			System.out.println(list.size());
//			System.out.println(list.toArray());
			list.add(1, 4);
			System.out.println(list.toArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
