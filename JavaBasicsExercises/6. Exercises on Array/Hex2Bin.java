import java.util.Scanner;

/**
* A program that converts hexadecimal to binary.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-28
*
*/

public class Hex2Bin
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a Hexadecimal string: ");
		String string = s.next();
		String hexString = string.toLowerCase();
		
		String[] hexBits = {"0000", "0001", "0010", "0011",
                    "0100", "0101", "0110", "0111",
                    "1000", "1001", "1010", "1011",
                    "1100", "1101", "1110", "1111"};

		System.out.print("The equivalent binary for hexadecimal \"" + string + "\" is: ");
		
		char c;
		for(int i = 0; i < string.length(); i++)
		{
			c = hexString.charAt(i);
			if(c >= '0' && c <= '9')
				System.out.print(hexBits[c - '0'] + " ");
			else if(c >= 'a' && c <= 'f')
				System.out.print(hexBits[(c - 'a') + 10] + " ");
		}
	}
}