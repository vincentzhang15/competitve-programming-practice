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

public class Fibonacci
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();
		int f1 = 1;
		int f2 = 1;
		double sum = 0;
		
		System.out.println("The first " + number + " Fibonacci numbers are:");
		for(int i = 1; i < number; i++)
		{
			System.out.print(f2 + " ");
			sum += f2;
			f2 += f1;
			f1 = f2 - f1;
		}
		System.out.println("\nThe average is " + (double)(Math.round((sum / number) * 10)) / 10);
	}
}