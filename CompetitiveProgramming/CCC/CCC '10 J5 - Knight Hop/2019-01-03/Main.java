import java.util.*;
import java.io.*;

public class Main
{
	static class Coord { int x; int y; Coord(int y, int x){ this.x = x; this.y = y;}}
	static int[][] dist;
	static boolean[][] visited;
	static int[][] map;
	//static int N,H;

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Coord start = new Coord(0, 0);
		Coord end = new Coord(0, 0);

		String[] line0 = br.readLine().split(" ");
		start.x = Integer.parseInt(line0[0])-1;
		start.y = Integer.parseInt(line0[1])-1;

		String[] line1 = br.readLine().split(" ");
		end.x = Integer.parseInt(line1[0])-1;
		end.y = Integer.parseInt(line1[1])-1;

		map = new int[8][8];
		dist = new int[8][8];
		for (int i = 0; i < 8; i++)
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		visited = new boolean[8][8];

		bfs(start, end);
		if (dist[end.y][end.x] != Integer.MAX_VALUE)
		{
			System.out.println(dist[end.y][end.x]);
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
		int d[][] = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2,1}, {1,2}, {-1,2}, {-2,1}};
		while (!q.isEmpty())
		{
			int row = q.peek().y;
			int col = q.peek().x;
			//System.out.println(row+":"+col);
			q.remove();
			visited[row][col] = true;
			for (int j = 0; j < 8; j++)
			{
				int x = col + d[j][0];
				int y = row + d[j][1];
				if(x>=0 && x<8 && y>=0 && y<8 && !visited[y][x] && dist[y][x] > dist[row][col] + 1)
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