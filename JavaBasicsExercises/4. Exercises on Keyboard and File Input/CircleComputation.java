import java.util.Scanner;
import java.text.DecimalFormat;

/**
* A program that processes keyboard input to compute area and circumference.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class CircleComputation
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the radius: ");
		double radius = s.nextDouble();

		while(radius != -1)
		{
			System.out.println("The area is: " + new DecimalFormat("##.##").format(Math.PI * Math.pow(radius, 2)));
			System.out.println("The circumference is: " + new DecimalFormat("##.##").format(2 * Math.PI * radius));
			
			System.out.print("\nEnter a positive integer or -1 to exit: ");
			radius = s.nextDouble();
		}
	}
}