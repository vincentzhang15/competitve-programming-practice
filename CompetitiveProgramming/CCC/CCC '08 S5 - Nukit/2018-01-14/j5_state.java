import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class j5_state
{
	HashMap<String, Integer> winningGames = new HashMap<String, Integer>();
	//HashSet<String> lostGames = new HashSet<String>();

	void print(String prefix, int a, int b, int c, int d, int r)
	{
		System.out.print(prefix);
		System.out.print("  node: ( " + a + ", " + b + ", " + c + ", " + d + " ) ");
		if(r > 0)
			System.out.println(r);
		else
			System.out.println("");
	}
	
	int [][] move = { {2, 1, 0, 2}, {1, 1, 1, 1}, {0, 0, 2, 1}, {0, 3, 0, 0 },{1, 0, 0, 1} };
	

	void insertWinningGame(int a, int b, int c, int d, int i)
	{
		String signature = "" + a + ", " + b + ", " + c + ", " + d;
		winningGames.put(signature, 1);
		//print(" insert winning ", a, b, c, d, i);
	}
	void insertLostGame(int a, int b, int c, int d, int i)
	{
		String signature = "" + a + ", " + b + ", " + c + ", " + d;
		winningGames.put(signature, -1);
		//print(" insert lost", a, b, c, d, i);
	}
	
	int existingGame(int a, int b, int c, int d)
	{
		String signature = "" + a + ", " + b + ", " + c + ", " + d;
		if(!winningGames.containsKey(signature))
			return 0;
		int result = winningGames.get(signature);
		return result;
	}

	boolean outOfRange(int a, int b, int c, int d)
	{
		if(a<0 || b<0 || c<0 || d<0)
			return true;
		return false;
	}
	
	boolean setGamePositionValues(int na, int nb, int nc, int nd)
	{
		boolean notfinished = false;
		
		for(int a = 0; a<=na; a++)
		for(int b = 0; b<=nb; b++)
		for(int c = 0; c<=nc; c++)
		for(int d = 0; d<=nd; d++)
		{
			int r = existingGame(a, b, c, d);
			if(r != 0 )
				continue;
			
			int nlost = 0;
			int nwin = 0;
			
			for(int i = 0; i < 5; i++)
			{
				int x = a - move[i][0];
				int y = b - move[i][1];
				int z = c - move[i][2];
				int w = d - move[i][3];
				
				//System.out.println("  in loop: ( " + a + ", " + b + ", " + c + ", " + d + " ) " + i
					//		 + " ( " + x + ", " + y + ", " + z + ", " + w + " ) " 
						//);
				
				if(outOfRange(x, y, z, w))
				{
					nwin ++; // opponent win
					//System.out.println("  in loop out: ( " + a + ", " + b + ", " + c + ", " + d + " ) " + i
						//	 + " ( " + x + ", " + y + ", " + z + ", " + w + " ) " 
							// + i + ", " + nwin 
						//);
				}
				else
				{
					//System.out.println("  in loop else: ( " + a + ", " + b + ", " + c + ", " + d + " ) " + i
						//	 + " ( " + x + ", " + y + ", " + z + ", " + w + " ) " 
						//);
					
					r = existingGame(x, y, z, w);
					if(r == 1)
					{
						nwin ++; // opponent win
					}
					if(r == -1) 
					{
						nlost ++; // opponent lost
						
						//System.out.println("  in loop win: ( " + a + ", " + b + ", " + c + ", " + d + " ) " + i
							//	 + " ( " + x + ", " + y + ", " + z + ", " + w + " ) " 
								// + i + ", " + nwin 
							//);
					}
				}

				if(nwin == 5)
				{
					insertLostGame(a, b, c, d, 0);
					notfinished = true;
				}

				if(nlost > 0)
				{
					insertWinningGame(a, b, c, d, 0);
					notfinished = true;
				}
					
				//if(a == na && b == nb && c == nc && d == nd)
					//return false;
			}
		}
		return notfinished;
	}

	void run()
	{
		Scanner scanner = new Scanner(System.in);
		int ncases = scanner.nextInt();
		if(ncases <= 0)
			return;

		// winningGames.clear();
		
		for(int k=0;k<ncases;k++)
		{
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();
			
			System.out.print("Case " + (k + 1) + ":");
			print(" ", a, b, c, d, 0);
			
			while(setGamePositionValues(a, b, c, d))
				//System.out.println(" ==== new round");
				;
			
			int r = existingGame(a, b, c, d);
			if( r == 1)
				System.out.println("                                Patrick");
			else
				System.out.println("                                Roland");
			
		}
	}
	
	public static void main(String [] args)
	{
		j5_state obj = new j5_state();
		obj.run();
	}   
}

