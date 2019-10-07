package Assignment2;

import java.util.HashSet;

//Question: 10
/*
 * Check if there are duplicates in k distance
 * 
 * There is a string and we have to figure out if there are duplicates in K
 * distance. Input: string: "ABCADEB", K = 3 Output : false
 * 
 * Input: string: "ABACDEB", K = 3 Output : true  
 * 
 */

public class DuplicatesInKthDis {

	public static void main(String[] args) {
		String s = "ABCADEB";
		Integer n = 3;
		boolean output = duplicatesInKDistance(s, n);
		System.out.println(output);
	}

	public static boolean duplicatesInKDistance(String s, Integer k) {
		
		//Checking error case
		if(s.length() == 0 || s.length() == 1 || k <= 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		boolean out = false;
		HashSet<Character> set = new HashSet<Character>();
		
		//Hashset add method return value to determine duplicate
		//If k is greater than string length, check until string length
		for(int i = 0; (i < k && i < s.length()); i++) {
			if(!set.add(s.charAt(i))) {
				out = true;
				break;
			}
		}
		return out;
	}
}
