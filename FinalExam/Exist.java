package FinalExam;

/*
Q5
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
 */

public class Exist {

	public static boolean exist(char[][] board, String word) {
		if(board.length == 0 || board[0].length == 0 || board == null) {
			return false;
		}
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if(exist(board, word, x, y, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean exist(char[][] board, String word,int x, int y, int index) {

		if (x >= board.length || x < 0) {
			return false;
		}
		if (y >= board[0].length || y < 0) {
			return false;
		}
		if (board[x][y] == '@') {
			return false;
		}

		char val = board[x][y];
		board[x][y] = '@'; 

		if (val != word.charAt(index)) {
			board[x][y] = val;
			return false;
		}   
		if (index == word.length() - 1) {
			return true;
		}
		if (exist(board, word, x, y - 1, index + 1)) {
			return true;
		}
		if (exist(board, word, x, y + 1, index + 1)) {
			return true;    
		}
		if (exist(board, word, x + 1, y, index + 1)) {
			return true;
		}
		if (exist(board, word, x - 1, y, index + 1)) {
			return true;
		}		
		board[x][y] = val;
		return false; 
	}

	public static void main(String[] args) {
		String s = "ABCCED";
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'} };
		System.out.println(exist(board, s));
	}

}


