import java.util.Scanner;
public class j2
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int h = scanner.nextInt();
		int m = scanner.nextInt();

		int a = 0;
		for(int t = 1; t <= m; t++)
		{
			int t3 = t*t*t;
			int t2 = t*t;
			int t4 = t*t*t*t;

			a = h*t3 + 2*t2 + t - 6*t4;

			if(a <= 0)
			{
				System.out.println("The balloon first touches ground at hour:");
				System.out.println(t);
				break;
			}
		}
		if(a >= 0)
		{
			System.out.println("The balloon does not touch ground in the given time.");
		}
	}
}