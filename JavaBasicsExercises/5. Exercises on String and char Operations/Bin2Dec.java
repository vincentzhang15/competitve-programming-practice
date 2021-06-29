import java.util.Scanner;

/**
* A program that converts binary to decimal.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class Bin2Dec
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a Binary string: ");
		String string = s.nextLine();
		int decDigit = 0;
		int digit;
		
		for(int i = 0; i < string.length(); i++)
		{
			digit = Character.getNumericValue(string.charAt(i));
			if(digit == 1)
				decDigit += Math.pow(2, string.length() - 1 - i);
			else if(digit != 0)
			{
				System.out.println("error: invalid binary string \"" + string + "\"");
				System.exit(1);
			}
		}
		System.out.println("The equivalent decimal number for binary \"" + string + "\" is: " + decDigit);
	}
}