import java.util.Scanner;
public class Main
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter m: ");
		int m = sc.nextInt();

		System.out.println("Enter n: ");
		int n = sc.nextInt();
		
		int sum = 0;
		for(int i = 1; i <= m; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				if(i + j == 10)
					sum ++;
			}
		}
		if(sum == 1)
			System.out.println("There is " + sum + " way to get the sum 10.");
		else
			System.out.println("There are " + sum + " ways to get the sum 10.");
	}
}
