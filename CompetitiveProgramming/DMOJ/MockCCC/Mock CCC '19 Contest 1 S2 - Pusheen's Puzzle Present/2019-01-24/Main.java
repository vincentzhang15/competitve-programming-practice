import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static int calculate(int num)
	{
		int num1 = (int) Math.sqrt(num);
		if(num1 * num1 == num)
			return num;
		else
		{
			int floorSquare = num1 * num1;
			int ceilingSquare = (num1 + 1) * (num1 + 1);

			if(Math.abs(floorSquare-num) < Math.abs(ceilingSquare -num) )
				return floorSquare;
			else
				return ceilingSquare;
		}
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		int sum = 0;
		for(int i = 0; i < N; i++)
		{
			String [] line = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
			{
				count ++;
				int n = Integer.parseInt(line[j]);
				if(n != count)
					sum++;
			}
		}
		System.out.println((int)Math.sqrt(calculate(sum)));
	}
}