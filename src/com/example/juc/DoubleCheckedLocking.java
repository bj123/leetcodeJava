package com.example.juc;

/**
 * 双重锁检查的单列模式
 * @author qinxuewu
 * 2019年3月8日下午3:52:40
 *
 */
public class DoubleCheckedLocking {
	/**
	 * volatile修饰  防止分配对象时的重排序
	 */
	private volatile static DoubleCheckedLocking inteface;
	
	public static DoubleCheckedLocking getInteface(){
		if(inteface==null){  //1 第一次检查
			synchronized (DoubleCheckedLocking.class) {  //2 加锁
				if(inteface==null){		//3 第二次检查
				
					/**
					 * 1.分配对象的内存空间
					 * 2.初始化对象
					 * 3.设置inteface指向刚分配的内存地址
					 * 
					 *  2和3操作可能会被重排序，多个线程访问时 就可能拿到未初始化的对象
					 *  两种解决方案：
					 *  基于volatile的解决方案
					 *  基于类初始化的解决方案
					 */
					inteface=new DoubleCheckedLocking(); 
				}
			}
		}
		return inteface;
	}
}
