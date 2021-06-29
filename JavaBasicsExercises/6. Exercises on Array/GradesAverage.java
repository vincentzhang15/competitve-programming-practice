import java.util.Scanner;
import java.text.DecimalFormat;

/**
* A program that finds the average grade of students using an array.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-28
*
*/

public class GradesAverage
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int numStudents = s.nextInt();
		int [] grades = new int [numStudents];
		
		int sum = 0;
		int grade;
		for(int i = 1; i <= numStudents; i++)
		{
			System.out.print("Enter the grade for student " + i + ": ");
			grade = s.nextInt();
			
			while(grade < 0 || grade > 100)
			{
				System.out.println("Invalid grade, try again...");
				System.out.print("Enter the grade for student " + i + ": ");
				grade = s.nextInt();
			}
			grades [i - 1] = grade; 
		}
		for(int i = 0; i < numStudents; i++)
			sum += grades[i];
		
		System.out.println("The average is: " + new DecimalFormat("##.##").format(sum / numStudents));
	}
}