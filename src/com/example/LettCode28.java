package com.example;
/**
 *  实现 strStr() 函数。 strstr(str1,str2) 函数用于判断字符串str2是否是str1的子串。如果是，则该函数返回str2在str1中首次出现的地址

	给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
	
	示例 1:
	输入: haystack = "hello", needle = "ll"
	输出: 2  
	
	
	示例 2:
	输入: haystack = "aaaaa", needle = "bba"
	输出: -1
	
	
 * @author qinxuewu
 * 2019年2月22日下午3:24:50
 *
 */
public class LettCode28 {

	public static void main(String[] args) {
		System.out.println(strStr("aaaaa", "bba"));
	}
	
	
	/**
	 * 思路：
	 * 
	 *  从(下标0至needle+1)开始切割haystack字符串进行和needle匹配是否相同
	 *  如果不想等于则起切割的起点和重点进行加1 从新开始切割匹配。
	 *  如果匹配成功则直接返回起始下标
	 *  当前切割的长度大于 字符串的长度时 则返回-1
	 *  
	 * @param haystack
	 * @param needle
	 * @return
	 */
	 public static int strStr(String haystack, String needle) {
		 if(needle==""|| needle.length()==0){
			 return 0;
		 }
		 int n=haystack.length();
		 if(n<needle.length()){
			 return -1;
		 }
		 int index=-1;
		 int i=0;
		 int k=needle.length();
		 while(i+k<=haystack.length()){
			    if(haystack.substring(i,i+needle.length()).equals(needle)){
	                return i;
	            }else{
	                i++;
	            }
		 }
		  
		 return index;
	}
}
