import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Contact
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int k = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == 'S')
				count++;
			else
				count = 0;
			
			if(count >= k)
			{
				System.out.println("Spamming");
				return;
			}
		}
		System.out.println("All good");
	}
}