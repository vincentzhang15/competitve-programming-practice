import java.util.Scanner;

/**
* A program that prints a square board.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 1 minutes
*/

public class SquareBoard
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a board size: ");
		int size = scanner.nextInt();

		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
				System.out.print("# ");
			System.out.println();
		}
	}
}