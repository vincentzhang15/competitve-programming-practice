import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PoetryWithSplit
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] limits = new int[n];
		
		for(int i = 0; i < n; i++)
			limits[i] = Integer.parseInt(br.readLine());
		
		String[] line = br.readLine().split(" ");
		int idx = 0;
		for(int i = 0; idx < line.length; i++)
		{
			int limit = limits[i%n];
			String word = line[idx++];

			if(word.length() > limit)
			{
				int first = 0;
				int last = limit;
				while(last < word.length())
				{
					System.out.println(word.substring(first, last));
					i++; limit = limits[i%n];
					
					first = last;
					last = first + limit;
				}
				word = word.substring(first);
			}

			while(idx < line.length && (word + " " + line[idx]).length() <= limit)
				word += " " + line[idx++];
			System.out.println(word);
		}
	}
}