/**
* A program that prints a pattern.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class PrintPatternD
{
	public static void main(String[] args)
	{
		int size = 8;
		for(int i = 1; i <= size; i++)
		{
			for(int j = size; j > i; j--)
				System.out.print("  ");
			for(int j = 1; j <= i; j++)
				System.out.print("# ");
			System.out.println();
		}
	}
}