import java.util.*;

public class j1
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int h = s.nextInt();
		
		int stars = 1;
		int spaces = 2 * h - 2;
		
		for(int i = 0; i < h / 2; i++)
		{
			for(int j = 0; j < stars; j++)
				System.out.print("*");
			for(int j = 0; j < spaces; j++)
				System.out.print(" ");
			for(int j = 0; j < stars; j++)
				System.out.print("*");
			System.out.println();
			stars += 2;
			spaces -= 4;
		}
		for(int i = 0; i < h * 2; i++)
		{
			System.out.print("*");
		}
		System.out.println();

		for(int i = 0; i < h / 2; i++)
		{
			stars -= 2;
			spaces += 4;
			for(int j = 0; j < stars; j++)
				System.out.print("*");
			for(int j = 0; j < spaces; j++)
				System.out.print(" ");
			for(int j = 0; j < stars; j++)
				System.out.print("*");
			System.out.println();
		}

	}
}