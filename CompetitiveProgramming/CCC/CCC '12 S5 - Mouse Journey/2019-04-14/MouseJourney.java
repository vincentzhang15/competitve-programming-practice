import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MouseJourney
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().split(" ");
		int r = Integer.parseInt(line[0]);
		int c = Integer.parseInt(line[1]);
		
		int map [][] = new int [r][c];
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			String [] line1 = br.readLine().split(" ");
			int x = Integer.parseInt(line1[0]);
			int y = Integer.parseInt(line1[1]);
			map[x-1][y-1] = -1;
		}
		
		map[0][0] = 1;
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				if(map[i][j] == -1)
					continue;
				if(i+1 < r && map[i+1][j] != -1)
					map[i+1][j] += map[i][j];
				if(j+1 < c && map[i][j+1] != -1)
					map[i][j+1] += map[i][j];
			}
		}
		System.out.println(map[r-1][c-1]);
	}
}