package com.example;

import java.util.Arrays;

/**
 *  加一
 *  
 *  给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *  最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *  你可以假设除了整数 0 之外，这个整数不会以零开头。
 *  
 *  输入: [1,2,3]
 *  输出: [1,2,4]
 *  解释: 输入数组表示数字 123。
 *  
 * @author qinxuewu
 * 2019年3月4日上午10:00:47
 *
 */
public class LettCode66 {

	
	public static void main(String[] args) {
		int[] digits={9};
		System.out.println(Arrays.toString(plusOne2(digits)));
	}
	
	/**
	 * 解法的关键在于弄明白什么情况下会产生进位。
	 * @param digits
	 * @return
	 */
	 public static int[] plusOne2(int[] digits) {
         int n = digits.length;
         for(int i=n-1;i>=0;i--){
             //非9加1
             if(digits[i]<9){
                 digits[i]++;
                 return digits;
             }else{
                 //逢9置0
                 digits[i]=0;
             }
         }
         //全部为9，则需要数组扩充1位
         int[] result = new int[n+1];
         result[0] = 1;
         return result;
     }

}
