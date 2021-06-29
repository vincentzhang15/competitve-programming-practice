import java.util.Scanner;

public class j5new
{
	int step(int level)
	{
		if(level <= 1)
			return 0;
		
		if(level == 2)
		{
			if(coins[0][0] > coins[1][0])
				return -1;
			else
				return 0;
		}
		
		int posL = -1;
		int valueL = -1;
		
		int posG = -1;
		int valueG = -1;
		
		for(int i=0; i<level; i++)
		{
			if(valueG < coins[i][0])
			{
				valueG = coins[i][0];
				posG = i;
			}
			if(i<level-1)
			{
				if(valueL > coins[i][0])
				{
					valueL = coins[i][0];
					posL = i;
				}
			}
		}
		
		int count = 0;
		
		if(posG < level - 1)
		{
			count += 2;
			count += 3;
		}
		
		count += step(level - 1);
		return count;
	}
	
	int do_it()
	{
		boolean ready = true;
		
		for(int i=0;i<coins.length-1;i++)
		{
			if(coins[i][0] > coins[i+1][0])
				ready = false;
		}
		
		int count = step(coins.length);
		
		System.out.println(
				  "size = " + coins.length 
				+ " ready = " + ready
				+ " steps = " + steps
				);
		
		return 0;
	}
	
	int[][] coins;
	
	void run()
	{
		Scanner scanner = new Scanner(System.in);
		for(int k=0;;k++)
		{
			int ncoins = scanner.nextInt();
			
			if(ncoins < 1)
				return;

			System.out.println("Case " + (k + 1) + ":");
			System.out.println("        ncoins = " + ncoins);

			coins = new int[ncoins][];
			for(int i=0; i<ncoins; i++)
			{
				coins[i] = new int[ncoins];
				coins[i][0] = scanner.nextInt();
				for(int j=1;j<ncoins;j++)
					coins[i][j] = 0;
			}
			
			
			for(int i=0; i<ncoins; i++)
			{
				System.out.print("        coins: ");
				for(int j=0; j<ncoins; j++)
					System.out.print(" " + coins[i][j]);
				System.out.println("");
			}
			do_it();
			
			System.out.println("");
		}
	}
	
	public static void main(String [] args)
	{
		j5new obj = new j5new();
		obj.run();
	}   
}