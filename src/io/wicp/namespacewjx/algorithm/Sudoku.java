package io.wicp.namespacewjx.algorithm;

public class Sudoku {
	private char[][] board;
	private boolean[][] hangshu;
	private boolean[][] lieshu;
	private boolean[][] gongshu;

	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		char[][] board = new char[9][9];
		String boardstring = "..9748...7.........2.1.9.....7...24..64.1.59..98...3.....8.3.2.........6...2759..";
		int index = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = boardstring.charAt(index);
				index++;
			}
		}
		s.solveSudoku(board);
	}

	public void init() {
		hangshu = new boolean[9][9];
		lieshu = new boolean[9][9];
		gongshu = new boolean[9][9];
	}

	public void solveSudoku(char[][] board) {
		this.board = board;
		init();
		calshu();
		solvehang(0, 1);
	}
	
	public boolean solvehang(int hang, int num) {
		if (hang == 9)
			return true;
		
		while (num < 10 && hangshu[hang][num - 1])
			num++;
		
		if (num == 10)
			return solvehang(hang + 1, 1);
		
		for (int lie = 0; lie < 9; lie++) {
			if (board[hang][lie] == '.' && canplace(hang, lie, num)) {
				place(hang, lie, num);
				
//				System.out.println("第" + hang + "行第"+ lie + "列，放了" + keneng[numindex]);
//				display();
				
				if (solvehang(hang, num))
					return true;
				
//				System.out.println("删除第" + hang + "行第" + lie + "的" + board[hang][lie]);
				
				delete(hang, lie);
			}
		}
		return false;
	}

	public void calshu() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					int n = char2int(board[i][j]);
					hangshu[i][n - 1] = true;
					lieshu[j][n - 1] = true;
					gongshu[gongindex(i, j)][n - 1] = true;
				}
			}
		}
	}

	public int gongindex(int hang, int lie) {
		return (hang / 3) * 3 + lie / 3;
	}

	public int char2int(char c) {
		return c - '0';
	}

	public void place(int hang, int lie, int num) {
		char c = (char) ('0' + num);
		board[hang][lie] = c;
		hangshu[hang][num - 1] = true;
		lieshu[lie][num - 1] = true;
		gongshu[gongindex(hang, lie)][num - 1] = true;
	}

	public void delete(int hang, int lie) {
		int num = char2int(board[hang][lie]);
		board[hang][lie] = '.';
		hangshu[hang][num - 1] = false;
		lieshu[lie][num - 1] = false;
		gongshu[gongindex(hang, lie)][num - 1] = false;
	}

	public boolean canplace(int hang, int lie, int num) {
		return (!hangshu[hang][num - 1]) && (!lieshu[lie][num - 1]) && (!gongshu[gongindex(hang, lie)][num - 1]);
	}
	
	public void display(){
		for (int i = 0; i < 9; i++){
			System.out.println(board[i]);
		}
	}
	
	
}
