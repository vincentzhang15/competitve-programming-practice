import java.util.Scanner;

/**
* A program that find the product from 1 to n.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-25
*
* Time Spent: 3 minutes
*/

public class Product1ToN
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a lowerbound: ");
		int lower = scanner.nextInt();
		System.out.print("Enter a upperbound: ");
		int upper = scanner.nextInt();
		long product = 1; // not 0 because multiply by 0 is 0

		for(int i = lower; i <= upper; i++)
			product *= i;
		
		System.out.println("The product is " + product);
	}
}