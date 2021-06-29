import java.util.Scanner;

/**
* A program that outputs a chart.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-08-09
*
*/

public class PrintChart
{
	static int [] data;
	public static void readInput()
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter number of bars: ");
		int bars = s.nextInt();
		data = new int [bars];
		
		for(int i = 0; i < bars; i++)
		{
			System.out.print("Enter bar " + (i + 1) + " value: ");
			data [i] = s.nextInt();
		}
	}

	public static void printChart(int[] array)
	{
		System.out.println();
		for(int i = 0; i < data.length; i++)
		{
			for(int j = 0; j < data[i]; j++)
			{
				System.out.print("*");
			}
			System.out.println(" (" + data[i] + ")");
		}
	}

	public static void main(String[] args)
	{
		readInput();
		printChart(data);
	}
}