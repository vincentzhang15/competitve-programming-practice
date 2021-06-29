import java.util.Scanner;
import java.text.DecimalFormat;

/**
* A program that counts vowels and digits.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class CheckVowelsDigits
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String string = s.next().toLowerCase();
		
		int vowels = 0;
		int digits = 0;
		
		for(int i = 0; i < string.length(); i++)
		{
			char c = string.charAt(i);
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
				vowels++;
			else if(c == '0' || c == '1' || c == '2' || c == '3' || c == '4'
			|| c == '5' || c == '6' || c == '7' || c == '8' || c == '9')
				digits++;
		}
		double vPercentage = (double) vowels / string.length() * 100;
		double dPercentage = (double) digits / string.length() * 100;
		
		System.out.println("Number of vowels: " + vowels + " (" + new DecimalFormat("##.##").format(vPercentage) + "%)");
		System.out.println("Number of digits: " + digits + " (" + new DecimalFormat("##.##").format(dPercentage) + "%)");
	}
}