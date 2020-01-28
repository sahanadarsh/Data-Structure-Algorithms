package Assignment4;

/* Q9
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be >= k.
The given num does not contain any leading zero.

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/

public class RemoveKDigits {
	
	public static String removeKdigits(String num, int k) {
	    char[] output = new char[num.length()];
	    if(num.isEmpty() || num.length() == k) {
	    	return "0";
	    }
	    if(k == 0) {
	    	return num;
	    }
	    if(k > num.length()) {
	    	throw new IllegalArgumentException("Invalid input");
	    }
	    int idx = 0;
	    int n = num.length() - k;
	    for(int i = 0; i < num.length(); i++) {
	    	while(idx > 0 && ((num.length() - i + idx) > n) && (output[idx - 1] > num.charAt(i))) {
	    		idx--;
	    		k--;
	    	}
	    	if(idx < n) {
	    		output[idx++] = num.charAt(i);
	    	}
	    }
	    int j = 0;
	    while(output[j] == '0' && j < idx) {
	    	j++;
	    }
	    
	    if(j == idx) {
	    	return "0";
	    }else {
	    	return new String(output,j,idx-j);
	    }
	    
	}
	
	//Another solution to remove K digits
	public static String KdigitsRemoval(String num, int k) {
		char[] c = num.toCharArray();
		StringBuilder out = new StringBuilder();
		boolean zeroFlag = true;
		
		int pivot = -1;
		int count = 0;
		int idx1 = num.length()-k;
		while (idx1 > 0) {
			int idx2 = k + count;
			int minIdx = idx2;
			while(idx2 > pivot+1) {
				if (c[idx2-1] <= c[minIdx]) {
					minIdx = idx2-1;		
				}
				idx2--;
			}
			pivot = minIdx;
			if (zeroFlag && c[pivot] == '0') {
			} else {
				zeroFlag = false;
				out.append(c[pivot]);				
			}
			idx1--;
			count++;
		}
		String op = out.toString();
		if (op.compareTo("")==0) {
			return "0";
		} else {
			return op;
		}
	}


	public static void main(String[] args) {
		String num = "5337";
		System.out.println(removeKdigits(num,2));
		//System.out.println(KdigitsRemoval(num,2));
	}
}
