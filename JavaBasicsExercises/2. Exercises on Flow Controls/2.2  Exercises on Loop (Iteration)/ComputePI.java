import java.util.Scanner;

/**
* A program that computes the digits of PI.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-25
*
* Time Spent: 17 minutes
*/

public class ComputePI
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number of loops: ");
		int number = scanner.nextInt();
		double sum = 0;
		// start with for so we can multiply directly after

		int oddCount = 1;
		for(int i = 0; i <= number; i++)
		{
			sum += Math.pow(oddCount, -1) - Math.pow(oddCount + 2, -1);
			oddCount += 4;
		}
		double PI = (sum * 4);
		System.out.println("Math.PI: " + Math.PI);
		System.out.println("Calculated PI: " + PI);
	}
}