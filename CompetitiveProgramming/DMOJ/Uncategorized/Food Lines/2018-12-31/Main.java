import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] l1 = br.readLine().split(" ");
		int M = Integer.parseInt(l1[1]);
		String [] l2 = br.readLine().split(" ");
		
		int [] lines = new int [l2.length];
		for(int i = 0; i < l2.length; i++)
			lines[i] = Integer.parseInt(l2[i]);
		
		for(int i = 0; i < M; i++)
		{
			Arrays.sort(lines);
			System.out.println(lines[0]);
			lines [0] += 1;
		}
	}
}