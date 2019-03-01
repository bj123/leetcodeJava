package com.example;

/**
 *  最后一个单词的长度
 *  
 *  给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

	如果不存在最后一个单词，请返回 0 。

	说明：一个单词是指由字母组成，但不包含任何空格的字符串。
	
	示例:

	输入: "Hello World"
	输出: 5
 * @author qinxuewu
 * 2019年2月27日上午9:47:49
 *
 */
public class LettCode58 {

	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("a"));
	}
	
	/**
	 * 分割字符串方法 耗时七秒
	 * @param s
	 * @return
	 */
	 public static  int lengthOfLastWord(String s) {
		 if(s.trim().length()==0){
			 return 0;
		 }
		 String [] strings=s.split(" ");
		 String lastStr=strings[strings.length-1];
		 return lastStr.length();
	  }
	 
	 /**
	  * 耗时5秒
	  * @param s
	  * @return
	  */
	 public static int lengthOfLastWord2(String s) {
	        int length=s.length();
	        int num=0;
	        for(int i=length-1;i>=0;i--) {
	            if(s.charAt(i)!=' '){
	            	  num++;
	            }else{
	                if(num!=0)
	                    break;
	            }
	        }
	        return num;
	    }
}
