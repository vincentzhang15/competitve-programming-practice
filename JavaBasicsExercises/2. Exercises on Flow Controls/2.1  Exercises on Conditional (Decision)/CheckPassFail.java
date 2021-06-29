import java.util.Scanner;

/**
* A program that checks passing or failing.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 3 minutes
*/

public class CheckPassFail
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("What is the mark?: ");
		// print prints on one line; println prints extra new line after current line
		int mark = scanner.nextInt();

		// conditional statments without curly brackets only takes one line directly below
		if(mark >= 50)
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		System.out.println("DONE");
	}
}