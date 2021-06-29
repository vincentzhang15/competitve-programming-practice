import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class j5new
{
	HashSet<String> lostGames = new HashSet<String>();
	HashSet<String> winningGames = new HashSet<String>();

	void print(String prefix, int a, int b, int c, int d, int reaction)
	{
		System.out.print(prefix);
		System.out.print("  node: ( " + a + ", " + b + ", " + c + ", " + d + " ) ");
		/*
		if(reaction!=0)
			System.out.println(" r=" + reaction);
		else
			System.out.println("");
		*/
		System.out.println("");
	}
	
	boolean reaction_AABDD_Ok(int a, int b, int c, int d) 
	{
		if(a>=2 && b>=1 && d>=2)
			return true;
		return false;
	}
	
	boolean reaction_ABCD_Ok(int a, int b, int c, int d) 
	{
		if(a>=1 && b>=1 && c>=1 && d>=1)
			return true;
		return false;
	}
	
	boolean reaction_CCD_Ok(int a, int b, int c, int d) 
	{
		if(c>=2 && d>=1)
			return true;
		return false;
	}
	
	boolean reaction_BBB_Ok(int a, int b, int c, int d) 
	{
		if(b>=3)
			return true;
		return false;
	}
	
	boolean reaction_AD_Ok(int a, int b, int c, int d) 
	{
		if(a>=1 && d>=1)
			return true;
		return false;
	}
	
	void insertLostGame(int a, int b, int c, int d)
	{
		String signature = "" + a + ", " + b + ", " + c + ", " + d;
		lostGames.add(signature);
	}
	
	boolean existingLostGame(int a, int b, int c, int d)
	{
		String signature = "" + a + ", " + b + ", " + c + ", " + d;
		if(lostGames.contains(signature))
			return true;
		return false;
	}
	
	void insertWinningGame(int a, int b, int c, int d)
	{
		String signature = "" + a + ", " + b + ", " + c + ", " + d;
		winningGames.add(signature);
	}
	
	boolean existingWinningGame(int a, int b, int c, int d)
	{
		String signature = "" + a + ", " + b + ", " + c + ", " + d;
		if(winningGames.contains(signature))
			return true;
		return false;
	}
	
	boolean lostGame(int a, int b, int c, int d)
	{
		if(existingLostGame(a, b, c, d))
			return true;
		
		System.out.println(" checking lost game( " + a+ " + " + b+ " + " + c+ " + " + d);
		
		if(!reaction_AABDD_Ok(a, b, c, d) 
			&& !reaction_ABCD_Ok(a, b, c, d) 
			&& !reaction_CCD_Ok(a, b, c, d) 
			&& !reaction_BBB_Ok(a, b, c, d) 
			&& !reaction_AD_Ok(a, b, c, d) )
		{
			insertLostGame(a, b, c, d);
			return true;
		}
		
		if( reaction_AABDD_Ok(a, b, c, d) )
			if(!hasWinningStrategy(a-2, b-1, c, d-2))
				return false;
			
		if( reaction_ABCD_Ok(a, b, c, d) )
			if( !hasWinningStrategy(a-1, b-1, c-1, d-1))
				return false;
			
		if( reaction_CCD_Ok(a, b, c, d) )
			if( !hasWinningStrategy(a, b, c-2, d-1))
				return false;
			
		if( reaction_BBB_Ok(a, b, c, d) )
			if( !hasWinningStrategy(a, b-3, c, d))
				return false;
			
		if( reaction_AD_Ok(a, b, c, d) )
			if ( !hasWinningStrategy(a-1, b, c, d-1))
				return false;
			
		insertLostGame(a, b, c, d);
		return true;
	}

	boolean hasWinningStrategy(int a, int b, int c, int d)
	{
		if(existingWinningGame(a, b, c, d))
			return true;
		
		System.out.println(" checking winning game( " + a+ " + " + b+ " + " + c+ " + " + d);
		
		if( reaction_AABDD_Ok(a, b, c, d) && lostGame(a-2, b-1, c, d-2))
		{
			insertWinningGame(a, b, c, d);
			return true;
		}
		if( reaction_ABCD_Ok(a, b, c, d) && lostGame(a-1, b-1, c-1, d-1))
		{
			insertWinningGame(a, b, c, d);
			return true;
		}
		if( reaction_CCD_Ok(a, b, c, d) && lostGame(a, b, c-2, d-1))
		{
			insertWinningGame(a, b, c, d);
			return true;
		}
		if( reaction_BBB_Ok(a, b, c, d) && lostGame(a, b-3, c, d))
		{
			insertWinningGame(a, b, c, d);
			return true;
		}
		if( reaction_AD_Ok(a, b, c, d) && lostGame(a-1, b, c, d-1))
		{
			insertWinningGame(a, b, c, d);
			return true;
		}
		return false;
	}

	void run()
	{
		Scanner scanner = new Scanner(System.in);
		int ncases = scanner.nextInt();
		
		for(int k=0;k<ncases;k++)
		{
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();
			int d = scanner.nextInt();
			
			System.out.print("Case " + (k + 1) + ":");
			print(" ", a, b, c, d, 0);
			
			lostGames.clear();
			winningGames.clear();
			
			if(hasWinningStrategy(a,b,c,d))
				System.out.println("                                Patrick");
			else
				System.out.println("                                Roland");
		}
	}
	
	public static void main(String [] args)
	{
		j5new obj = new j5new();
		obj.run();
	}   
}


