import java.util.*;
import java.io.*;

public class Main
{
	static class Coord { int x; int y; Coord(int y, int x){ this.x = x; this.y = y;}}
	//static int[][] dist;
	static boolean[][] visited;
	static int[][] map;
	static int N,H;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Coord start = new Coord(0, 0);
		Coord end = new Coord(0, 0);

		String[] line0 = br.readLine().split(" ");
		N = Integer.parseInt(line0[0]);
		H = Integer.parseInt(line0[1]);

		map = new int[N][N];
		//dist = new int[N][N];
		//for (int i = 0; i < N; i++)
			//Arrays.fill(dist[i], Integer.MAX_VALUE);
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++)
		{
			String[] line1 = br.readLine().split(" ");
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(line1[j]);
		}
		start.x = 0;
		start.y = 0;
		end.x = N-1;
		end.y = N-1;

		bfs(start, end);
		if (visited[end.y][end.x])
		{
			System.out.println("yes");
		}
		else
		{
			System.out.println("no");
		}
	}

	public static void bfs(Coord from, Coord to)
	{
		Queue<Coord> q = new LinkedList<>();
		q.add(from);
		//dist[from.y][from.x] = 0;
		visited[from.y][from.x] = 0;
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
				if(x>=0 && x<N && y>=0 && y<N && !visited[y][x] && Math.abs(map[y][x]-map[row][col]) <= H)// &&  dist[y][x] > dist[row][col] + 1)
				{
					//dist[y][x] = dist[row][col] + 1;
					visited[y][x] = true;
					q.add(new Coord(y, x));
				}
			}
			if (visited[to.y][to.x]) break;
		}
	}
}