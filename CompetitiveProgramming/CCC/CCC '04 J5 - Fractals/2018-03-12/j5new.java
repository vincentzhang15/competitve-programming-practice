import java.util.*;

public class j5new
{
	ArrayList [] ln;
	
	int left(int dir)
	{
		int d = dir - 1;
		if(d < 0) return 3;
		if(d > 3) return 0;
		return d;
	}
	
	int right(int dir)
	{
		int d = dir + 1;
		if(d < 0) return 3;
		if(d > 3) return 0;
		return d;
	}
	
	int nextx(int x, int y, int dir, int len)
	{
		switch(dir)
		{
			case 0: return x;
			case 1: return x + len;
			case 2: return x;
			case 3: return x - len;
		}
		return -1;
	}
	
	int nexty(int x, int y, int dir, int len)
	{
		switch(dir)
		{
			case 0: return y + len;
			case 1: return y;
			case 2: return y - len;
			case 3: return y;
		}
		return -1;
	}
	
	void run()
	{
		Scanner sc = new Scanner(System.in);
		int level = sc.nextInt();
		
		ln = new ArrayList[level+1];
		for(int i=0;i<=level;i++)
			ln[i] = new ArrayList();
		
		int width = sc.nextInt();
		int xcord = sc.nextInt();
		
		ln[0].add( 1 * 10000 + 100 * 0 + 1);
		
		int len = width;
		int w = len;
		for(int i=0; i<level; i++)
		{
			w/=3;
			int k = i+1;
			for(int j=0; j<ln[i].size(); j++)
			{
				int data = (int)ln[i].get(j);
				int dir = data / 10000;
				int x0 = data / 100 % 100;
				int y0 = data % 100;
				
				int x = x0;
				int y = y0;
				int d = dir;
				ln[k].add( d * 10000 + x * 100 + y); // line 1 right

				int t = 0;
				
				t = nextx(x, y, d, w);
				y = nexty(x, y, d, w);
				x = t;
				d = left(dir);
				ln[k].add( d * 10000 + x * 100 + y); // line 2 up
				
				t = nextx(x, y, d, w);
				y = nexty(x, y, d, w);
				x = t;
				d = dir;
				ln[k].add( d * 10000 + x * 100 + y); // line 3 right
				
				t = nextx(x, y, d, w);
				y = nexty(x, y, d, w);
				x = t;
				d = right(dir);
				ln[k].add( d * 10000 + x * 100 + y); // line 4 down
				
				t = nextx(x, y, d, w);
				y = nexty(x, y, d, w);
				x = t;
				d = dir;
				ln[k].add( d * 10000 + x * 100 + y);
			}
			len = w;
		}
		
		
		// debug print start
			int w0 = width;
			for(int k=0; k<=level; k++)
			{
				System.out.println(" ************** level = " + k);
				for(int j = 0; j< ln[k].size(); j++)
				{
					int data = (int)ln[k].get(j);
					int dir = data / 10000;
					int x0 = data / 100 % 100;
					int y0 = data % 100;
					System.out.println(" data: ( " + x0 + " , " + y0 + " ) dir = " + dir + " w = " + w0  );
				}
				w0 /= 3;
				System.out.println(" ");
				
			}
		// debug print end
		
		
		System.out.println(" find intersections method 1");
		TreeSet intersections = new TreeSet();
		
		int k = level;
		for(int j = 0; j< ln[k].size(); j++)
		{
			int data = (int)ln[k].get(j);
			int dir = data / 10000;
			int x0 = data / 100 % 100;
			int y0 = data % 100;
			
			int x1 = x0;
			int x2 = x0;
			
			
			if(dir == 0 || dir == 2)
				continue;
			else if(dir == 1)
				x2 = x1 + w;
			else if(dir == 3)
				x1 = x2 - w;

			System.out.print(" data: ( " + x0 + " , " + y0 + " ) dir = " + dir + " w = " + w  + " (" + x1 + " , " + x2 + " ) ");

			if(x1 <= xcord && xcord <= x2)
			{
				intersections.add(y0);
				System.out.println(" ******** found ");
			}
			else
			{
				System.out.println("");
			}
		}
		
		System.out.print(intersections);
		
		
		System.out.println("");
		System.out.println(" find intersections method 2:");
		
		//k = level;
		for(int i=0; i<  width /3 * 2 + 3; i++)
		{
			for(int j = 0; j< ln[k].size(); j++)
			{
				int data = (int)ln[k].get(j);
				int dir = data / 10000;
				int x0 = data / 100 % 100;
				int y0 = data % 100;
				
				if(dir == 0 || dir == 2)
				{
					int y1 = y0;
					int y2 = y0;
					if(dir == 0)
						y2 = y1 + w;
					else if(dir == 2)
						y1 = y2 - w;
					if(y1 <= i && i <= y2 && xcord == x0)
					{
						System.out.print(i+" ");
						break;
					}
				}
				else
				{
					int x1 = x0;
					int x2 = x0;
					if(dir == 1)
						x2 = x1 + w;
					else if(dir == 3)
						x1 = x2 - w;
					
					//System.out.print(" data: ( " + x0 + " , " + y0 + " ) dir = " + dir + " w = " + w  + " (" + x1 + " , " + x2 + " ) ");

					if(x1 <= xcord && xcord <= x2 && y0 == i)
					{
						System.out.print(i+" ");
						break;
					}
				}
			}
		}
		
		System.out.print("");
		
	}
		
	public static void main (String [] args)
	{
		j5new j = new j5new();
		j.run();
	}
}