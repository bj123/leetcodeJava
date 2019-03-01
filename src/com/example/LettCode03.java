package com.example;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author qinxuewu
 * 2019年1月11日下午2:52:10
 *
 */
public class LettCode03 {

	public static void main(String[] args) {
		String str="abcabcbb";
//		lengthOfLongestSubstring(str);
		System.out.println(lengthOfLongestSubstring(str));
		
	}
	
	/**
	 * 思路：  1 通过两个for循坏嵌套 遍历所有字符串
	 * @param s
	 * @return
	 */
	 public static int lengthOfLongestSubstring(String s) {
	        int n = s.length();
	        int ans = 0;
	        for (int i = 0; i < n; i++){
	        	 for (int j = i + 1; j <= n; j++){
	        		 	/**
	        		 	 * 内存循坏
	        		 	 * 第一次遍历：s=abcabcbb, i=0,j=1
	        		 	 * 第一次遍历：s=abcabcbb, i=0,j=2
	        		 	 * 第一次遍历：s=abcabcbb, i=0,j=3 
	        		 	 */
		                if (allUnique(s, i, j)) {	
		                	//如果返回true   说明 i 到j下标的字符串是 无重复字符的最长子串
		                	if(ans==0){
		                		ans++;
		                	}
		                	if(ans<( j - i)){
		                		ans=j - i;
		                	}
		                	 System.err.println("ans:"+ans);
		                }
		            }
	        }
	           
	          return ans;
	    }

	    public  static boolean allUnique(String s, int start, int end) {
	    	/**
	    	 * 第一次遍历：s=abcabcbb, start=0,end=1  如果子字符串中的字符都是唯一的，它会返回true
	    	 */
	        Set<Character> set = new HashSet<>();
	        for (int i = start; i < end; i++) {
	        	// 循坏遍历指定的起-终下标  取出对应下标的字符串
	            Character ch = s.charAt(i);
	            if (set.contains(ch)) {
	            	//如果存在直接返回
	            	return false;
	            }
	            //不存在放入set
	            set.add(ch);
	        }
	        return true;
	    }
	    
	    
	    public int lengthOfLongestSubstring2(String s) {
	        int n = s.length(), ans = 0;
	        Map<Character, Integer> map = new HashMap<>(); 
	      
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s.charAt(j))) {
	                i = Math.max(map.get(s.charAt(j)), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s.charAt(j), j + 1);
	        }
	        return ans;
	    }
}
