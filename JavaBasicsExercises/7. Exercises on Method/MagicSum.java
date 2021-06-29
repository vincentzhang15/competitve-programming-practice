import java.util.Scanner;

/**
* A program that computes the "magic sum."
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-29
*
*/

public class MagicSum
{
	public static boolean hasEight(int number)
	{
		char c;
		for(int i = 0; i < String.valueOf(number).length(); i++)
		{
			c = String.valueOf(number).charAt(i);
			if(c == '8')
				return true;
		}
		return false;
	}
	
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a positive integer or -1 to exit: ");
		int number = s.nextInt();
		int sum = 0;

		while(number != -1)
		{
			System.out.print("Enter a positive integer or -1 to exit: ");
			number = s.nextInt();
			if(hasEight(number))
				sum += number;
		}
		System.out.println("The magic sum is: " + sum);
	}
}