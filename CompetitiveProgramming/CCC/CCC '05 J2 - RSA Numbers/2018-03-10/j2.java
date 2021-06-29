import java.util.*;

public class j2
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		int lower = sc.nextInt();
		int upper = sc.nextInt();
		
		int RSAnumbers = 0;
		for(int i = lower; i <= upper; i++)
		{
			int divisors = 0;
			for(int j = 1; j <= i; j++)
			{
				if(i % j == 0)
					divisors++;
			}
			if(divisors == 4)
				RSAnumbers++;
		}
		System.out.println("The number of RSA numbers between " + lower + " and " + upper + " is " + RSAnumbers);
	}
}