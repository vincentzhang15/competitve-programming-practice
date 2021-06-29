import java.io.*;
import java.util.*;

public class WordWrap
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 10; i++)
		{
			int limit = Integer.parseInt(br.readLine());
			String [] word = br.readLine().split(" ");
			
			int lim = limit;
			for(int j = 0; j < word.length; j++)
			{
				if(word[j].length() > limit)
				{
					if(j != 0 && lim != limit)
						System.out.println();
					lim = limit;
					
					int loops = word[j].length();
					for(int k = 0; k < loops/limit; k++)
					{
						if(k == loops/limit-1 && loops%limit == 0 && j == word.length-1)
							System.out.print(word[j].substring(0, limit));
						else
							System.out.println(word[j].substring(0, limit));
						word[j] = word[j].substring(limit);
					}
					if(loops % limit != 0)
					{
						System.out.print(word[j] + " ");
						lim = lim - 1 - word[j].length();
					}
				}
				else if(word[j].length() > lim)
				{
					lim = limit;
					System.out.println();
					System.out.print(word[j] + " ");
					lim = lim - 1 - word[j].length();
				}
				else
				{
					System.out.print(word[j] + " ");
					lim = lim - 1 - word[j].length();
				}
			}
			if(i == 9)
				System.out.print("\n=====");
			else
				System.out.println("\n=====");
		}
	}
}