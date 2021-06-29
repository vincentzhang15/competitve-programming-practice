import java.util.*;
import java.io.*;

public class ShortestPath2
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
		for(int i = 0; i < 10001; i++)
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
		
		int [] dist = new int [10001];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		PriorityQueue<E> q = new PriorityQueue<E>();
		q.add(new E(0, 1));
		while(!q.isEmpty())
		{
			E e = q.poll();
			int a = e.w;
			int w = e.v;
			
			if(dist[a] < w)
				continue;
			
			for(E u : data[a])
			{
				int aa = u.v;
				int ww = u.w;
				if(dist[aa] > dist[a] + ww)
				{
					dist[aa] = dist[a] + ww;
					q.add(new E(-dist[aa], aa));
				}
			}
		}
		for(int i = 1; i <= n; i++)
			System.out.println((dist[i] == Integer.MAX_VALUE)?("-1"):(dist[i]));
	}
}