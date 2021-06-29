import java.util.*;
public class j4
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int [][] flowers = new int[size][size];
		int [][] flwr = new int[size][size];
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				flowers[i][j] = s.nextInt();
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				flwr[i][j] = flowers[i][j];
/*
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
				System.out.print(flwr[i][j]);
			System.out.println();
		}
		System.out.println();
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
				System.out.print(flowers[i][j]);
			System.out.println();
		}
		System.out.println();
*/
		for(int max = 0; max<4; max++)
		{
			int a = 0;
			for(int i = size - 1; i >= 0; i--)
			{
				int b = 0;
				for(int j = 0; j <size; j++)
				{
					for(int c = 0; c < size; c++)
					{
						for(int d = 0; d < size; d++)
							System.out.print(flwr[c][d]);
						System.out.println();
					}
					System.out.println();

					if(flwr[0][0] < flwr[0][size-1] && flwr[size-1][0] < flwr[size-1][size-1]
					&& flwr[0][0] < flwr[size-1][0] && flwr[0][size-1] < flwr[size-1][size-1])
					{
						for(int c = 0; c < size; c++)
						{
							for(int d = 0; d < size; d++)
								System.out.print(flwr[c][d]);
							System.out.println();
						}
						return;
					}
					flwr[a][b] = flowers[i][j];
					b++;
				}
				a++;
			}
		}
	}
}