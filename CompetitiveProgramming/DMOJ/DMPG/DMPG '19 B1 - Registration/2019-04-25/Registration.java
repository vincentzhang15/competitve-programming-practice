import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Registration
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] line = br.readLine().split(" ");
		
		int count = 0;
		for(int i = 0; i < n; i++)
		{
			count += Integer.parseInt(line[i]);
		}
		
		if(count > 200)
			System.out.println("Over maximum capacity!");
		else
			System.out.println(200-count);
	}
}