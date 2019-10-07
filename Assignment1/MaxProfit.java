package Assignment1;

/* Q5
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * 
 * Example:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. Not 7-1 = 6, as selling price needs to be larger than buying price.
 */


public class MaxProfit {

	public static void main(String[] args) {
		int[] prices = { 7,1,5,3,6,4 };
		System.out.println(maxProfit(prices));
    }
	
    public static int maxProfit(int[] prices) {
    	
    	//checking error case
    	if(prices.length == 0) {
    		return 0;
    	}
    	int min = prices[0];
    	int profit = 0;
    	int maxProfit = 0;
    	if(prices.length<0) {
    		return -1;
    	}
    	for(int i = 0; i < prices.length; i++) {
    		
    		//calculating minimum price of the stock until ith day
    		if(prices[i] < min) {
    			min = prices[i];
    		}
    		
    		//profit by buying on min day and selling on ith day  
    		profit = prices[i]-min;
    		
    		//maximum profit until ith day
    		if(profit > maxProfit) {
    			maxProfit = profit;
    		}
    	}
		return maxProfit;
    	
    }
}
