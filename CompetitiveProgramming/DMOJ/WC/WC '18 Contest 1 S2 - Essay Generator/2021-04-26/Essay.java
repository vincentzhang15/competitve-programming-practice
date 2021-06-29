import java.util.Scanner;

public class Essay
{
	static int n;
	static String alpha = "abcdefghijklmnopqrstuvwxyz";
	static String[] words;
	static void calc()
	{
		int count = 0;
		for(int i = 0; i < alpha.length(); i++)
		{
			if(count == n)
				return;
			words[count] = alpha.charAt(i) + "";
			count++;
		}

		for(int i = 0; i < alpha.length(); i++)
		{
			for(int j = 0; j < alpha.length(); j++)
			{
				if(count == n)
					return;
				words[count] = alpha.charAt(i) + "" + alpha.charAt(j);
				count++;
			}
		}
		
		for(int i = 0; i < alpha.length(); i++)
		{
			for(int j = 0; j < alpha.length(); j++)
			{
				for(int k = 0; k < alpha.length(); k++)
				{
					if(count == n)
						return;
					words[count] = alpha.charAt(i) + ""+ alpha.charAt(j) + alpha.charAt(k);
					count++;
				}
			}
		}
	}

	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		words = new String[n];
		calc();
		
		for(int i = 0; i < n; i++)
		{
			if(i == n-1)
				System.out.println(words[i]);
			else
				System.out.print(words[i] + " ");
		}
	}
}