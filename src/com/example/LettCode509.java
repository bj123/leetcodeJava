package com.example;

/**
 * 斐波那契数
 * 
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * 
 * F(0) = 0, F(1) = 1 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 
 * 
 * @author qinxuewu 2019年3月5日上午10:39:59
 *
 */
public class LettCode509 {
	public static void main(String[] args) {
		System.out.println(fib(4));
	}

	public static int fib(int N) {
		if (N < 1) {
			return 0;
		}
		if (N==1 || N==2) {
			return 1;
		}

		return fib(N-1)+fib(N-2);
	}
}
