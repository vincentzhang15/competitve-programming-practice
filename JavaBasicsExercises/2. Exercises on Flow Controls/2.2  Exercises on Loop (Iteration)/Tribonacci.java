import java.util.Scanner;

/**
* A program that find the fibonacci sequence.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-24
*
* Time Spent: 12 minutes
*/

public class Tribonacci
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();
		int f1 = 1;
		int f2 = 1;
		int f3 = 1;
		int f4 = 3;
		
		System.out.println("The first " + number + " Tibonacci numbers are:");
		System.out.print(f1 + " " + f2 + " ");
		for(int i = 1; i < number - 1; i++)
		{
			System.out.print(f3 + " ");
			f1 = f2;
			f2 = f3;
			f3 = f4;
			f4 = f1 + f2 + f3;
		}
	}
}