import java.util.Scanner;

/**
* A program that converts radix to decimal.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-28
*
*/

public class Radix2Dec
{
	public static void main (String [] args)
	{
		// This problem can be with methods which will be covered in section 7.
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the radix: ");
		int radix = s.nextInt();
		System.out.print("Enter the string: ");
		String string = s.next();
		String hexString = string.toLowerCase();
		
		int decDigit = 0;
		int digit;

		switch(radix)
		{
			case 2:
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
				break;
			case 8:
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
				break;
			case 16:
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
				break;
			default:
				System.out.println("Input must be BIN, OCT, or HEX.");
				System.exit(0);
		}
		System.out.println("The equivalent decimal number \"" + string + "\" is: " + decDigit);			
	}
}