/**
* A program to be debugged.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class Factorial
{
	// Print factorial of n
	public static void main(String[] args)
	{
		// Set an initital breakpoint at this statement
		int n = 20;
		// changed int factorial to long factorial; see Java variable types.
		long factorial = 1;

		// n! = 1*2*3...*n
		for (int i = 1; i <= n; i++)
		{
			factorial = factorial * i;
		}
		System.out.println("The Factorial of " + n + " is " + factorial);
	}
}