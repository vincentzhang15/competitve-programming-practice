import java.util.Scanner;

/**
* A program that converts octal to decimal.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-28
*
*/

public class Oct2Dec
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a Octal string: ");
		String string = s.nextLine();
		int decDigit = 0;
		int digit;
		
		for(int i = 0; i < string.length(); i++)
		{
			digit = string.charAt(i);
			if(digit >= '0' && digit <= '7')
				decDigit += (digit - '0') * Math.pow(8, string.length() - 1 - i);
			else
			{
				System.out.println("error: invalid octal string \"" + string + "\"");
				System.exit(1);
			}
		}
		System.out.println("The equivalent decimal number for octal \"" + string + "\" is: " + decDigit);
	}
}