import java.util.Scanner;

/**
* A program that find the sum and average.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 6 minutes
*/

public class SumAndAverageFor
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a lowerbound: ");
		int lower = scanner.nextInt();
		System.out.print("Enter a upperbound: ");
		int upper = scanner.nextInt();
		double sum = 0; // use type double so average is in decimals

		for(int i = lower; i <= upper; i++)
			sum += i;
		
		System.out.println("The sum is " + sum + "\nThe average is " + sum / (upper - lower + 1));
	}
}