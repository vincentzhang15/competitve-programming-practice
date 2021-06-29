/**
* A program that prints a pattern.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class PrintPatternE
{
	public static void main(String[] args)
	{
		int size = 8;
		for(int i = 0; i < size; i++)
			System.out.print("# ");
		System.out.println();
		
		for(int i = 0; i < size- 2; i++)
		{
			System.out.print("# ");
			for(int j = 0; j < size - 2; j++)
				System.out.print("  ");
			System.out.println("# ");
		}
		
		for(int i = 0; i < size; i++)
			System.out.print("# ");
		System.out.println();
	}
}