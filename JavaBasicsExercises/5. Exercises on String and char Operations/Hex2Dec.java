import java.util.Scanner;

/**
* A program that converts hexadecimal to decimal.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-27
*
*/

public class Hex2Dec
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a Hexadecimal string: ");
		String string = s.nextLine();
		String hexString = string.toLowerCase();
		
		int decDigit = 0;
		char digit;
		
		for(int i = 0; i < hexString.length(); i++)
		{
			digit = hexString.charAt(i);
			if(digit >= '0' && digit <= '9')
				decDigit += (digit - '0') * Math.pow(16, hexString.length() - 1 - i);
			else if(digit >= 'a' && digit <= 'f')
				decDigit += (digit - 'a' + 10) * Math.pow(16, hexString.length() - 1 - i);
			else
			{
				System.out.println("error: invalid binary hexadecimal \"" + string + "\"");
				System.exit(1);
			}
		}
		System.out.println("The equivalent decimal number for hexadecimal \"" + string + "\" is: " + decDigit);
	}
}