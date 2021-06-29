import java.util.Scanner;

/**
* A program that converts multiples of numbers into words.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 4 minutes
*/

public class CozaLozaWoza
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a lowerbound: ");
		int lower = scanner.nextInt();
		System.out.print("Enter a upperbound: ");
		int upper = scanner.nextInt();

		for(int i = lower; i <= upper; i++)
		{
			if(i % 3 == 0)
				System.out.print("Coza");
			if(i % 5 == 0)
				System.out.print("Loza");
			if(i % 7 == 0)
				System.out.print("Woza");

			if(i % 3 != 0 && i % 5 != 0 && i % 7 != 0)
				System.out.print(i);

			if(i % 11 == 0)
				System.out.println();
			else
				System.out.print(" ");
		}
	}
}