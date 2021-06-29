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
	static int N, M;
	
	public static void main(String [] args) throws IOException
	{
		Coord start = new Coord(0, 0);
		Coord end = new Coord(0, 0);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inLine = br.readLine().split(" ");
		N = Integer.parseInt(inLine[0]);
		M = Integer.parseInt(inLine[1]);
		
		map = new char [N][M];
		dist = new int [N][M];
		visited = new boolean [N][M];
		for(int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
		
		//int [][] endPoints = new int [10010][2];
		//int endCount = 0;
		for(int i = 0; i < N; i++)
		{
			String line = br.readLine();
			for(int j = 0; j < M; j++)
			{
				map[i][j] = line.charAt(j);
				if(line.charAt(j) == 'S')
				{
					start.x = j;
					start.y = i;
				}
				//if(line.charAt(j) == '.')
				//{
				//	endPoints[endCount][0] = j;
				//	endPoints[endCount][1] = i;
				//	endCount++;
				//}
			}
		}
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				if(map[i][j] == 'C')
				{
					for(int k = j; k < M; k++)
						if(map[i][k] != 'W' && map[i][k] == '.')
							map[i][k] = 'T';
					for(int k = j; k > 0; k--)
						if(map[i][k] != 'W' && map[i][k] == '.')
							map[i][k] = 'T';
					for(int k = i; k < N; k++)
						if(map[k][j] != 'W' && map[k][j] == '.')
							map[k][j] = 'T';
					for(int k = i; k >= 0; k++)
						if(map[k][j] != 'W' && map[k][j] == '.')
							map[k][j] = 'T';
				}
			}
		}

		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		
/*		for(int i = 0; i < endCount; i++)
		{
			end.x = endPoints[i][0];
			end.y = endPoints[i][1];
			
			bfs(start, end);
			if(dist[end.y][end.x] != Integer.MAX_VALUE)
				System.out.println(dist[end.y][end.x]);
			else
				System.out.println("-1");
		}
*/	}
	
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
				//System.out.println("------------" + y + ":"+x);
				
				if(x>=0 && x<N && y>=0 && y <M && !visited[y][x] && map[y][x] != 'W' && dist[y][x] > dist[row][col] + 1)
				{
					dist[y][x] = dist[row][col] + 1;
					visited[y][x] = true;
					q.add(new Coord(y, x));
				}
			}
			//System.out.println(to.y + ":" + to.x);
			if(visited[to.y][to.x]) break;
		}
	}
}