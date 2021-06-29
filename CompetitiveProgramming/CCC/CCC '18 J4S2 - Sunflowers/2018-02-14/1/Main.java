import java.util.*;

public class Main
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);

		int plants = sc.nextInt();
		
		int [][] data = new int [plants + 1][plants + 1];
		int [][] backup = new int [plants + 1][plants + 1];

		for(int i = 0; i < plants; i++)
			for(int j = 0; j < plants; j++)
				data [i][j] = sc.nextInt();


		if(plants == 2)
		{
			while(true)
			{
			data[0][0] = backup[0][1];
			data[0][1] = backup[1][1];
			data[1][1] = backup[1][0];
			data[1][0] = backup[0][0];

			for(int i = 0; i < plants; i++)
			for(int j = 0; j < plants; j++)
				backup [i][j] = data[i][j];
			
			if(data[0][0] < data [0][1] && data[0][0] < data [1][0] && data[1][0] < data [1][1])
				break;
			}
		}
		if(plants == 3)
		{
			while(true)
			{
			data[0][0] = backup[0][1];
			data[0][1] = backup[1][1];
			data[1][1] = backup[1][0];
			data[1][0] = backup[0][0];

			for(int i = 0; i < plants; i++)
			for(int j = 0; j < plants; j++)
				backup [i][j] = data[i][j];
			
			if(data[0][0] < data [0][1] && data[0][0] < data [1][0] && data[1][0] < data [1][1])
				break;
			}
		}

		for(int i = 0; i < plants; i++)
		{
			for(int j = 0; j < plants; j++)
			{
				System.out.print(data[i][j] + " ");
			}
			System.out.println();
		}
	}
}