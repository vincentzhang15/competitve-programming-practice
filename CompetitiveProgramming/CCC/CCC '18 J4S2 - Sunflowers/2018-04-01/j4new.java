import java.util.*;
public class j4new
{
	static boolean isOriginal(int size, int [][] flwr)
	{
		for(int i=0;i<size-1;i++)
		for(int j=0;j<size;j++)
		{
			if(flwr[i][j] > flwr[i+1][j])
				return false;
		}

		for(int i=0;i<size;i++)
		for(int j=0;j<size-1;j++)
		{
			if(flwr[i][j] > flwr[i][j+1])
				return false;
		}
		
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				System.out.print(""+flwr[i][j]+" ");
			}
			System.out.println("");
		}
		return true;
	}
	
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int [][] flowers = new int[size][size];
		int [][] flwr = new int[size][size];
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				flowers[i][j] = s.nextInt();
			
			
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
	
		if(isOriginal(size, flowers)) return;
		
		for(int i=0;i<size;i++) // cw 90
		for(int j=0;j<size;j++)
		{
			flwr[i][j] = flowers[j][size-1-i];
		}
		
		if(isOriginal(size, flwr)) return;
		
		for(int i=0;i<size;i++) // 180
		for(int j=0;j<size;j++)
		{
			flwr[i][j] = flowers[size-1-i][size-1-j];
		}
		
		if(isOriginal(size, flwr)) return;

		for(int i=0;i<size;i++) // cw 270 // ccw 90
		for(int j=0;j<size;j++)
		{
			flwr[i][j] = flowers[size-1-j][i];
		}
		
		if(isOriginal(size, flwr)) return;

		System.out.println("Error, imposible case, algorithm error or data error.");
		return;
	}
}