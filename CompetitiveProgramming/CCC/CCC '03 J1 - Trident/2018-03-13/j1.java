import java.util.*;

public class j1
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		int t = sc.nextInt();
		int s = sc.nextInt();
		int h = sc.nextInt();
		
		for(int i = 0; i < t; i++)
		{
			System.out.print("*");
			for(int j = 0; j < s; j++)
				System.out.print(" ");
			System.out.print("*");
			for(int j = 0; j < s; j++)
				System.out.print(" ");
			System.out.print("*");
			System.out.println("");
		}
		for(int i = 0; i <= s*2 + 2; i++)
			System.out.print("*");
		System.out.println("");

		for(int i = 0; i < h; i++)
		{
			for(int j = 0; j <= s; j++)
				System.out.print(" ");
			System.out.print("*");
			System.out.println("");
		}
	}
}