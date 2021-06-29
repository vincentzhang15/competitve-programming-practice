import java.util.Scanner;

public class Main
{
	static boolean correct (int size, int [][] flower)
	{
		for(int i = 0; i < size-1; i++)
			for(int j = 0; j < size; j++)
				if(flower[i][j] > flower[i+1][j])
					return false;
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size-1; j++)
				if(flower[i][j] > flower[i][j+1])
					return false;
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
				System.out.print(flower[i][j] + " ");
			System.out.println();
		}
		return true;
	}
	
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int [][] original = new int [size][size];
		int [][] changed = new int [size][size];

		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				original[i][j] = s.nextInt();
		if(correct(size, original)) return;

		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				changed[i][j] = original[size-1-j][i];
		if(correct(size, changed)) return;

		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				changed[i][j] = original[size-1-i][size-1-j];
		if(correct(size, changed)) return;

		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				changed[i][j] = original[j][size-1-i];
		if(correct(size, changed)) return;
		
		System.out.println("ERROR"); return;
	}
}