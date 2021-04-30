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

		int [][][] miniGrids = new int [9][3][3];
		
		for (i=0; i<9; i++) {
			for (j=0; j<9; j++) {
				if (i<3 && j<3) {
					miniGrids [0][i][j] = grid[i][j];
				} else if (i<3 && j>=3 && j<6) {
					miniGrids [1][i][j-3] = grid[i][j];
				} else if (i<3 && j>=6) {
					miniGrids [2][i][j-6] = grid[i][j];
				} else if (i>=3 && i<6 && j<3) {
					miniGrids [3][i-3][j] = grid[i][j];
				} else if (i>=3 && i<6 && j>=3 && j<6) {
					miniGrids [4][i-3][j-3] = grid[i][j];
				} else if (i>= 3 && i<6 && j>=6 && j<9) {
					miniGrids [5][i-3][j-6] = grid[i][j];
				} else if (i>=6 && i<9 && j<3) {
					miniGrids [6][i-6][j] = grid[i][j];
				} else if (i>=6 && i<9 && j>=3 && j<6) {
					miniGrids [7][i-6][j-3] = grid[i][j];
				} else {
					miniGrids [8][i-6][j-6] = grid[i][j];
				}
			}
		} 
		boolean correct = false;
		while (correct == false) {

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
				incorrect += checkMiniGrid(miniGrids, r, c, number);
				
				if (incorrect >= 1) {
					System.out.println("Incorrect move. Try again!");
				} else {
					grid[r][c] = number;
				}
			} else {
				System.out.println("Can't change this number.");
			}
			correct = Arrays.equals(grid, answer);
			System.out.println(correct);
		}
		System.out.println("You win!!");
	}
	
	private static void printGrid (int [][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		System.out.println("   1. 2. 3. 4. 5. 6. 7. 8. 9.");
		for (int i = 0; i < rows; i++) {
			System.out.print(i+1 + ". ");
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 0) {
					System.out.print("#  ");
				} else {
					System.out.print(grid[i][j] + "  ");
				}
			}
			System.out.println(" ");
		}		
	}
	private static int checkMiniGrid(int [][][]miniGrid, int row, int col, int number) {
		int z = col/3 + 3*(row/3);
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (miniGrid[z][i][j] == number) {
					return 1;
				}
			}
		}
		return 0;
	}
}
