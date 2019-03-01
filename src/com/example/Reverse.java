package com.example;

/**
 * 整数反转
 * @author qinxuewu
 * 2019年1月11日下午6:44:22
 *
 */
public class Reverse {

	public static int reverse(int x) {
		int rev = 0;   
		while(x != 0) {
			int pop = x % 10;   // 取得余数 
			x /= 10;           //进行去位 
			//判断是否正溢出
			if(rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
				return 0;
			}
			//判断是否负溢出
			if(rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}
			
			rev = rev * 10 + pop;    //求出反转整数
		}
		
		return rev; 
	}

	public static void main(String[] args) {
		System.out.println(reverse(1001));
	}
}
