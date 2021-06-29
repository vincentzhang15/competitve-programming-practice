import java.util.Scanner;

/**
* A program that checks odd or even.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 2 minutes
*/

public class CheckOddEven
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		if(number % 2 == 0) // % sign finds remainder
			System.out.println("Even number");
		else
			System.out.println("Odd number");
		System.out.println("BYE!");
	}
}