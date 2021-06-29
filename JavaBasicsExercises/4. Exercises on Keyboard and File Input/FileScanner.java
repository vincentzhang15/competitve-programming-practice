import java.util.Scanner;              // Needed to use Scanner for input
import java.io.File;                   // Needed to use File
import java.io.FileNotFoundException;  // Needed for file operation

/**
* A program that processes file input.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class FileScanner
{ 
	public static void main(String[] args) throws FileNotFoundException // Needed for file operation
	{
		// Setup a Scanner to read from a text file
		Scanner in = new Scanner(new File("in.txt"));
		int num = in.nextInt();
		double realNumber = in.nextDouble();
		String name = in.next();
		
		System.out.println("The integer read is " + num);
		System.out.println("The floating point number read is " + realNumber);
		System.out.println("The String read is " + name);
		System.out.println("Hi! " + name + ", the sum of " + num + " and " + realNumber + " is " + (num + realNumber));

		in.close();
	}
}