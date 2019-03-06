package com.example;


/**
 * 最长公共前缀
 * 
 * 编写一个函数来查找字符串数组中的最长公共前缀。

     如果不存在公共前缀，返回空字符串 ""。
      
     示例 1:

	输入: ["flower","flow","flight"]
	输出: "fl"
	示例 2:
	
	输入: ["dog","racecar","car"]
	输出: ""
	解释: 输入不存在公共前缀。
 * @author qinxuewu
 * 2019年1月18日下午3:41:27
 *
 */
public class LettCode14 {
	public static void main(String[] args) {
//		String[] strs={"aca","cba"};
		String[] strs={"flower","flow","flight"};

		System.out.println(longestCommonPrefix(strs));
	}
	
	/**
	 * 所求的最长公共前缀子串一定是每个字符串的前缀子串。
	 * 所以随便选择一个字符串作为标准，把它的前缀串，与其他所有字符串进行判断，
	 * 看是否是它们所有人的前缀子串。这里的时间性能是O(m*n*m)
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		//数组长度小于1 返回空
		if(strs.length==0){
			return "";
		}
		if(strs.length == 1){
			return strs[0];
		}
		//选择一个字符串作为标准
		String temStr=strs[0];
		StringBuilder str=new StringBuilder();
		boolean flag = false;
		for(int i = 0; i <strs[0].length(); i++){
				//把它的前缀串，与其他所有字符串进行判断
				char foo=temStr.charAt(i);
				for (int j = 1; j < strs.length; j++) {
					//判断遍历下标是否越界或   前缀是否相等
					if(i >=strs[j].length() || strs[j].charAt(i)!=foo){
						  flag =true;
		                  break;
					}
				}	
				if (flag){
		                break;
		            }else{
		            	str.append(foo);
		         }
		}
		return str.toString();
    }
}
