import java.util.Scanner;

/**
* A program that converts number to word.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 2 minutes
*/

public class PrintNumberInWordCase
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();

		switch(number)
		{
			case 1: System.out.println("ONE"); break;
			case 2: System.out.println("TWO"); break;
			case 3: System.out.println("THREE"); break;
			case 4: System.out.println("FOUR"); break;
			case 5: System.out.println("FIVE"); break;
			case 6: System.out.println("SIX"); break;
			case 7: System.out.println("SEVEN"); break;
			case 8: System.out.println("EIGHT"); break;
			case 9: System.out.println("NINE"); break;
			default: System.out.println("OTHER");
		}
	}
}