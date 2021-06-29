import java.util.Scanner;

public class j4
{
	public static void main(String [] args)
	{
		int pattern = 1;
		int [] diff = new int [21];
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0;; i++)
		{
			int n = sc.nextInt();
			if(n == 0)
				return;
			
			if(n == 1)
				System.out.println(0);
			else
			{
				int a = sc.nextInt();
				for(int k = 0; k < n; k++)
				{					
					diff[k] = a - n;
					n = a;
				}
				for(int j = 0;; j++)
				{
					a = 1;
					if(a + pattern > n || diff[a] != diff[a + pattern])
						break;
				}
				if(a + pattern > n)
					break;

				pattern += 1;
			}
			System.out.println(pattern);
		}
	}
}