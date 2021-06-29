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
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		int [][] data = new int [N+1][2];
		for(int i = 1; i <= N; i++)
		{
			String [] cLine = br.readLine().split(" ");
			data[i][0] = Integer.parseInt(cLine[0]);
			data[i][1] = Integer.parseInt(cLine[1]);			
		}

		boolean [] result = new boolean [N+1];
		int [] balls = new int [N+1];
		balls[1] = M;
		
		for(int i = 1; i <= N; i++)
		{
			int b = balls[i];
			if(b % 2 == 0)
				System.out.print("0");
			else
				System.out.print("1");
			
			if(data[i][0] <= N)
				balls[data[i][0]] += b-b/2;
			if(data[i][1] <= N)
				balls[data[i][1]] += b/2;
		}
	}
}