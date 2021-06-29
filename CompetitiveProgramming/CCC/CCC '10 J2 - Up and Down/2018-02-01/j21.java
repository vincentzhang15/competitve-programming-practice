import java.util.Scanner;

public class j21
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int s = sc.nextInt();
		
		int nikky = 0;
		int byron = 0;
		int steps = 0;
		while(steps < s)
		{
			for(int j = 1; j <= a; j++)
			{
				steps ++;
				nikky ++;
				if(steps >=s )
					break;
			}
			for(int j = 1; j <= b; j++)
			{
				steps ++;
				nikky --;
				if(steps >=s )
					break;
			}
		}
		steps = 0;
		while(steps < s)
		{
			for(int j = 1; j <= c; j++)
			{
				steps ++;
				byron ++;
				if(steps >=s )
					break;
			}
			for(int j = 1; j <= d; j++)
			{
				steps ++;
				byron --;
				if(steps >=s )
					break;
			}
		}
		if(nikky < byron)
			System.out.println("Byron");
		else if(nikky > byron)
			System.out.println("Nikky");
		else
			System.out.println("Tied");
	}
}