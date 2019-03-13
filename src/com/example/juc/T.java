package com.example.juc;

public class T {
	//T中声明的一个静态字段被赋值
	private static int i=1;
	 static{
		//当此类在虚拟机中初始化的时候，此static块将会被执行
	        System.out.println("SuperClass  init");
	  }

	/**
	 * T是一个类，且T中声明的一个静态方法被调用。
	 */
	public static void test(){
		System.out.println("T是一个类，且T中声明的一个静态方法被调用。");
	}
	
	public static void main(String[] args) {
//		T t=new T();
//		T.test();
	
//		System.out.println(T.i);
		//T中声明的一个静态字段被赋值
		T.i=2;
	}
	
}
