package MidTerm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/* Q1 Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping. */

public class MergeOverlappingIntervals {

	public static int[][] merge(int[][] intervals) {

		if(intervals.length <= 1) {
			return intervals;
		}
		//sort
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});

		Stack<int[]> stack = new Stack<>();

		stack.push(intervals[0]);

		for(int i = 0 ; i < intervals.length ; i ++){
			int[] top = stack.peek();

			if(top[1] < intervals[i][0]){
				stack.push(intervals[i]);
			}
			else if(top[1] > intervals[i][1]){
				continue;

			}
			else if(top[1] >= intervals[i][0]){
				stack.pop();
				stack.push(new int[]{top[0], intervals[i][1]});
			}
		}
		int[][] output = new int[stack.size()][2];
		for(int j = 0; j < stack.size(); j++){
			int[] test = stack.get(j);
			output[j] = test;
		}
		return output;
	}

	public static void main(String[] args) {
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] out = merge(intervals);
		for(int i = 0; i < out.length; i++) {
			System.out.print("[" + out[i][0] + "," + out[i][1] + "] ");
		}
	}
}
