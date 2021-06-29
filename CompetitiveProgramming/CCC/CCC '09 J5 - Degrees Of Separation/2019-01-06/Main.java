import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.TreeSet;

public class Main
{
	public static ArrayList<Integer> [] conn = new ArrayList [51];
	public static void insert (int a, int b)
	{
		//System.out.println("INSERT: " + a + ":" + b);
		conn[a].add(b);
		conn[b].add(a);
	}
	
	public static void delete (int a, int b)
	{
		//System.out.println("DELETE: " + a + ":" + b);
		conn[a].remove(Integer.valueOf(b));
		conn[b].remove(Integer.valueOf(a));
	}
	
	public static void outFriends (int a)
	{
		//System.out.println("OUTF: " + a);
		System.out.println(conn[a].size());
	}
	
	public static void outFrienFriends (int a)
	{
		//System.out.println("OUTFF: " + a);
		TreeSet<Integer> ff = new TreeSet<Integer>();
		for(Integer i: conn[a])
			for(Integer j: conn[i])
				if(j!=a)
					if(!conn[a].contains(j))
						ff.add(j);
						
		System.out.println(ff.size());
		
		/*
		int count = 0;
		for(int i = 0; i < conn[a].size(); i++)
		{
			for(int j = 0; j < conn[(int)conn[a].get(i)].size(); j++)
			{
				if((int)conn[(int)conn[a].get(i)].get(j) != a)
				{
					boolean en = true;
					for(int k : (ArrayList<Integer>)conn[a])
						if((int)conn[(int)conn[a].get(i)].get(j) == k)
						{
							en = false;
							break;
						}
					if(en)
						count++;
				}
			}
		}
		System.out.println(count);
		*/
	}
	
	public static void outSep (int a, int b)
	{
		//System.out.println("OUTSEP: " + a + ":" + b);
		int [] dist = new int [51];
		Arrays.fill(dist, Integer.MAX_VALUE);
		LinkedList<Integer> q = new LinkedList<>();
		q.add(a);
		dist[a] = 1;
		int tempDist = Integer.MAX_VALUE;
		while(!q.isEmpty())
		{
			int proc = q.pop();
			for(Integer j: conn[proc])
			{
				if(dist[j] > dist[proc]+1)
				{
					dist[j] = dist[proc]+1;
					q.add(j);
				}
				if(j == b)
				{
					System.out.println(dist[proc]);
					return;
				}
			}
		}
		System.out.println("Not connected");
		
	}
	
	public static void printConn()
	{
		for(int i = 0; i < 51; i++)
			System.out.println(i + ":" + conn[i]);
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = " ";
		
		for(int i = 0; i < 51; i++)
			conn[i] = new ArrayList<Integer>();
		
		insert(6, 1);
		insert(6, 2);
		insert(6, 3);
		insert(6, 4);
		insert(6, 5);
		insert(6, 7);
		insert(4, 5);
		insert(4, 3);
		insert(5, 3);
		insert(15, 3);
		insert(15, 13);
		insert(14, 13);
		insert(12, 13);
		insert(12, 11);
		insert(10, 11);
		insert(10, 9);
		insert(12, 9);
		insert(8, 9);
		insert(8, 7);
		insert(16, 17);
		insert(18, 17);
		insert(18, 16);
		
		while(!line.equals("q"))
		{
			line = br.readLine();
			if(line.equals("q"))
				break;
			
			if(line.equals("n") || line.equals("f"))
			{
				String line1 = br.readLine();
				switch(line)
				{
					case "n": outFriends(Integer.parseInt(line1)); break;
					case "f": outFrienFriends(Integer.parseInt(line1)); break;
				}
			}
			else
			{
				String line1 = br.readLine();
				String line2 = br.readLine();
				switch(line)
				{
					case "i": insert(Integer.parseInt(line1), Integer.parseInt(line2)); break;
					case "d": delete(Integer.parseInt(line1), Integer.parseInt(line2)); break;
					case "s": outSep(Integer.parseInt(line1), Integer.parseInt(line2)); break;
				}
			}
		}
		//printConn();
	}
}