import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AMinusB
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			String [] line = br.readLine().split(" ");
			System.out.println(Integer.parseInt(line[0])-Integer.parseInt(line[1]));
		}
	}
}