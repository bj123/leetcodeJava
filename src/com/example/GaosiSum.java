package com.example;

/**
 * 高斯求和
 * 1+2+3+4+5+6…+100 结果集
 * 1+2+3+4+5+6…+n
 * @author qinxuewu
 * 2019年1月18日下午1:26:13
 *
 */
public class GaosiSum {

	
	/**
	 * 1+2+3+4+......+97+98+99+100
	 * 
	 * 高斯求和：
	 * 	1+100=101
	 *  2+99=101
	 *  3+98=101
	 *  4+97=101
	 * 所以得出结果101 X 50(100的一半)
	 * @param args
	 */
	public static void main(String[] args) {
		int  sum = 0,n = 100;
		sum = (1 + n) *(n/2);
		System.out.println(sum);
	}
}
