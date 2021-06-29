import java.util.Scanner;

public class j3
{
	public static void main (String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();

		String [][] grid = {{"*", "X", "*"},{" ", "X", "X"},{"*", " ", "*"}};

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				for(int a = 0; a < k; a++)
				{
					System.out.print(grid[i][j]);
				}
			}
			System.out.println();
			for(int c = 0; c < k - 1; c++)
			{
				for(int j = 0; j < 3; j++)
				{
					for(int a = 0; a < k; a++)
					{
						System.out.print(grid[i][j]);
					}
				}
			System.out.println();
			}
		}
	}
}