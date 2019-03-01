package com.example.qxw;

public class 二分法查找 {
	
	public static void main(String[] args) {
		 int[] number = {1,2,3,4,5,6,7,8,9,10};
	     int key = 11;
	     System.out.println("递归查找出的下标："+binSearch(number,0,number.length-1,key));
	     System.out.println("查找出的下标："+halfSort(number, key));

	}
	

	public static int halfSort(int[] data,int key){
		int left=0, right=data.length-1;		
		while(left<=right){
			int mid = (left+right)/2;
			if(data[mid]>key){
				right = mid-1;
			}else if(data[mid]<key){
				left = mid+1;
			}else{
				return mid;
			}
		}
		return -1;

	  }
	
	 // 二分查找递归实现   
    public static int binSearch(int srcArray[], int start, int end, int key){   
        int mid = (end - start) / 2 + start;   
        if (srcArray[mid] == key) {   
            return mid;   
        }   
        if (start >= end) {   
            return -1;   
        } else if (key > srcArray[mid]) {   
            return binSearch(srcArray, mid + 1, end, key);   
        } else if (key < srcArray[mid]) {   
            return binSearch(srcArray, start, mid - 1, key);   
        }   
        return -1;   
    } 
}
