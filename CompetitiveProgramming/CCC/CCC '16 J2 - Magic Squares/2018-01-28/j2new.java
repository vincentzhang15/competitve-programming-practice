//10:14
import java.util.Scanner;

public class j2new
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int [][] data = new int [4][4];

		boolean magicornot = true;

		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
			{
				data[i][j] = scanner.nextInt();
			}

		int sum = data[0][0] + data[0][1] + data[0][2] + data[0][3];

		for(int i = 0; i < 4; i++)
		{
			int sum1 = 0;
			int sum2 = 0;
			for(int j = 0; j < 4; j++)
			{
				sum1 += data[i][j];
				sum2 += data[j][i];
			}
			if(sum != sum1)
			{
				System.out.println("not magic");
				return;
			}
			if(sum != sum2)
			{
				System.out.println("not magic");
				return;
			}
		}

		System.out.println("magic");
	}
}
//10:51