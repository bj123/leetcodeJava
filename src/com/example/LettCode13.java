package com.example;



/**
 * 罗马数字转整数
 * 
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 
 * 字符 数值
 *  I 1
 *  V 5
 *  X 10 
 *  L 50 
 *  C 100 
 *  D 500 
 *  M 1000
 * 
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V +
 * II 。
 * 
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
 * 减小数 1 得到的数值 4 。 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * 
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 给定一个罗马数字，将其转换成整数。
 * 
 * @author qinxuewu 2019年1月16日下午2:54:33
 *
 */
public class LettCode13 {

	/**
	 * 思路： 根据条件特别判断 IV IX,XL,XC,CD,CM  这个六种组个和情况 做减法
	 *      其余根据字母取值对应的数据做累加运算即可
	 * @param args
	 */
	public static void main(String[] args) {
			System.out.println(romanToInt(1994));
	}

	 public int romanToInt(String s) {
	        int temp=0;
	        for(int i=0; i<s.length();i++){
	            if((s.charAt(i)=='I' || s.charAt(i)=='X'|| s.charAt(i)=='C')&& i<s.length()-1){
	                if(s.substring(i,i+2).equals("IV")){
	                    temp=temp+4;
	                    i=i+1;
	                    continue;
	                }
	                if(s.substring(i,i+2).equals("IX")){
	                    temp=temp+9;
	                    i=i+1;
	                    continue;
	                }
	                if(s.substring(i,i+2).equals("XL")){
	                    temp=temp+40;
	                    i=i+1;
	                    continue;
	                }
	                if(s.substring(i,i+2).equals("XC")){
	                    temp=temp+90;
	                    i=i+1;
	                    continue;
	                }
	               if(s.substring(i,i+2).equals("CD")){
	                    temp=temp+400;
	                    i=i+1;
	                    continue;
	                }   
	                if(s.substring(i,i+2).equals("CM")){
	                    temp=temp+900;
	                    i=i+1;
	                    continue;
	                } 
	            } 
	            if(s.charAt(i)=='I'){
	                temp=temp+1;
	                  continue;
	            }
	            if(s.charAt(i)=='V'){
	                temp=temp+5;
	                  continue;
	            } 
	           if(s.charAt(i)=='X'){
	                temp=temp+10;
	                  continue;
	            } 
	            if(s.charAt(i)=='L'){
	                temp=temp+50;
	                  continue;
	            } 
	            if(s.charAt(i)=='C'){
	                temp=temp+100;
	                  continue;
	            } 
	            if(s.charAt(i)=='D'){
	                temp=temp+500;
	                  continue;
	            } 
	            if(s.charAt(i)=='M'){
	                temp=temp+1000;
	                  continue;
	            } 
	        }
	        return temp;      
	    }
	 
	 
	 //整数转罗马数字
	 /**
	  * 通常情况下，罗马数字中小的数字在大的数字的右边
	  * 
	  * 思路：
	  * 1 列出所有特例和普通组合情况，用两个数组存储
	  * 2 循环遍历匹配输入的整数，是否大于等于数组中所有的组合情况
	  * 3 如果大于或等于就把整数减去匹配到数值，且获得罗马的数字赋值给临时变量。继续while循坏 重复以上过程。
	  * @param num
	  * @return
	  */
	 public static String romanToInt(int num) {
		 int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
	     String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
	     String temp="";   
	     for(int i=0; i<13; i++){
	            while(num>=values[i]){
	                num=num-values[i];
	                temp=temp+ reps[i];
	            }
	       }
	       return temp;
	 }
}
