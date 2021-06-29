import java.util.Scanner;

/**
* A program that checks if a number is odd.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-29
*
*/

public class OddTest
{
	public static boolean isOdd(int number)
	{
		if(number % 2 != 0)
			return true;
		return false;
	}
	
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = s.nextInt();

		if(isOdd(number))
			System.out.println("ODD");
		else
			System.out.println("EVEN");
	}
}