package FinalExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
Q11
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,k.
For example, there won't be input like 3a or 2[4].

Example:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

public class DecodeString {

	public static String decodeString(String s){
		char[] arr = s.toCharArray();
		Stack<String> st = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			String str = String.valueOf(arr[i]);
			if(!str.equals("]")) {
				if(Character.isDigit(Integer.valueOf(arr[i]))){
					StringBuilder sb = new StringBuilder();
					while(Character.isDigit(Integer.valueOf(arr[i])))	{
						sb.append(arr[i]);
						i++;
						if(i >= arr.length) {
							break;
						}
					}
					i = i-1;
					str = sb.toString();
				}
				st.push(str);
			}else {
				ArrayList<String> list = new ArrayList<>();
				while(!st.peek().equals("[")) {
					list.add(st.pop());
				}
				Collections.reverse(list);
				String strng = "";
				for(int j = 0; j < list.size(); j++) {
					strng = strng + list.get(j);
				}
				st.pop();
				int n = Integer.valueOf(st.pop());
				StringBuilder sb = new StringBuilder();
				while(n > 0) {
					sb.append(strng);
					n--;
				}
				st.push(sb.toString());
			}
		}
		StringBuilder strb = new StringBuilder();
		for(int i = 0; i < st.size(); i++) {
			strb.append(st.get(i));
		}	
		return strb.toString();
	}

	public static void main(String[] args) {
		String s = "3[a]2[bc]";
		System.out.println(decodeString(s));
	}
}

