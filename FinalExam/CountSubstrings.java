package FinalExam;

/*
Q14
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings
even they consist of same characters.

Examples:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */

public class CountSubstrings {

	public static int countSubstrings(String s) {
		if(s.length() == 0) {
			return 0;
		}else if(s.length() == 1) {
			return 1;
		}
		char[] c = s.toCharArray();
		int count = c.length;
		if(isPalindrome(s)) {
			count++;
		}
		for(int i = 2; i < s.length(); i++) {
			for(int j = 0; j <= s.length()- i; j++ ) {
				if(isPalindrome(s.substring(j, j+i))){
					count++;
				}
			}
		}
		return count;
	}

	private static boolean isPalindrome(String s) {
		String reverse = new StringBuffer(s).reverse().toString(); 
		if (s.equals(reverse)) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) {
		String s = "aaa";
		System.out.println(countSubstrings(s));
	}

}
