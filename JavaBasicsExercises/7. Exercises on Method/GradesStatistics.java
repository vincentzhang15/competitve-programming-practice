import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

/**
* A program that outputs grades statistics.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-08-05
*
*/

public class GradesStatistics
{
	public static int [] grades;  // Declare an int[], to be allocated later.
								  // This array is accessible by all the methods.

	// Prompt user for the number of students and allocate the global "grades" array.
	// Then, prompt user for grade, check for valid grade, and store in "grades".
	public static void readGrades()
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int students = s.nextInt();
		grades = new int [students];
		
		for(int i = 0; i < students; i++)
		{
			System.out.print("Enter the grade for student " + (i + 1) + ": ");
			grades [i] = s.nextInt();
		}
	}

	// Print the given int array in the form of {x1, x2, x3,..., xn}.
	public static void printArray(int[] array)
	{
		System.out.print("{");
		for(int i = 0; i < grades.length; i++)
		{
			System.out.print(grades[i]);
			if(i != grades.length - 1)
				System.out.print(", ");
		}
		System.out.println("}");
	}

	// Return the average value of the given int[]
	public static double average(int[] array)
	{
		double sum = 0;
		for(int i = 0; i < grades.length; i++)
			sum += grades[i];
		return sum / grades.length;
	}

	// Return the median value of the given int[]
	// Median is the center element for odd-number array, 
	// or average of the two center elements for even-number array.
	// Use Arrays.sort(anArray) to sort anArray in place.
	public static double median(int[] array)
	{
		double mid;
		Arrays.sort(array);
		if(array.length % 2 == 0)
			mid = (array[array.length / 2] + array[(array.length / 2) - 1]) / 2;
		else
			mid = array[(array.length / 2) - 1];
		return mid;
	}

	// Return the minimum value of the given int[]
	public static int min(int[] array)
	{
		Arrays.sort(array);
		return array[0];
	}

	// Return the maximum value of the given int[]
	public static int max(int[] array)
	{
		int max = array[0];   // Assume that max is the first element
		// From second element, if the element is more than max, set the max to this element.
		for(int i = 0; i < array.length; i++)
			if(array[i] > max)
				max = array[i];
		return max;
	}

	// Return the standard deviation of the given int[]
	public static double stdDev(int[] array)
	{
		double value = 0;
		for(int i = 0; i < array.length; i++)
			value += Math.pow(array[i], 2) - Math.pow(average(array), 2);
		return Math.sqrt(value / array.length);
	}
	
	public static void main(String[] args)
	{
		readGrades();  // Read and save the inputs in int[] grades
		printArray(grades);
		System.out.println("The average is " + new DecimalFormat("##.00").format(average(grades)));
		System.out.println("The median is " + new DecimalFormat("##.00").format(median(grades)));
		System.out.println("The minimum is " + min(grades));
		System.out.println("The maximum is " + max(grades));
		System.out.println("The standard deviation is " + new DecimalFormat("##.00").format(stdDev(grades)));
	}
}