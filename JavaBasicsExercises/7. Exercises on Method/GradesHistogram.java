import java.util.Scanner;

/**
* A program that outputs grades in histogram form.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-08-06
*
*/

public class GradesHistogram
{
	public static void main(String[] args)
	{
		int [] bins = new int [10];
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the number of students: ");
		int students = s.nextInt();
		int grade;
		
		// Process input
		for(int i = 0; i < students; i++)
		{
			System.out.print("Enter the grade for student " + (i + 1) + ": ");
			grade = s.nextInt();
			if(grade >= 90)
				bins [9]++;
			else if(grade >= 80)
				bins [8]++;
			else if(grade >= 70)
				bins [7]++;
			else if(grade >= 60)
				bins [6]++;
			else if(grade >= 50)
				bins [5]++;
			else if(grade >= 40)
				bins [4]++;
			else if(grade >= 30)
				bins [3]++;
			else if(grade >= 20)
				bins [2]++;
			else if(grade >= 10)
				bins [1]++;
			else if(grade >= 0)
				bins [0]++;
			else
			{
				System.out.println("Not a valid grade.");
				System.exit(0);
			}
		}
		System.out.println("\n");
		
		// Print vertical
		for (int binNum = 0; binNum < bins.length; binNum++)
		{
			// each row for one bin
			// Print label for each row
			if(binNum * 10 == 90)
				System.out.print("90 -100: ");
			else
				System.out.printf("%2s%2s%2s%1s", (10 * binNum), " - ", (10 * binNum + 9), ": ");
			for (int starNum = 0; starNum < bins[binNum]; starNum++)
			{
				// each column is one star
				System.out.print("*");
			}
			// print newline
			System.out.println();
		}
		System.out.println();
		
		// Find maximum bin count
		int maxBinCount = bins[0];
		for(int i = 0; i < bins.length; i++)
			if(bins[i] > maxBinCount)
				maxBinCount = bins[i];
		
		// Print horizontal
		for (int level = maxBinCount; level >= 1; level--)
		{
			// each row for one count level
			for (int binNum = 0; binNum < bins.length; binNum++)
			{
				// each column for one bin
				// if (bin's count >= level) print *
				// else print blank.
				if(bins[binNum] >= level)
					System.out.printf("%6s", "*   ");
				else
					System.out.printf("%6s", " ");
			}
			// print newline
			System.out.println();
		}
		System.out.println(" 0-9  10-19 20-29 30-39 40-49 50-59 60-69 70-79 80-89 90-100");
	}
}