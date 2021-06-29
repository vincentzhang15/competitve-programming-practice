import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().split(" ");
		int R = Integer.parseInt(line[0]);
		int C = Integer.parseInt(line[1]);
		int K = Integer.parseInt(br.readLine());
		
		int [][] map = new int [R+1][C+1];
		for(int i = 0; i < K; i++)
		{
			String [] cLine = br.readLine().split(" ");
			int r = Integer.parseInt(cLine[0]);
			int c = Integer.parseInt(cLine[1]);
			map[r][c] = -1;
		}

		map[1][1] = 1;
		for(int i = 1; i <= R; i++)
		{
			for(int j = 1; j <= C; j++)
			{			
				if(i != R && map[i+1][j] != -1)
					map[i+1][j] += map[i][j];
				if(j != C && map[i][j+1] != -1)
					map[i][j+1] += map[i][j];
			}
		}
		System.out.println(map[R][C]);
	}
}