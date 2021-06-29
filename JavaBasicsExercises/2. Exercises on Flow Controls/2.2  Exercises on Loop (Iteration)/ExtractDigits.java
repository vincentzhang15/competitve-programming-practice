import java.util.Scanner;

/**
* A program that reverse the digits of a number.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 4 minutes
*/

public class ExtractDigits
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();
		
		while(number > 0)
		{
			System.out.print(number % 10 + " ");
			number /= 10;
		}
	}
}