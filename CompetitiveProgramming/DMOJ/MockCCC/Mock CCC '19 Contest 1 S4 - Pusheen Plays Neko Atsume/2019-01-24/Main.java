import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.*;

public class Main
{
	static int a, b, c, d;
	static TreeMap<Integer, Integer> data = new TreeMap<Integer, Integer>();
	
	static int calculate(int x)
	{
		if(x <= 0)
			return 1;
		else
		{
			int value;
			if(data.containsKey(x))
				value = data.get(x);
			else
			{
				if(x < b*a && x < c*d)
					value = 2;
				else if(a == c && b == d)
					value = calculate(x/a-b) * 2;
				else
					value = calculate(x/a-b) + calculate(x/c-d);
				data.put(x, value);
			}
			return value;
		}
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line1 = br.readLine().split(" ");
		a = Integer.parseInt(line1[0]);
		b = Integer.parseInt(line1[1]);
		c = Integer.parseInt(line1[2]);
		d = Integer.parseInt(line1[3]);
		int Q = Integer.parseInt(line1[4]);
		
		for(int i = 0; i < Q; i++)
			System.out.println(calculate(Integer.parseInt(br.readLine())));
		
/*
      Set set = data.entrySet();
      Iterator i = set.iterator();		
      while(i.hasNext()) {
         Map.Entry me = (Map.Entry)i.next();
         System.out.print(me.getKey() + ": ");
         System.out.println(me.getValue());
      }
	  */
	}
}