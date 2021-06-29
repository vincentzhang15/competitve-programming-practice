import java.util.*;

public class j3	
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();

		int [] money = new int [10];
		money [0] = 100;
		money [1] = 500;
		money [2] = 1000;
		money [3] = 5000;
		money [4] = 10000;
		money [5] = 25000;
		money [6] = 50000;
		money [7] = 100000;
		money [8] = 500000;
		money [9] = 1000000;

		int [] rmv = new int [cases + 1];
		for(int i = 0; i < cases; i++)
		{
			int index = sc.nextInt();
			money [index - 1] = 0;
		}

		int numerator = 0;
		for(int i = 0; i < money.length; i++)
		{
			numerator += money[i];
		}
		double sum = numerator / (10 - cases);
		
		int offer = sc.nextInt();
		if(sum >= offer)
			System.out.println("no deal");
		else
			System.out.println("deal");
	}
}