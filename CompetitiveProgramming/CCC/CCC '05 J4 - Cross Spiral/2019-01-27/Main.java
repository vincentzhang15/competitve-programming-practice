import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main
{
	static class Coord {int x; int y; Coord(int y, int x) {this.x = x;	this.y = y;}}
	static char [][] map;
	static int [][] dist;
	static boolean [][] visited;
	static int iTotal, jTotal;
	
	public static void main(String [] args) throws IOException
	{
		Coord start = new Coord(0, 0);
		Coord end = new Coord(0, 0);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int roomX = Integer.parseInt(br.readLine());
		int roomY = Integer.parseInt(br.readLine());
		int cornerX = Integer.parseInt(br.readLine());
		int cornerY = Integer.parseInt(br.readLine());
		int steps = Integer.parseInt(br.readLine());

		iTotal = Integer.parseInt(br.readLine());
		jTotal = Integer.parseInt(br.readLine());
		
		map = new char [roomX][roomY];
		dist = new int [roomX][roomY];
		visited = new boolean [roomX][roomY];
		for(int i = 0; i < iTotal; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		for(int i = 0; i < iTotal; i++)
		{
			String line = br.readLine();
			for(int j = 0; j < jTotal; j++)
				map[i][j] = line.charAt(j);
		}
		
		start.x = 0;
		start.y = 0;
		end.x = jTotal-1;
		end.y = iTotal-1;
		
		bfs(start, end);
		if(dist[end.y][end.x] != Integer.MAX_VALUE)
			System.out.println(dist[end.y][end.x] + 1);
		else
			System.out.println("-1");
	}
	
	public static void bfs(Coord from, Coord to)
	{
		Queue<Coord> q = new LinkedList<>();
		q.add(from);
		dist[from.y][from.x] = 0;
		int d [][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		
		while(!q.isEmpty())
		{
			int row = q.peek().y;
			int col = q.peek().x;
			q.remove();
			visited[row][col] = true;
			
			for(int j = 0; j < 4; j++)
			{
				int x = col + d[j][0];
				int y = row + d[j][1];
				
				if(x>=0 && x<jTotal && y>=0 && y <iTotal && !visited[y][x] && map[y][x] != '*' && dist[y][x] > dist[row][col] + 1)
				{
					if(map[row][col] == '|' && (j == 0 || j == 2))
						continue;
					else if(map[row][col] == '-' && (j == 1 || j == 3))
						continue;
					else
					{
						dist[y][x] = dist[row][col] + 1;
						visited[y][x] = true;
						q.add(new Coord(y, x));
					}
				}
			}
			//System.out.println(to.y + ":" + to.x);
			if(visited[to.y][to.x]) break;
		}
	}
}