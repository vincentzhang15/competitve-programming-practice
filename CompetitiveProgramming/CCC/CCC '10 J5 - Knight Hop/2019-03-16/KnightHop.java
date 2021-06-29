import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class KnightHop
{
	static class Coord
	{
		int x;
		int y;
		Coord(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	
	static void BFS(Coord from, Coord to)
	{
		Queue<Coord> q = new LinkedList<>();
		q.add(from);
		dist[from.x][from.y] = 0;
		int [][] d = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
		while(!q.isEmpty())
		{
			int r = q.peek().x;
			int c = q.peek().y;
			q.remove();
			visited[r][c] = true;
			for(int i = 0; i < 8; i++)
			{
				int x = r + d[i][0];
				int y = c + d[i][1];
				if(x < 8 && x >= 0 && y < 8 && y >= 0 && visited[x][y] != true && dist[x][y] > dist[r][c] + 1)
				{
					dist[x][y] = dist[r][c] + 1;
					visited[x][y] = true;
					q.add(new Coord(x, y));
				}
			}
			if(visited[to.x][to.y])
				break;
		}
	}
	
	static boolean [][] visited = new boolean [8][8];
	static int [][] dist = new int [8][8];
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line1 = br.readLine().split(" ");
		String [] line2 = br.readLine().split(" ");
		
		Coord start = new Coord(0, 0);
		Coord end = new Coord(0, 0);
		
		for(int i = 0; i < 8; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		start.x = Integer.parseInt(line1[0])-1;
		start.y = Integer.parseInt(line1[1])-1;
		end.x = Integer.parseInt(line2[0])-1;
		end.y = Integer.parseInt(line2[1])-1;
		
		BFS(start, end);
		System.out.println(dist[end.x][end.y]);
	}
}