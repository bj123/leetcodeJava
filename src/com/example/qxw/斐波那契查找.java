package com.example.qxw;

public class 斐波那契查找 {

	public static void main(String[] args) {
		int[] number = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	}

	/**
	 * 斐波那契数列
	 * 
	 * @return
	 */
	public static int[] fibonacci() {
		int[] f = new int[20];
		int i = 0;
		f[0] = 1;
		f[1] = 1;
		for (i = 2; i < 20; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

	public static int search(int[] data, int key) {
		int low = 0;
		int high = data.length - 1;
		int mid = 0;

		// 斐波那契分割数值下标
		int k = 0;

		// 序列元素个数
		int i = 0;

		// 获取斐波那契数列
		int[] f = fibonacci();
		
		 // 获取斐波那契分割数值下标  
        while (data.length > f[k] - 1) {  
            k++;  
        }  
        // 创建临时数组  
        int[] temp = new int[f[k] - 1];  
     
		return 0;
	}
}
