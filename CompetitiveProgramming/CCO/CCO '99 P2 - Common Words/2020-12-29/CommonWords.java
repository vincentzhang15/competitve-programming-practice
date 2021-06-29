import java.util.*;
import java.io.*;

public class CommonWords
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		TreeMap<Integer, ArrayList<String>> flip = new TreeMap<Integer, ArrayList<String>>();
		for(int i = 0; i < t; i++)
		{
			String [] line = br.readLine().split(" ");
			int m = Integer.parseInt(line[0]);
			int k = Integer.parseInt(line[1]);
			for(int j = 0; j < m; j++)
			{
				String s = br.readLine();
				if(data.containsKey(s))
					data.put(s, data.get(s)+1);
				else
					data.put(s, 1);
			}

			for(Map.Entry<String, Integer> entry : data.entrySet())
			{
				String key = entry.getKey();
				int value = entry.getValue();
				if(flip.containsKey(-value))
				{
					ArrayList<String> a = flip.get(-value);
					a.add(key);
					flip.put(-value, a);
				}
				else
				{
					ArrayList<String> a = new ArrayList<String>();
					a.add(entry.getKey());
					flip.put(-value, a);
				}
			}

			
			if(k % 100 == 13 || k % 100 == 12 || k % 100 == 11)
				System.out.println(k + "th most common word(s):");
			else if(k % 10 == 1)
				System.out.println(k + "st most common word(s):");
			else if(k % 10 == 2)
				System.out.println(k + "nd most common word(s):");
			else if(k % 10 == 3)
				System.out.println(k + "rd most common word(s):");
			else
				System.out.println(k + "th most common word(s):");

			int c = 0;
			for(Map.Entry<Integer, ArrayList<String>> entry : flip.entrySet())
			{
				if(c == k-1)
				{
					ArrayList<String> a = entry.getValue();
					for(String s : a)
						System.out.println(s);
					break;
				}
				else
					c += entry.getValue().size();
			}
			System.out.println();
			
			/*for(Map.Entry<Integer, ArrayList<String>> entry : flip.entrySet())
			{
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}
			System.out.println();
			System.out.println("-----------------");
			*/
			data.clear();
			flip.clear();
		}
	}
}