import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BallSculpture
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		
		int [] balls = new int [n+1];
		balls[0] = m;

		for(int i = 0; i < n; i++)
		{
			if(balls[i] % 2 != 0)
				System.out.print(1);
			else
				System.out.print(0);

			String [] newline = br.readLine().split(" ");
			int a = Integer.parseInt(newline[0]);
			int b = Integer.parseInt(newline[1]);
			
			balls[a-1] += balls[i] - balls[i]/2;
			balls[b-1] += balls[i]/2;
		}
		System.out.println();

	}
}