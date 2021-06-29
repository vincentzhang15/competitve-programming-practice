import java.util.Scanner;

public class Main
{
	static boolean calculate (int a, int b, int n)
	{
		for(int i = 0; i <= n; i++)
			for(int j = 0; j <= n; j++)
			{
				if(i == 0 && j == 0)
					j++;
				if(n % (i*a + j * b) == 0)
					return true;
			}
		return false;
	}
	
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		
		for(int i = 0; i < t; i++)
		{
			int a = s.nextInt();
			int b = s.nextInt();
			int n = s.nextInt();
			
			if(calculate(a, b, n))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}