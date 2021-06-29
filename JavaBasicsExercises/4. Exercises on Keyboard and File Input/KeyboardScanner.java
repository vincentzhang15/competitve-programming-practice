import java.util.Scanner;

/**
* A program that processes keyboard input.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class KeyboardScanner
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int num = s.nextInt();
		System.out.print("Enter a floating point number: ");
		double realNumber = s.nextDouble();
		System.out.print("Enter your name: ");
		String name = s.next();
		
		System.out.println("Hi! " + name + ", the sum of " + num + " and " + realNumber + " is " + (num + realNumber));
		s.close();
	}
}