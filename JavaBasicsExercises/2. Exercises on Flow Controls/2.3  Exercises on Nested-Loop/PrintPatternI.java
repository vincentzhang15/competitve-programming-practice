/**
* A program that prints a pattern.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class PrintPatternI
{
	public static void main(String[] args)
	{
		int size = 7;
		for(int i = 1; i <= size; i++)
		{
			for(int j = 1; j <= size; j++)
			{
				if(i == 1)
					System.out.print("# ");
				else if(i == size)
					System.out.print("# ");
				else if(j == 1)
					System.out.print("# ");
				else if(j == size)
					System.out.print("# ");
				else if(i == j)
					System.out.print("# ");
				else if(i + j == size + 1)
					System.out.print("# ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}