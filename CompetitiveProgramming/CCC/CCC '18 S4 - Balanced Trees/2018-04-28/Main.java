import java.util.*;

interface Memory
{
	public void init();
	public long get(int w);
	public void put(int w, long n);
}

class Map1 implements Memory 
{
	HashMap<Long, Long> data = new HashMap<Long, Long>();

	public void init()
	{
	}

	public long get(int w)
	{
		if(data.containsKey(w))
			return data.get(w);
		return 0;
	}
	
	public void put(int w, long n)
	{
		data.put((long)w, n);
	}
}


class Map2 implements Memory 
{
	static final int DIMENSION = 10000;
	
	HashMap<Integer, HashMap<Integer, Long>> data;

	public void init()
	{
		data = new HashMap<Integer, HashMap<Integer, Long>>();
	}

	public long get(int w)
	{
		int w1 = w % DIMENSION;
		int w2 = w / DIMENSION;

		if(!data.containsKey(w1))
			return 0;
		
		HashMap<Integer, Long> d = data.get(w1);
		
		if(!d.containsKey(w2))
			return 0;

		return d.get(w2);
	}
	
	public void put(int w, long n)
	{
		int w1 = w % DIMENSION;
		int w2 = w / DIMENSION;

		if(!data.containsKey(w1))
		{
			data.put(w1, new HashMap<Integer, Long>());
			if(!data.containsKey(w1))
				return;
		}

		HashMap<Integer, Long> d = data.get(w1);

		if(d.containsKey(w2))
			return;
		
		d.put(w2, n);
	}
}


class Array1 implements Memory 
{
	static final int dim1 =  100000;
	ArrayList<ArrayList<Long>> data = new ArrayList<ArrayList<Long>>();
	
	public void init()
	{
		/*
		for(int i=0; i<dim1; i++)
		{
			data.add(new ArrayList<Long>());
			ArrayList<Long> d = data.get(i);
			for(int j=0;j<dim2; j++)
			{
				d.add(0L);
			}
		}
		*/
	}
	
	public long get(int w)
	{
		int w1 = w % dim1;
		int w2 = w / dim1;
		
		if(w1>=data.size())
			return 0L;
		
		ArrayList<Long> d = data.get(w1);
		
		if(w2 >= d.size())
			return 0L;
		
		return d.get(w2);
	}
	
	public void put(int w, long n)
	{
		int w1 = w % dim1;
		int w2 = w / dim1;
		
		if(w1>=data.size())
		{
			for(int i=data.size(); i<w1+1;i++)
			{
				data.add(new ArrayList<Long>());
			}
		}
		
		ArrayList<Long> d = data.get(w1);
		if(w2 >= d.size())
		{
			for(int i=d.size(); i<w2+1;i++)
			{
				d.add(0L);
			}
		}
		
		d.set(w2, n);
	}
}


public class Main
{
	//static Memory mem = new Map1();
	static Memory mem = new Map2();
	//static Array1 mem;
	
	static long getWeightOfSubtree(int w, long n)
	{
		return (long)w / n;
	}

	static long getNumberOfSubtrees(int w)
	{
		if(w == 1)
			return 1;
	
		long nos = mem.get(w);

		for(long i=(long)w; i>1; i--)
		{
			long wos = getWeightOfSubtree(w, i);
			if(wos > 2)
			{
				nos += getNumberOfSubtrees((int)wos);
			}
			else
				nos ++;
		}
		mem.put(w, nos);
		return nos;
	}

	public static void main (String [] args)
	{
		mem.init();
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		//System.out.println("input: " + n);
		
		long nos = getNumberOfSubtrees(n);
		
		System.out.println(nos);
	}
}