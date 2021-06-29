import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SoundsFishy
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		int n3 = Integer.parseInt(br.readLine());
		int n4 = Integer.parseInt(br.readLine());
		
		if(n1 > n2 && n2 > n3 && n3 > n4)
			System.out.println("Fish Diving");
		else if(n1 < n2 && n2 < n3 && n3 < n4)
			System.out.println("Fish Rising");
		else if(n1 == n2 && n2 == n3 && n3 == n4)
			System.out.println("Fish At Constant Depth");
		else
			System.out.println("No Fish");
	}
}