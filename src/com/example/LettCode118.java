package com.example;


import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  21/3/2019 下午 5:37
 * @email 870439570@qq.com
 */
public class LettCode118 {


    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> list = new ArrayList();
        for(int a = 0; a < numRows; a++){
            List<Integer> list2 = new ArrayList();
                for(int b = 0; b <= a; b++){
                    if(b == 0 || b == a)
                        list2.add(1);
                    else
                        list2.add(list.get(a-1).get(b)+ list.get(a-1).get(b-1));
                }
            list.add(list2);
        }
        return list;
    }

    public static void main(String[] args) {

    }
}
