import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] pages = new ArrayList [N+1];
		int [] dist = new int [N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i = 1; i <= N; i++)
		{
			pages[i] = new ArrayList<Integer>();
			String [] line = br.readLine().split(" ");
			for(int j = 0; j < line.length; j++)
			{
				pages[i].add(Integer.parseInt(line[j]));
			}
		}
		
		LinkedList<Integer> q = new LinkedList<>();
		q.add(1);
		dist[1] = 1;
		int tempDist = Integer.MAX_VALUE;
		while(!q.isEmpty())
		{
			int proc = q.pop();
			if(pages[proc].get(0) == 0)
				if(tempDist > dist[proc])
					tempDist = dist[proc];

			for(int j = 1; j < pages[proc].size(); j++)
			{
				if(dist[pages[proc].get(j)] > dist[proc]+1)
				{
					dist[pages[proc].get(j)] = dist[proc]+1;
					q.add(pages[proc].get(j));
				}
			}
		}
		int T = 0;
		for(int i = 1; i < dist.length; i++)
			if(dist[i] != Integer.MAX_VALUE)
				T++;
			
		if(T == N)
			System.out.println("Y");
		else
			System.out.println("N");
		System.out.println(tempDist);
	}
}