import java.util.Scanner;

/**
* A program that checks if a phrase is a palindrome.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class TestPalindromicWord
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a phrase: ");
		String phrase = s.nextLine().toLowerCase();

		char forward;
		char backward;
		for(int i = 0; i < phrase.length(); i++)
		{
			forward = phrase.charAt(i);
			backward = phrase.charAt(phrase.length() -1 - i);
			if(Character.isLetter(forward) && Character.isLetter(backward))
			{
				if(forward != backward)
				{
					System.out.println("\"" + phrase + "\" is not a palindrome");
					return;
				}
			}
		}
		System.out.println("\"" + phrase + "\" is a palindrome");
	}
}