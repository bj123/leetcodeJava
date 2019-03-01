package com.example.qxw.lianbiao01;
/**
 * 泛型 线性表抽象类
 * 
 * @author qinxuewu
 * 2019年1月31日下午3:16:55
 *
 */
public interface MyList<E> {
	 int size();
	 boolean contains(Object o);
	 void add(int i,E e)throws Exception;
	 void add(E e)throws Exception;
	 void remove(int i)throws Exception ;
	 String toArray();
}
