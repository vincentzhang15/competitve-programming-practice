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

public class PrintDayInWordCase
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		switch(number)
		{
			case 0: System.out.println("Sunday"); break;
			case 1: System.out.println("Monday"); break;
			case 2: System.out.println("Tuesday"); break;
			case 3: System.out.println("Wednesday"); break;
			case 4: System.out.println("Thursday"); break;
			case 5: System.out.println("Friday"); break;
			case 6: System.out.println("Saturday"); break;
			default: System.out.println("Not a valid day");
		}
	}
}