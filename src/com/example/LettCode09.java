package com.example;


/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
			 	示例 1:
			
				输入: 121
				输出: true
				
				你能不将整数转为字符串来解决这个问题吗？
 * @author qinxuewu
 * 2019年1月11日下午2:52:10
 *
 */
public class LettCode09 {

	public static void main(String[] args) {
		int x=122;
		
//		System.out.println(isPalindrome(x));
//		System.out.println(isPalindrome("1001"));
		System.out.println(isPalindrome2(x));
//		System.out.println(isPalindrome4(x));
	}
	
    public static boolean isPalindrome(int x) {
    	String reverseNumber = new StringBuilder(String.valueOf(x)).reverse().toString(); 
    	return reverseNumber.equals(String.valueOf(x));
    }
    
    /**
     * 如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
     * 所以直接判断一半既可     如果数字是长度是奇数位  
     */
    public static Boolean isPalindrome(String str){
        boolean result=false;
        for(int i=0; i<str.length()/2;i++){
            if(str.charAt(i) == str.charAt(str.length()-1-i)){
                result=true;
            }else{
                return result;
            }
        }
        return result;
    }
    /**
     * 不将整数转为字符串来解决这个问题
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
    	// 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
    	if(x<0 || (x % 10 == 0 && x != 0) ){
    		return false;
    	} 
    	// 对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1
    	// 要得到倒数第二位数字，我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，
    	// 再求出上一步结果除以10的余数，122 % 10 = 2，就可以得到倒数第二位数字
    	// 如果继续这个过程，我们将得到更多位数的反转数字。
    	  int revertedNumber = 0;
          while(x > revertedNumber) {
              revertedNumber = revertedNumber * 10 + x % 10;
              x /= 10;  //表示x等于x整除10，不要余数

          }

          // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
          // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
          // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
          return x == revertedNumber || x == revertedNumber/10;
    }
    
    public static boolean isPalindrome4(int x) {
        if(x<0){
        	return false;
        }
        int rem=0,y=0;
        int quo=x;
        while(quo!=0){
            rem=quo%10;
            y=y*10+rem;
            quo=quo/10;
        }
        System.out.println("y="+y);
        System.out.println("x="+x);
        return y==x;
    }
}
