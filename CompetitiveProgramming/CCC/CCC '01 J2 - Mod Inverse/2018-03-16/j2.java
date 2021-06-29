import java.util.*;

public class j2
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int m = s.nextInt();
		int n = 0;

		while(true)
		{
			if(n >= m)
			{
				System.out.println("No such integer exists.");
				return;
			}
			else if((x * n) % m == 1)
			{
				System.out.println(n);
				return;
			}
			n++;
		}
	}
}
