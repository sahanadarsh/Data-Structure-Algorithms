package Assignment1;

/* Q4
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * s = "leetcode" return 0. 
 * s = "loveleetcode" return 2.
 */

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingCharacterIndex {

	public static void main(String[] args) {
		String s = "aabbbcceddjhjhef";
		System.out.println(firstUniqChar(s));
	}


	public static int firstUniqChar(String s) {
		Map<Character,Integer> count = new HashMap<>();
		int l = s.length();

		//Initialize the value of each key in the hashmap to 0
		for(int i=0; i < l; i++) {
			char c = s.charAt(i);
			count.put(c,0);
		}

		//Update value to represent count of each character
		for(int i=0; i < l; i++) {
			char c = s.charAt(i);
			int value = count.get(c);
			value++;
			count.put(c,value);
		}

		//return first non repeating character index
		for(int i =0; i < l; i++) { 
			if(count.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;

	}
}
