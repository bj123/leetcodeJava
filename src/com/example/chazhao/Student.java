package com.example.chazhao;

import java.util.Arrays;

public class Student  implements Comparable{

	public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }
    public int no;
    public String name;

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        if (no < other.no) //这里比较的是什么 sort方法实现的就是按照此比较的东西从小到大排列
            return -1;
        if (no > other.no)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        Student[] array=new Student[]{
                new Student(2,"2222"),new Student(1,"1111"),
                new Student(3,"3333"),new Student(4,"44444"),
                new Student(5,"5555"),new Student(6,"7777"),
        new Student(7,"7777"),new Student(8,"8888")};

        int key=4;
        System.out.println(denseIndex(array,key).toString());
    }

    //创建稠密索引表
    public static Student denseIndex(Student[] array, int key) {
        if (array != null && array.length > 0) {
            //排序 对于稠密索引这个索引表来说,索引项一定是按照关键码有序的排列
            Arrays.sort(array);
            Index[] list = new Index[array.length];
            //建立索引
            for (int i = 0; i < array.length; i++) {
                Index index = new Index();
                index.key = array[i].no;
                index.value = array[i];
                list[i] = index;
            }

            //根据索引关键码搜索
            int code = binarySearch(list, key);
            if (code != -1) {
                return (Student) list[code].value;
            }
        }
        return null;
    }

    public static int binarySearch(Index[] array, int key) {
        if (array.length > 0) {
            int low, high, mid;
            low = 0;
            high = array.length - 1;
            while (low <= high) {
                mid = (low + high) / 2;//折半
                if (key < array[mid].key)
                    high = mid - 1;
                else if (key > array[mid].key)
                    low = mid + 1;
                else
                    return mid;
            }
        }

        return -1;
    }
    

   
}
