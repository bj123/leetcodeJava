package com.example;

/**
 *
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 输入: "race a car"
 * 输出: false
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  4/4/2019 下午 1:14
 * @email 870439570@qq.com
 */
public class LettCode125 {

    public static void main(String[] args) {
        LettCode125 code=new LettCode125();
        System.out.println(code.isPalindrome("A man, a plan, a canal: Panama"));
    }


    /**
     * 回文，就是一个正读和反读都一样的字符串
     *
     *  解题思路： 通过双指针
     *      一开始先建立两个指针，left 和 right , 让它们分别从字符的开头和结尾处开始遍历整个字符串。
     *      如果遇到非字母数字的字符就跳过，继续往下找，直到找到下一个字母数字或者结束遍历，如果遇到大写字母，就将其转为小写。
     *
     *      当左右指针都找到字母数字时，可以进行比较的时候，比较这两个字符，如果相等，则两个指针向它们的前进方向挪动，
     *      然后继续比较下面两个分别找到的字母数字，若不相等，直接返回 false。
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if(s.length()==0){
            return  true;
        }
        int left=0,right=s.length()-1;

        //左指针小于右指针时 一直遍历
        while (left<right){

            //判断当前left指针指定的字符是否为字母或数字
            if(!Character.isLetterOrDigit(s.charAt(left))){
                left++; //不符合 ，跳过
            }else if(!Character.isLetterOrDigit(s.charAt(right))){
                //判断当前right指针指定的字符是否为字母或数字
                right--; //不符合 ，跳过
            }else{

                //都是字母数字的字符，可以进行比较的时候，比较这两个字符
                //大写都转换为小写 就行比较
                if(Character.toLowerCase(s.charAt(left))!= Character.toLowerCase(s.charAt(right))){
                    // 若不相等，直接返回 false。
                    return  false;
                }

                    //如果相等，则两个指针向它们的前进方向挪动，
                    left++;
                    right--;

            }
        }
        return  true;

    }

}
