package com.example;

import java.util.Arrays;

/**
 * 排序算法
 * @author qinxuewu
 * 2019年1月14日下午12:34:29
 *
 */
public class RankTest {

	public static void main(String[] args) {
//		maopao();
//		selectOrder();
//		insertionSort();

	}
	
	/**
     * 冒泡排序思路
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。  
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。  
     */
	public static void maopao(){
		int [] array={1,4,3,2,8,5,9,10};
		//临时变量 存储比价后最大的元素
		int tmp=0;
	
		
		
		for (int i = 0; i < array.length; i++) {
			//有序标记，每一轮的初始是true
			boolean isSorted = true;
			//内部循环代表每一轮的冒泡处理，先进行元素比较，再进行元素交换。
			for (int j = 0; j < array.length-i-1; j++) {
				if(array[j]>array[j+1]){
					tmp=array[j];
					array[j]=array[j+1];
					array[j+1]=tmp;
					isSorted=false; //还有元素交换 所以不是有序 
				}

			}
			//如果没有元素交换 说明后面回合都是有序的 无需排序
			if(isSorted){
				break;
			}
		}
		System.out.println("排序后的结果："+Arrays.toString(array));
	}
	
	/***
	 *  冒泡排序优化：
	 *  比如 数列是： 3 4 2 1 4 5 6 7 8 9
	 *  这个数列的特点是前半部分（3，4，2，1）无序，后半部分（5，6，7，8）升序，并且后半部分的元素已经是数列最大值。
	 *  所以只需要排序前半部分即可  所以要判断出数列有序元素的位置。
	 */
	public static void maopao2(){
		int [] array={1,4,3,2,8,5,9,10};
		//临时变量 存储比价后最大的元素
		int tmp=0;
	 
		//记录最后一次交换的位置		    
		int lastExchangeIndex =0;		    
		//无序数列的边界，每次比较只需要比到这里为止		    
		int sortBorder =array.length -1;
		for (int i = 0; i < array.length; i++) {
			//有序标记，每一轮的初始是true
			boolean isSorted = true;
			//内部循环代表每一轮的冒泡处理，先进行元素比较，再进行元素交换。
			for (int j = 0; j <sortBorder; j++) {
				if(array[j]>array[j+1]){
					tmp=array[j];
					array[j]=array[j+1];
					array[j+1]=tmp;
					//有元素交换，所以不是有序，标记变为false
	                isSorted =false;
	               //把无序数列的边界更新为最后一次交换元素的位置
	               lastExchangeIndex =j;
				}

			}
		  //  sortBorder就是无序数列的边界。每一轮排序过程中，sortBorder之后的元素就完全不需要比较了，肯定是有序的。
			 sortBorder  =lastExchangeIndex ;
			//如果没有元素交换 说明后面回合都是有序的 无需排序
			if(isSorted){
				break;
			}
		}
		System.out.println("排序后的结果："+Arrays.toString(array));
	}
	
	/**
	 * 选择排序  无论什么数据进去都是O(n2)的时间复杂度
	 * 工作原理：
	 * 	     首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
	 *     然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
	 */
	public static void selectOrder(){
		int [] array={1,4,3,2,8,5,9,10};
		for (int i = 0; i < array.length; i++){
			//最小元素的小标 ，默认是未排序的列的起始元素
			int minIndex=i;
			for (int j =i; j < array.length; j++) {
				if(array[j]<array[minIndex]){
					minIndex=j;   //找到最小的元数索引 循坏排毒 取得最小的
				}
			}
			//内层循坏每轮结束后,取得最小元素值
			 int temp=array[minIndex];			
			//当前找到最和当前为排序列末尾小标元素值位置 互换
			 array[minIndex] = array[i];
			 //把找到最小元素，存放到未排序排序序列的起始位置
	         array[i] = temp;
		}
		
		System.out.println("选择排序："+Arrays.toString(array));
	}
	
	/**
     * 插入排序
     * 
     *  从第一个元素开始，该元素可以认为已经被排序；
		取出下一个元素，在已经排序的元素序列中从后向前扫描；
		如果该元素（已排  序）大于新元素，将该元素移到下一位置；
		重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
		将新元素插入到该位置后；
		重复步骤2~5。
     * @param array
     * @return
     */
    public static void insertionSort() {
    	int [] array={1,4,3,2,8,5,9,10};
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
            System.out.println(Arrays.toString(array));
        }
        System.out.println(Arrays.toString(array));
    }
    
    
    
    
}
