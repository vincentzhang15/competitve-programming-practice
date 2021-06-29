import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] pages = new ArrayList [N+1];
		boolean [] visited = new boolean [N+1];
		int dist = 0;
		
		for(int i = 1; i < visited.length; i++)
			System.out.println(visited[i]);

		for(int i = 1; i <= N; i++)
		{
			pages[i] = new ArrayList<Integer>();
			String [] line = br.readLine().split(" ");
			for(int j = 0; j < line.length; j++)
			{
				pages[i].add(Integer.parseInt(line[j]));
			}
		}
		
		int count = 0;
		LinkedList<Integer> q = new LinkedList<>();
		q.add(1);
		while(!q.isEmpty())
		{
			int proc = q.pop();
			
			visited[proc] = true;
			count++;
			for(int j = 1; j < pages[proc].size(); j++)
			{
				if(pages[proc].get(j) == 0)
					break;
				else
					q.add(pages[proc].get(j));
			}
			if(dist < count-1)
				dist = count -1;
		}
	}
}