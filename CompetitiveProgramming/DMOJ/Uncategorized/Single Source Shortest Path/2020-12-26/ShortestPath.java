import java.util.*;
import java.io.*;

public class ShortestPath
{
	static class E implements Comparable<E>
	{
		int v, w;
		E(int v, int w)
		{
			this.v = v;
			this.w = w;
		}
		
		public int compareTo(E x)
		{
			return Integer.compare(w, x.w);
		}
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		ArrayList<E> [] data = new ArrayList[10001];
		for(int i = 0; i < data.length; i++)
			data[i] = new ArrayList<E>();
		
		for(int i = 0; i < m; i++)
		{
			String [] line1 = br.readLine().split(" ");
			int a = Integer.parseInt(line1[0]);
			int b = Integer.parseInt(line1[1]);
			int w = Integer.parseInt(line1[2]);
			
			data[a].add(new E(b, w));
			data[b].add(new E(a, w));
		}
		
		int [] d = new int [10001];
		Arrays.fill(d, 0x3f3f3f3f);
		d[1] = 0;
		PriorityQueue<E> q = new PriorityQueue<E>();
		q.add(new E(0, 1));
		while(!q.isEmpty())
		{
			E temp = q.poll();
			int w = temp.v;
			int a = temp.w;
			
			if(d[a] < w)
				continue;
			for(E p : data[a])
			{
				int aa = p.v;
				int ww = p.w;
				if(d[aa] > d[a] + ww)
				{
					d[aa] = d[a] + ww;
					q.add(new E(-d[aa], aa));
				}
			}
		}
		
		for(int i = 1; i <= n; i++)
		{
			if(d[i] == 0x3f3f3f3f)
				System.out.println(-1);
			else
				System.out.println(d[i]);
		}
	}
}