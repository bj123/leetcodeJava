package com.example;

/**
 * 爬楼梯
 * 
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
		        输入： 2
			输出： 2
			解释： 有两种方法可以爬到楼顶。
			1.  1 阶 + 1 阶
			2.  2 阶
			
			
 * @author qinxuewu
 * 2019年3月5日上午10:18:18
 *
 */
public class LettCode70 {

	public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}
	
	
	/**
	 * 两种方法，一种是递归，一种是循环。递归的写法简单但性能消耗大，循环的写法也很简单，但性能比递归好太多
	 * 
	 * 动态规划思路解题 推导式 f(n) = f(n-1) + f(n+1) 需要两个变量进行辅助存储中间推导结果
	 * @param n
	 * @return
	 */
    public static int climbStairs(int n) {
    	  if (n < 1) {
              return 0;
          }
          int temp1 = 1;
          int temp2 = 2;
          int total = 0;
          for (int i = 0; i < n; ++i) {
              if (i == 0) {
                 total =  temp1;
              } else if (i == 1) {
                  total = temp2;
              } else {
                  total = temp1 + temp2;
                  temp1 = temp2;
                  temp2 = total;
              }
          }
          return total;
    }
}
