import java.util.Scanner;

/**
* A program that adds digits of a number by command-line arguments.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-08-10
*
*/

public class SumDigits
{
	public static void main (String[] args)
	{
		String number = args[0];
		int sum = 0;
		
		if (args.length != 1)
		{
			System.err.println("Invalid input.");
			return;
		}

		for(int i = 0; i < number.length(); i++)
			sum += Character.getNumericValue(number.charAt(i));
		
		System.out.print("The sum of digits = ");
		for(int i = 0; i < number.length(); i++)
		{
			System.out.print(number.charAt(i));
			if(i == number.length() - 1)
				System.out.print(" = ");
			else
				System.out.print(" + ");
		}
		System.out.println(sum);
	}
}