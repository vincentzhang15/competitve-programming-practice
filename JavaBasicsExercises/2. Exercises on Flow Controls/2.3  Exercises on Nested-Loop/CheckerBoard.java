import java.util.Scanner;

/**
* A program that prints a checker board.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 2 minutes
*/

public class CheckerBoard
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a board size: ");
		int size = scanner.nextInt();

		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				if(i % 2 == 0)
					System.out.print("# ");
				else
					System.out.print(" #");
			}
			System.out.println();
		}
	}
}