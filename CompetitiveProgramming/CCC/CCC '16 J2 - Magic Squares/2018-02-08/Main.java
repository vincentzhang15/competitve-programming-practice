//10:14
import java.util.Scanner;

public class Main
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int [][] data = new int [4][4];

		boolean magicornot = false;

		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
			{
				data[i][j] = scanner.nextInt();
			}

		int sum = data[0][0] + data[0][1] + data[0][2] + data[0][3];
		int sum1;

		for(int i = 0; i < 4; i++)
		{
			sum1 = 0;
			for(int j = 0; j < 4; j++)
			{
				sum1 += data[i][j];
			}
			if(sum == sum1)
				magicornot = true;
			else
				magicornot = false;
		}

		if(magicornot)
			System.out.println("magic");
		else
			System.out.println("not magic");
	}
}
//10:51