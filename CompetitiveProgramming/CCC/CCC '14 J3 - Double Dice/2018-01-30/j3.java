import java.util.Scanner;

public class j3
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner (System.in);
		int loop = scanner.nextInt();
		
		int a = 100;
		int d = 100;

		for(int i = 0; i < loop; i++)
		{
			int A = scanner.nextInt();
			int D = scanner.nextInt();

			if(A > D)
				d -= A;
			else if(A < D)
				a -= D;
		}
		System.out.println(a);
		System.out.println(d);
	}
}