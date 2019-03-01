package com.example;

/**
 * 搜索插入位置
 * 
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 
 * 你可以假设数组中无重复元素。
 * 
 * @author qinxuewu 2019年2月25日上午9:50:42
 *
 */
public class LettCode35 {

	public static void main(String[] args) {
		int [] nums={1,3,5,6};
		int target=0;
		System.out.println(searchInsert(nums, target));
	}
	
	/**
	 * 思路：二分法查找，查找不到的时候再处理需要插入的位置
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
		  int left=0;
		  int right=nums.length-1;
		  int mid=0;
		  while(left<=right){
			   mid=(left+right)/2;
			  if(nums[mid]>target){
				  right=mid-1;
			  }else if(nums[mid]<target){
				  left=mid+1;
			  }else{
				  return mid;
			  }
		  }
		  for(int i = 0;i<nums.length;i++){
	            if(target<nums[i]) {
	                //插入
	                return i;
	           }
	        }
	      return nums.length;
	}
}
