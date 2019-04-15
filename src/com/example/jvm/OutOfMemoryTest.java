package com.example.jvm;
import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出演示
 * @author qinxuewu
 * @version 1.00
 * @time  12/4/2019 上午 9:53
 * @email 870439570@qq.com
 */
public class OutOfMemoryTest {
    /**
     * 定义一个静态内部类
     */
    static  class Test{ }

    /**
     * 无限创建对象 模拟内存溢出
     *
     * 启动参数设置： 限制最大可用内存，并生成内存溢出快照
     * -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=F:\MemoryAnalyze\dump -Xms5m -Xmx5m
     *
     * @param args
     */
    public static void main(String[] args) {
        List<Test> list=new ArrayList<>();
        while (true){
            list.add(new Test());
        }
    }
}
