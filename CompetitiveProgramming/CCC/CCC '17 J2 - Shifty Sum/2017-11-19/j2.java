import java.util.Scanner;

public class j2
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		
		int noriginal = n;
		int nmultipy = 0;
		int sum;
		for (int i = 1; i <= k; i++)
		{
			n *= 10;
			nmultipy += n;
		}
		sum = noriginal + nmultipy;
		System.out.println(sum);
	}
}

