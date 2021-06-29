import java.util.Scanner;

public class j2
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int trout = sc.nextInt();
		int pike = sc.nextInt();
		int pickerel = sc.nextInt();
		int total = sc.nextInt();

		int count = 0;
		int q1 = 0;

		for(int t = 0; t < total / trout; t++)
		{
					System.out.println("t: " + t);
			for(int p = 0; p < total / pike; p++)
			{
					System.out.println("t: " + t + " p: " + p);
				if(q1 + 1 > total / pickerel)
				{
					if((t > 0 || p > 0) && (t * trout + p * pike <= total))
					{
						count += 1;
						System.out.println(t + " Brown Trout, " + p + " Northern Pike, " + q1 + " Yellow Pickerel");
					}
				}
				else
				{
					for(int q = 0; q < total / pickerel; q++)
					{
						System.out.println("t: " + t + " p: " + p + " q: " + q);
						if((t > 0 || p > 0 || q > 0) && (t * trout + p * pike + q * pickerel <= total))
						{
							count += 1;
							System.out.println(t + " Brown Trout, " + p + " Northern Pike, " + q + " Yellow Pickerel");
						}
					}
				}
			}
		}
		System.out.println("Number of ways to catch fish: " + count);
	}
}