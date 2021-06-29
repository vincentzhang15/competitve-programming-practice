import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PrimeFactorizationNew
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		while(n --> 0)
		{
			int a = Integer.parseInt(br.readLine());
			for(int i = 2; i <= Math.sqrt(a); i++)
			{
				while(a % i == 0)
				{
					System.out.print(i + " ");
					a /= i;
				}
			}
			if(a != 1)
				System.out.print(a);
			System.out.println();
		}
	}
}