import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class TheGameOfLife
{
	static boolean[][] map, copy;
	static int r, c;
	
	static int neighbors(int j, int k)
	{
		int neighbours = 0;
		int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
		for(int i = 0; i < dir.length; i++)
			if(j + dir[i][0] >= 0 && j + dir[i][0] < r && k + dir[i][1] >= 0 && k + dir[i][1] < c)
				neighbours += map[j + dir[i][0]][k + dir[i][1]] ? 1 : 0;
		return neighbours;
	}
	
	static void print()
	{
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
				System.out.print(map[i][j] ? "X" : ".");
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		r = Integer.parseInt(line[0]);
		c = Integer.parseInt(line[1]);
		
		map = new boolean[r][c];
		for(int i = 0; i < r; i++)
		{
			String row = br.readLine();
			for(int j = 0; j < c; j++)
				map[i][j] = row.charAt(j) == 'X';
		}
		copy = Arrays.stream(map).map(boolean[]::clone).toArray(boolean[][]::new);
		
		for(int i = 1; i <= 100; i++)
		{
			int total = 0;
			for(int j = 0; j < r; j++)
			{
				for(int k = 0; k < c; k++)
				{
					int neighbours = neighbors(j, k);
					if(map[j][k])
						copy[j][k] = neighbours == 2 || neighbours == 3;
					else
						copy[j][k] = neighbours == 3;
					total += copy[j][k] ? 1 : 0;
				}
			}
			if(i == 1 || i == 5 || i == 10 || i == 50 || i == 100)
			System.out.println(total);
			map = Arrays.stream(copy).map(boolean[]::clone).toArray(boolean[][]::new);
		}
	}
}