import java.util.Scanner;

/**
* A program that find the harmonic sum from 1 to 1 / n.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-06-25
*
* Time Spent: 9 minutes
*/

public class HarmonicSum
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int number = scanner.nextInt();
		
		double L2R = 0.0;
		double R2L = 0.0;

		// it is always 1 over n so no ^ -1 is 1 / n
		for(int i = 1; i <= number; i++)
			L2R += Math.pow(i, -1);
		// Math.pow(base, exponent)
		
		// right to left is reverse loop
		for(int i = number; i >= 1; i--)
			R2L += Math.pow(i, -1);

		System.out.println("Left to right is " + L2R);
		System.out.println("Rght to left is " + R2L);
		System.out.println("The difference is " + Math.abs(L2R - R2L));
		// Math.abs is the absolute value of the difference
	}
}