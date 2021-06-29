import java.util.*;

public class j2
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();

		for(int i = start; i <= end; i++)
		{
			int diff = i - start;
			if(diff % 5 == 0 && diff % 4 ==0 && diff % 3 == 0 && diff % 2 == 0)
				System.out.println("All positions change in year " + i);
		}
	}
}