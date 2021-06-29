import java.util.*;

public class j5
{
	int [][] board = new int [9][9];
	
	void knightMove (int x, int y, int steps)
	{
		if(x > 0 && x <= 8 && y > 0 && y <= 8 && steps < board[x][y])
		{
			System.out.println("BEGGGIIINNN");
			System.out.println("x: " + x + " y: " + y);
			board[x][y] = steps;
//			System.out.print("  :after step 1: " + board[x][y] + " |  ");
			knightMove (x - 1, y + 2, steps + 1);
//			System.out.print("  :after step 2: " + board[x][y] + " |  ");
			knightMove (x - 1, y - 2, steps + 1);
//			System.out.print("  :after step 3: " + board[x][y] + " |  ");
			knightMove (x + 1, y + 2, steps + 1);
//			System.out.print("  :after step 4: " + board[x][y] + " |  ");
			knightMove (x + 1, y - 2, steps + 1);
//			System.out.print("  :after step 5: " + board[x][y] + " |  ");
			knightMove (x - 2, y + 1, steps + 1);
//			System.out.print("  :after step 6: " + board[x][y] + " |  ");
			knightMove (x - 2, y - 1, steps + 1);
//			System.out.print("  :after step 7: " + board[x][y] + " |  ");
			knightMove (x + 2, y + 1, steps + 1);
//			System.out.print("  :after step 8: " + board[x][y] + " |  ");
			knightMove (x + 2, y - 1, steps + 1);
			System.out.println("===================");
		}
	}

	void run()
	{
		for(int i = 1; i <= 8; i++)
			for(int j = 1; j <= 8; j++)
				board[i][j] = 99999;

		Scanner scanner = new Scanner(System.in);
		int xStart = scanner.nextInt();
		int yStart = scanner.nextInt();
		int xEnd = scanner.nextInt();
		int yEnd = scanner.nextInt();

		knightMove (xStart, yStart, 0);

		System.out.println(board[xEnd][yEnd]);
	}
	public static void main (String [] args)
	{
		j5 obj = new j5();
		obj.run();
	}
}