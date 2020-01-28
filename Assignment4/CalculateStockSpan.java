package Assignment4;

import java.util.Arrays;
import java.util.Stack;

public class CalculateStockSpan {
	
	
	 public static int[] calculateSpan(int price[]) {
		 
		 int n = price.length;
		 int[] S = new int[n];
	        // Create a stack and push index of first element 
	        // to it 
	        Stack<Integer> stack = new Stack<>(); 
	        stack.push(0); 
	  
	        // Span value of first element is always 1 
	        S[0] = 1; 
	  
	        // Calculate span values for rest of the elements 
	        for (int i = 1; i < n; i++) { 
	  
	            // Pop elements from stack while stack is not 
	            // empty and top of stack is smaller than 
	            // price[i] 
	        	 while(stack.size() > 0 && price[stack.peek()] <= price[i]){
	                    stack.pop();
	                }
	                if(stack.size() == 0){
	                    //everythign before this was smaller
	                    S[i] = i + 1;

	                }
	                else{
	                    S[i] =  i - stack.peek();
	                }
	                stack.push(i);
	        } 
	        return S;
	    } 

	public static void main(String[] args) {
		int[] price = {100, 80, 60, 70, 60, 75, 85};
		int[] out = calculateSpan(price);
		System.out.println(Arrays.toString(out));

	}

}
