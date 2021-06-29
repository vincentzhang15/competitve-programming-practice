/**
* A program that prints a pattern.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class PrintPatternF
{
	public static void main(String[] args)
	{
		int size = 8;
		for(int i = 1; i < size; i++)
			System.out.print("# ");
		System.out.println();
		
		for(int i = 1; i < size- 2; i++)
		{
			for(int j = 0; j < i; j++)
				System.out.print("  ");
			System.out.println("#");
		}
		
		for(int i = 1; i < size; i++)
			System.out.print("# ");
		System.out.println();
	}
}