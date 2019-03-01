package com.example.qxw;

public class 插值查找 {

	public static void main(String[] args) {
		 int[] number = {1,2,3,4,5,6,7,8,9,10};
	     int key = 10;
	     System.out.println("递归查找出的下标："+binSearch(number,0,number.length-1,key));
	     System.out.println("查找出的下标："+halfSort(number, key));
	}
	
	public static int halfSort(int[] data,int key){
		int left=0, right=data.length-1;		
		while(left<=right){
		    int mid=left+(right-left)*(key-data[left])/(data[right]-data[left]); //插值
			if(data[mid]>key){
				right = mid-1;
			}else if(data[mid]<key){
				left = mid+1;
			}else{
				return mid;
			}
		}
		return 0;

	  }
	
	 // 二分查找递归实现   
   public static int binSearch(int data[], int start, int end, int key){     
       int mid=start+(end-start)*(key-data[start])/(data[end]-data[start]);
       if (data[mid] == key) {   
           return mid;   
       }   
       if (start >= end) {   
           return -1;   
       } else if (key > data[mid]) {   
           return binSearch(data, mid + 1, end, key);   
       } else if (key < data[mid]) {   
           return binSearch(data, start, mid - 1, key);   
       }   
       return -1;   
   } 

}
