import java.util.*;

public class Main
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);

		int [] bet = new int [5];

		bet [0] = sc.nextInt();
		bet [1] = sc.nextInt();
		bet [2] = sc.nextInt();
		bet [3] = sc.nextInt();
		bet [4] = 0;

		int count = 0;
		for(int i = 0; i < 5; i++)
		{
			System.out.print(count + " ");
			count += bet[i];
		}
		System.out.println();

		count = 0;
		System.out.print(bet [0] + " ");
		for(int i = 1; i < 5; i++)
		{
			System.out.print(count + " ");
			count += bet[i];
		}
		System.out.println();

		count = 0;
		System.out.print(bet [0] + bet [1] + " ");
		System.out.print(bet [1] + " ");
		for(int i = 2; i < 5; i++)
		{
			System.out.print(count + " ");
			count += bet[i];
		}
		System.out.println();

		count = 0;
		System.out.print(bet [0] + bet [1] + bet [2] + " ");
		System.out.print(bet [1] + bet [2] + " ");
		System.out.print(bet [2] + " ");
		for(int i = 3; i < 5; i++)
		{
			System.out.print(count + " ");
			count += bet[i];
		}
		System.out.println();

		count = 0;
		System.out.print(bet [0] + bet [1] + bet [2] + bet [3] + " ");
		System.out.print(bet [1] + bet [2] + bet [3] + " ");
		System.out.print(bet [2] + bet [3] + " ");
		System.out.print(bet [3] + " ");
		for(int i = 4; i < 5; i++)
		{
			System.out.print(count + " ");
			count += bet[i];
		}
		System.out.println();
	}
}