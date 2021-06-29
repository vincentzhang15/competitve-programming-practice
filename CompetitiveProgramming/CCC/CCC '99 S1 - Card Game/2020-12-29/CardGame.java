import java.util.*;
import java.io.*;

public class CardGame
{
	static String [] data;
	static boolean notHigh(int index, int n)
	{
		for(int i = 0; i < n; i++)
			if(data[index+i].equals("ace") || data[index+i].equals("king") || data[index+i].equals("queen") || data[index+i].equals("jack"))
				return false;
		return true;
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = new String [52];
		for(int i = 0; i < 52; i++)
			data[i] = br.readLine();
		int a = 0;
		int b = 0;
		for(int i = 0; i < 52; i++)
		{
			String card = data[i];
			if(card.equals("ace") && 52-i-1 >= 4 && notHigh(i+1, 4))
				if(i % 2 == 0)
				{
					System.out.println("Player A scores 4 point(s).");
					a += 4;
				}
				else
				{
					System.out.println("Player B scores 4 point(s).");
					b += 4;
				}
			else if(card.equals("king") && 52-i-1 >= 3 && notHigh(i+1, 3))
				if(i % 2 == 0)
				{
					System.out.println("Player A scores 3 point(s).");
					a += 3;
				}
				else
				{
					System.out.println("Player B scores 3 point(s).");
					b += 3;
				}
			else if(card.equals("queen") && 52-i-1 >= 2 && notHigh(i+1, 2))
				if(i % 2 == 0)
				{
					System.out.println("Player A scores 2 point(s).");
					a += 2;
				}
				else
				{
					System.out.println("Player B scores 2 point(s).");
					b += 2;
				}
			else if(card.equals("jack") && 52-i-1 >= 1 && notHigh(i+1, 1))
				if(i % 2 == 0)
				{
					System.out.println("Player A scores 1 point(s).");
					a++;
				}
				else
				{
					System.out.println("Player B scores 1 point(s).");
					b++;
				}
		}
		System.out.println("Player A: " + a + " point(s).");
		System.out.println("Player B: " + b + " point(s).");
	}
}