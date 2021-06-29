import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BaramBe
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		for(int i = 0; i < s.length(); i++)
		{
			if(i == s.length()-1)
				System.out.print(s.charAt(i) + ".");
			else if (i < s.length()-2)
			{
				if(s.charAt(i+2) >= 'A' && s.charAt(i+2) <= 'Z')
					System.out.print(s.charAt(i) + ".");
				else
					System.out.print(s.charAt(i));
			}
			else
				System.out.print(s.charAt(i));
		}
	}
}