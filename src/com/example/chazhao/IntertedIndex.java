package com.example.chazhao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
 /**
  * 倒排索引
  * 倒排索引的优点显然就是查找记录非常快,基本等于生成索引表后,查找时都不 用去读取记录,就可以得到结果
  * 
  * 它的缺点是这个记录号不定长。维护比较困难，插入和删除操作都要做相应的处理
  * 
  * 1.txt：i live in hangzhou where are you

	2.txt：i love you i love you
	
	3.txt：i love you today is a good day
  */
public class IntertedIndex {
	// 存储单词对应 多个文件列表
	private Map<String, ArrayList<String>> map=new HashMap<>();
	//文路径列表
	private ArrayList<String> list;
	//词频统计
	private Map<String, Integer> nums=new HashMap<>();
	
	public void CreateIndex(String filepath){
		String[] words = null;
		try {
		
			File file=new File(filepath);
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String s=null;
			while((s=reader.readLine())!=null){
				//获取单词
				words=s.split(" ");
			}
			for (String string : words) {
				if (!map.containsKey(string)) {
					//集合汇总不不存在当前单词
					list=new ArrayList<String>();
					list.add(filepath);
					map.put(string, list); //单词对应的 文件列表
					nums.put(string, 1); //单词出现的次数 首次默认1
				}else {
					list=map.get(string);
					//如果没有包含过此文件名，则把文件名放入
					if (!list.contains(filepath)) {
						list.add(filepath);
					}
					//文件总词频数目
					int count=nums.get(string)+1;
					nums.put(string, count);
				}
			}
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		IntertedIndex index=new IntertedIndex();
		for(int i=1;i<=2;i++){
			String path="C:\\Users\\admin\\Desktop\\"+i+".txt";
			index.CreateIndex(path);
		} 
		for (Map.Entry<String, Integer> num : index.nums.entrySet()) {
			System.out.println("单词:"+num.getKey()+"   		"
					+ "出现次数："+num.getValue()+"  "+index.map.get(num.getKey()));
		}
	}
}
