import java.util.Scanner;

/**
* A program that prints a time table.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 6 minutes
*/

public class TimeTable
{
	public static void main(String[] args)
	{
		System.out.println();
			
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a board size: ");
		int size = scanner.nextInt();

		System.out.print(" * |");
		for(int i = 1; i <= size; i++)
			System.out.printf("%4d", i);
		System.out.println();

		for(int i = 0; i <= size; i++)
			System.out.print("----");
		System.out.println();
		
		for(int i = 1; i <= size; i++)
		{
			System.out.print(" " + i + " |");
			for(int j = 1; j <= size; j++)
			{
				System.out.printf("%4d", i * j);
			}
			System.out.println();
		}
	}
}