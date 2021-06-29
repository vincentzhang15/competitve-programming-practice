import java.util.Scanner;

/**
* A program that converts number to day.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 2 minutes
*/

public class PrintDayInWordIf
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		if(number == 0)
			System.out.println("Sunday");
		else if(number == 1)
			System.out.println("Monday");
		else if(number == 2)
			System.out.println("Tuesday");
		else if(number == 3)
			System.out.println("Wednesday");
		else if(number == 4)
			System.out.println("Thursday");
		else if(number == 5)
			System.out.println("Friday");
		else if(number == 6)
			System.out.println("Saturday");
		else
			System.out.println("Not a valid day");
	}
}