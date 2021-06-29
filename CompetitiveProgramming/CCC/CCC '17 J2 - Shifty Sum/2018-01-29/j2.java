import java.util.*;

public class j2
{
	public static void main (String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();

		int sum = n;
		for(int i = 0; i < k; i++)
		{
			
			n *= 10;
			sum += n;
		}
		System.out.println(sum);
	}
}