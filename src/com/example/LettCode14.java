package com.example;


/**
 * �����ǰ׺
 * 
 * ��дһ�������������ַ��������е������ǰ׺��

     ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
      
     ʾ�� 1:

	����: ["flower","flow","flight"]
	���: "fl"
	ʾ�� 2:
	
	����: ["dog","racecar","car"]
	���: ""
	����: ���벻���ڹ���ǰ׺��
 * @author qinxuewu
 * 2019��1��18������3:41:27
 *
 */
public class LettCode14 {
	public static void main(String[] args) {
//		String[] strs={"aca","cba"};
		String[] strs={"flower","flow","flight"};

		System.out.println(longestCommonPrefix(strs));
	}
	
	/**
	 * ����������ǰ׺�Ӵ�һ����ÿ���ַ�����ǰ׺�Ӵ���
	 * �������ѡ��һ���ַ�����Ϊ��׼��������ǰ׺���������������ַ��������жϣ�
	 * ���Ƿ������������˵�ǰ׺�Ӵ��������ʱ��������O(m*n*m)
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
		//���鳤��С��1 ���ؿ�
		if(strs.length==0){
			return "";
		}
		if(strs.length == 1){
			return strs[0];
		}
		//ѡ��һ���ַ�����Ϊ��׼
		String temStr=strs[0];
		StringBuilder str=new StringBuilder();
		boolean flag = false;
		for(int i = 0; i <strs[0].length(); i++){
				//������ǰ׺���������������ַ��������ж�
				char foo=temStr.charAt(i);
				for (int j = 1; j < strs.length; j++) {
					//�жϱ����±��Ƿ�Խ���   ǰ׺�Ƿ����
					if(i >=strs[j].length() || strs[j].charAt(i)!=foo){
						  flag =true;
		                  break;
					}
				}	
				if (flag){
		                break;
		            }else{
		            	str.append(foo);
		         }
		}
		return str.toString();
    }
}
