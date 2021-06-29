import java.util.*;

public class s4
{
	static long getWeightOfSubtree(long w, long n)
	{
		return w / n;
	}

	static HashMap<Long, Long> data = new HashMap<Long, Long>();
	static long getNumberOfSubtrees(long w)
	{
		if(w == 1)
			return 1;
		
		long nos = 0;
		
		if(data.containsKey(w))
			return data.get(w);
		
		for(long i=w; i>1; i--)
		{
			long wos = getWeightOfSubtree(w, i);
			if(wos > 2)
			{
				nos += getNumberOfSubtrees(wos);
			}
			else
				nos ++;
		}
		data.put(w, nos);
		return nos;
	}

	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		long n = s.nextInt();
		long nos = getNumberOfSubtrees(n);
		
		System.out.println(nos);
	}
}