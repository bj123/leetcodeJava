package com.example;

import java.util.Stack;

/**
 * 有效的括号
 * 
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
		左括号必须用相同类型的右括号闭合。
		左括号必须以正确的顺序闭合。
		
 * @author qinxuewu
 * 2019年2月19日下午1:01:45
 *
 */
public class LettCode20 {

	public static void main(String[] args) {
		System.out.println(isValid("{}()[]"));
	}
	
	/**
	 * 利用栈的先进后出
	 * 
	 * 1.初始化栈 S。
	 * 2.一次处理表达式的每个括号。
	 * 3.如果遇到开括号，我们只需将其推到栈上即可。这意味着我们将稍后处理它，让我们简单地转到前面的 子表达式。
	 * 4.如果我们遇到一个闭括号，那么我们检查栈顶的元素。如果栈顶的元素是一个 相同类型的 左括号，那么我们将它从栈中弹出并继续处理。否则，这意味着表达式无效。
	 * 5.如果到最后我们剩下的栈中仍然有元素，那么这意味着表达式无效。
	 * 
	 * @param s
	 * @return
	 */
	 public static boolean isValid(String s) {
		if(s.equals("")){
				return true;
		}
	    if(s.length()<=1){
			return false;
	    }	
	  Stack<Character> stack=new Stack<>();
	  for (int i = 0; i < s.length(); i++) {
		 char str=s.charAt(i);
		 if(str=='(' || str=='{'|| str=='['){
			 stack.push(str);
		 }else{
			 if(stack.size()==0){
				 return false;
			 }
			 ///访问栈顶元素			
			 char pop =stack.pop();
			 if (pop=='('&& str==')'  ||  pop=='['&& str==']' ||   pop=='{'&&str=='}'){
	                continue;
	          }else{
	                return false;
	          }
		 }
		 
	}
		//栈中仍然有元素，那么这意味着表达式无效
	    return stack.isEmpty();
	 }
}
