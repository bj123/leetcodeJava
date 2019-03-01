package com.example.chazhao;
import java.util.ArrayList;

/**
 * 分块索引
 * 
 *  分块有序,是把数据集的记录分成了若干块,并且这些块需要满足两个条件:

	块内无序：即每一块内的记录宋要求有序。
	
	块间有序：
	例如,要求第二块所有记录的关键字均要大于第一块中所有记录的关键字,
	第三块的所有记录的关键字均要大于第二块的所有 记录关键字…因为只有块间有序,才有可能在查找时带来放率。
	
	
 * @author qinxuewu
 * 2019年2月15日下午2:14:14
 *
 */
public class BlockIndex {
	public int[] index; //索引表
	public ArrayList[] list; //块内元素 可以无序
	
	//初始化分块索引表
	public BlockIndex(int[] index) {
			this.index=index;
			this.list=new ArrayList[index.length];
			for (int i = 0; i < list.length; i++) {
				// 分配元素到各自的块内
				list[i]=new ArrayList<>();
			}
	}

	/**
	 * 分配块内元素
	 */
	public void insert(int value) {
		for (int i = 0; i < index.length; i++) {
			if(value<index[i]){
				list[i].add(value);
				break;
			}
		}
	}
	/**
	 * 打印每块元素
	 */
	public void printAll() {
		for (int i = 0; i < list.length; i++) {
			ArrayList l = list[i];
			System.out.print("ArrayList" + i + ":");
			for (int j = 0; j < l.size(); j++) {
				System.out.print(l.get(j) + "  ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 二分查找
	 */
	private int binarysearch(int value) {
		int start = 0;
		int end = index.length;
		int mid = -1;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (index[mid] > value) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
	
	/**
	 * 查找元素
	 */
	public boolean search(int data) {
		int i = binarysearch(data);
		// 先二分查找确定在哪个块
		for (int j = 0; j < list[i].size(); j++) {
			// 然后顺序查找在该块内哪个位置
			if (data == (int) list[i].get(j)) {
				System.out.println(String.format("查找元素为  %d 第: %d块  第%d个 元素",data, i + 1, j + 1));
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int [] data={1,12,22,10,18,23,5,15,27};
		//分为三个块 
		int[] index = {10, 20, 30};
		BlockIndex blocksearch=new BlockIndex(index);
		for (int i = 0; i < data.length; i++) {
			blocksearch.insert(data[i]);
		}
		blocksearch.printAll();

		blocksearch.search(18);
	}

}
