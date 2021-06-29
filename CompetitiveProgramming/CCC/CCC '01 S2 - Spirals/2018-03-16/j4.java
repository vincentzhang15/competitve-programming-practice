/*
	down x 1
	right x 1
	up x 2
	left x 2
	
	down x 3
	right x 3
	up x 4
	left x 4
*/

import java.util.*;

public class j4
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int start = s.nextInt();
		int end = s.nextInt();
		
		for(int i = start; i <= end; i++)
		{
			System.out.print(i + " ");
		}
		int dimensions = 1;
		for(dimensions = 1;; dimensions++)
		{
			int transfer = dimensions;
			dimensions *= dimensions;
			if(dimensions > end - start)
				break;
			dimensions= transfer;
		}
		dimensions = (int)Math.sqrt(dimensions);
		System.out.println();
		System.out.println(dimensions);
		
		int p[][] = new int [dimensions + 1][dimensions + 1];
		
		for(int i = 0; i < dimensions + 1; i++)
			for(int j = 0; j < dimensions + 1; j++)
				p[i][j] = 0;

		for(int i = dimensions / 2; i < dimensions + 1; i++)
		{
			for(int j = dimensions / 2; j < dimensions + 1; j++)
			{
				p[i][j] = 0;
			}
		}
		int count = 0;
		int x = dimensions / 2;
		int y = dimensions / 2;
		for(int i = dimensions / 2; i <= dimensions; i++)
		{
			for(int j = dimensions / 2; j <= dimensions; j++)
			{
				for(int k = 1;; k+=2)
				{
					for(int l = 0; l < k; l++)
					{
						x += k;
						p[x][y] = count;
					}
					for(int l = 0; l < k; l++)
					{
						y += k;
						p[x][y] = count;
					}
					count++;
					if(count > end)
						break;
				}
				for(int k = 2;; k+=2)
				{
					for(int l = 0; l < k; l++)
					{
						y -= k;
						p[x][y] = count;
					}
					for(int l = 0; l < k; l++)
					{
						x -= k;
						p[x][y] = count;
					}
					count++;
					if(count > end)
						break;
				}
			}
		}
		for(int i = 0; i < dimensions + 1; i++)
		{
			for(int j = 0; j < dimensions + 1; j++)
			{
				System.out.print(p[i][j] + " ");
			}
			System.out.println();
		}

	}
}