import java.util.*;
import java.io.*;

public class Main
{
	static class Coord { int x; int y; Coord(int y, int x){ this.x = x; this.y = y;}}
	static int[][] dist;
	static boolean[][] visited;
	static String[][] map;
	static int n,m;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Coord start = new Coord(0, 0);
		Coord end = new Coord(0, 0);

		String[] line0 = br.readLine().split(" ");
		n = Integer.parseInt(line0[0]);
		m = Integer.parseInt(line0[1]);

		map = new String[n][m];
		dist = new int[n][m];
		for (int i = 0; i < n; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++)
		{
			String[] line1 = br.readLine().split("");
			for (int j = 0; j < m; j++)
			{
				map[i][j] = line1[j];
				if(map[i][j].equals("s"))
				{
					start.x = j;
					start.y = i;
				}
				else if(map[i][j].equals("e"))
				{
					map[i][j] = ".";
					end.x = j;
					end.y = i;
				}
			}
		}

		bfs(start, end);
		if (dist[end.y][end.x] != Integer.MAX_VALUE)
		{
			System.out.println(dist[end.y][end.x]-1);
		}
		else
		{
			System.out.println("-1");
		}
	}

	public static void bfs(Coord from, Coord to)
	{
		Queue<Coord> q = new LinkedList<>();
		q.add(from);
		dist[from.y][from.x] = 0;
		visited[from.y][from.x] = true;
		int d[][] = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		while (!q.isEmpty())
		{
			int row = q.peek().y;
			int col = q.peek().x;
			q.remove();
			visited[row][col] = true;
			for (int j = 0; j < 4; j++)
			{
				int x = col + d[j][0];
				int y = row + d[j][1];
				if(x>=0 && x<m && y>=0 && y<n && !visited[y][x] && map[y][x].equals(".") &&  dist[y][x] > dist[row][col] + 1)
				{
					dist[y][x] = dist[row][col] + 1;
					visited[y][x] = true;
					q.add(new Coord(y, x));
				}
			}
			if (visited[to.y][to.x]) break;
		}
	}
}