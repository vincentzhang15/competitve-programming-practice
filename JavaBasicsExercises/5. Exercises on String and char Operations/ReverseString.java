import java.util.Scanner;

/**
* A program that reverse a string.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class ReverseString
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a String: ");
		String word = s.next();
		
		System.out.print("The reverse of the String \"" + word + "\" is \"");
		for(int i = word.length() - 1; i >= 0; i--)
			System.out.print(word.charAt(i));
		System.out.println("\".");
	}
}