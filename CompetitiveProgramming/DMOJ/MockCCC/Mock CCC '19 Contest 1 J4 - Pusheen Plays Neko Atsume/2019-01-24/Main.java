import java.util.*;
import java.io.*;

public class Main
{
	static TreeMap <String, Integer> data = new TreeMap <String, Integer>();
	static LinkedHashMap<String, Integer> sData = new LinkedHashMap<>();
	static List<String> rData;

	static void sort()
	{
		data.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
			.forEachOrdered(x -> sData.put(x.getKey(), x.getValue()));	
	}
	
	static void reverse()
	{
		rData = new ArrayList<String>(sData.keySet());
		data.clear();
		Collections.reverse(rData);
		for (String key : rData) {
			data.put(key, sData.get(key));
		}
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			String line = br.readLine();
			if(data.containsKey(line))
				data.put(line, data.get(line) + 1);
			else
				data.put(line, 1);
		}

		sort();
		reverse();
		sort();
		reverse();
				
		Set set = data.entrySet();
		Iterator i = set.iterator();
		while(i.hasNext())
		{
			Map.Entry me = (Map.Entry)i.next();
			System.out.print(me.getKey() + " ");
			System.out.println(me.getValue());
		}

		//System.out.println(data);
		//System.out.println(rData);
		//System.out.println(sData);
	}
}



/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.Collections;
import java.io.*;

public class Main
{
	static ArrayList <String> list = new ArrayList <String>();
	static int index;
	
	static boolean contains (String b)
	{
		for(int i = 0; i < list.size(); i++)
		{
			String [] line1 = list.get(i).split(" ");
			String [] line2 = b.split(" ");
			if(line1[1].equals(line2[0]))
			{
				index = i;
				return true;
			}
		}
		return false;
	}
	
	static String change (String str)
	{
		String [] line = str.split(" ");
		int n = Integer.parseInt(line[0]) + 1;
		String changed = Integer.toString(n) + " " + str.substring(str.indexOf(' ') + 1);
		return changed;
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			String line = br.readLine();
			if(contains(line))
			{
				list.add(change(list.get(index)));
				list.remove(index);
			}
			else
			{
				list.add("1 " + line);
			}
		}
		Collections.sort(list);
		Collections.reverse(list);
		Collections.sort(list);
		Collections.reverse(list);
		
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).substring(list.get(i).indexOf(' ') + 1) + " " + list.get(i).substring(0, list.get(i).indexOf(' ')));
	}
}
*/