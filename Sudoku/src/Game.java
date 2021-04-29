import java.util.Arrays;
import java.util.Scanner; //Import the Scanner class

public class Game {
	
	/**
	 * The main method.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int rows = 9;
		int cols = 9;
		int i,j;
		int incorrect = 0;
		
		int [] [] grid = { 
				{6, 0, 0, 8, 0, 0, 3, 0, 0},
				{5, 0, 0, 0, 2, 0, 0, 0, 0},
				{1, 0, 0, 4, 0, 3, 0, 5, 6},
				{0, 6, 1, 0, 0, 0, 5, 9, 8},
				{9, 0, 4, 6, 0, 5, 0, 0, 2},
				{8, 3, 5, 0, 0, 9, 7, 0, 0},
				{3, 0, 9, 5, 0, 8, 4, 0, 0},
				{7, 8, 0, 0, 4, 2, 9, 1, 0},
				{0, 0, 2, 0, 0, 0, 0, 8, 0} };
		int [] [] grid2 = new int [9][9];
		
		for (i = 0; i < rows; i++) {
			grid2[i] = Arrays.copyOf(grid[i], 9);
		}
		
		int [] [] answer = { 
				{6, 2, 7, 8, 5, 1, 3, 4, 9},
				{5, 4, 3, 9, 2, 6, 8, 7, 1},
				{1, 9, 8, 4, 7, 3, 2, 5, 6},
				{2, 6, 1, 7, 3, 4, 5, 9, 8},
				{9, 7, 4, 6, 8, 5, 1, 3, 2},
				{8, 3, 5, 2, 1, 9, 7, 6, 4},
				{3, 1, 9, 5, 6, 8, 4, 2, 7},
				{7, 8, 6, 3, 4, 2, 9, 1, 5},
				{4, 5, 2, 1, 9, 7, 6, 8, 3} };
		int [][] miniGrid0 = new int [3][3];
		int [][] miniGrid1 = new int [3][3];
		int [][] miniGrid2 = new int [3][3];
		int [][] miniGrid3 = new int [3][3];
		int [][] miniGrid4 = new int [3][3];
		int [][] miniGrid5 = new int [3][3];
		int [][] miniGrid6 = new int [3][3];
		int [][] miniGrid7 = new int [3][3];
		int [][] miniGrid8 = new int [3][3];
		
		
		for (i=0; i<9; i++) {
			for (j=0; j<9; j++) {
				if (i<3 && j<3) {
					miniGrid0 [i][j] = grid[i][j];
				} else if (i<3 && j>=3 && j<6) {
					miniGrid1 [i][j-3] = grid[i][j];
				} else if (i<3 && j>=6) {
					miniGrid2 [i][j-6] = grid[i][j];
				} else if (i>=3 && i<6 && j<3) {
					miniGrid3 [i-3][j] = grid[i][j];
				} else if (i>=3 && i<6 && j>=3 && j<6) {
					miniGrid4 [i-3][j-3] = grid[i][j];
				} else if (i>= 3 && i<6 && j>=6 && j<9) {
					miniGrid5 [i-3][j-6] = grid[i][j];
				} else if (i>=6 && i<9 && j<3) {
					miniGrid6 [i-6][j] = grid[i][j];
				} else if (i>=6 && i<9 && j>=3 && j<6) {
					miniGrid7 [i-6][j-3] = grid[i][j];
				} else {
					miniGrid8 [i-6][j-6] = grid[i][j];
				}
			}
		}
		
		while (grid != answer) {

			printGrid(grid);
			incorrect = 0;
			System.out.println("Where do you want to enter number? Row:");
			int r = input.nextInt();
			r = r-1;
			System.out.println("Cols:");
			int c = input.nextInt();
			c = c-1;
			if (grid2 [r][c] == 0) {
				System.out.println("What do you want to change it to?:");
				int number = input.nextInt();
				for (j=0; j<cols; j++) {
					if (grid2[r][j] == number) {
						incorrect = 1;
						break;
					}
				}
				for (i=0; i<rows; i++) {
					if (grid2[i][c] == number) {
						incorrect = 1;
						break;
					}
				}
				int Index = c/3 + 3*(r/3);
				for (i=0; i<3; i++) {
					for (j=0; j<3; j++) {
						
					}
				}
//				if (r<3 && r>=0 && c<3 && c>=0) {
//					for (i=0; i<3; i++) {
//						for (j=0; j<3; j++) {
//							if (miniGrid1[i][j] == number) {
//								incorrect = 1;
//							}
//						}
//					}
//				} else if (r<3 && r>=0 && c<6 && c>=3) {
//					for (i=0; i<3; i++) {
//						for (j=3; j<6; j++) {
//							if (miniGrid2[i][j] == number) {
//								incorrect = 1;
//							}
//						}
//					}
//				}else if (r<3 && r>=0 && c<9 && c>=6) {
//					for (i=0; i<3; i++) {
//						for (j=6; j<9; j++) {
//							if (miniGrid3[i][j] == number) {
//								incorrect = 1;
//							}
//						}
//					}
//				}else if (r<6 && r>=3 && c<3 && c>=0) {
//					for (i=3; i<6; i++) {
//						for (j=0; j<3; j++) {
//							if (miniGrid4[i][j] == number) {
//								incorrect = 1;
//							}
//						}
//					}
//				} else if (r<6 && r>=3 && c<6 && c>=3) {
//					for (i=3; i<6; i++) {
//						for (j=3; j<6; j++) {
//							if (miniGrid5[i][j] == number) {
//								incorrect = 1;
//							}
//						}
//					}
//				}else if (r<6 && r>=3 && c<9 && c>=6) {
//					for (i=3; i<6; i++) {
//						for (j=6; j<9; j++) {
//							if (miniGrid6[i][j] == number) {
//								incorrect = 1;
//							}
//						}
//					}
//				} else if (r<9 && r>=6 && c<3 && c>=0) {
//					for (i=6; i<9; i++) {
//						for (j=0; j<3; j++) {
//							if (miniGrid7[i][j] == number) {
//								incorrect = 1;
//							}
//						}
//					}
//				} else if (r<9 && r>=6 && c<3 && c>=0) {
//					for (i=6; i<9; i++) {
//						for (j=3; j<6; j++) {
//							if (miniGrid8[i][j] == number) {
//								incorrect = 1;
//							}
//						}
//					}
//				} else if (r<9 && r>=6 && c<3 && c>=0) {
//					for (i=6; i<9; i++) {
//						for (j=6; j<9; j++) {
//							if (miniGrid9[i][j] == number) {
//								incorrect = 1;
//							}
//						}
//					}
//				}
				
				if (incorrect == 1) {
					System.out.println("Incorrect move. Try again!");
				} else {
					grid[r][c] = number;
				}
			} else {
				System.out.println("Can't change this number.");
			}
			
		}
		System.out.println("You win!!");
	}
	
	private static void printGrid (int [][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 0) {
					System.out.print("# ");
				} else {
					System.out.print(grid[i][j] + " ");
				}
			}
			System.out.println(" ");
		}		
	}
}

