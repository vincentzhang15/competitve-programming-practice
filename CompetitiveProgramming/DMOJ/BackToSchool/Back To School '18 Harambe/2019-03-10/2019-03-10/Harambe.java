import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Harambe
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i = 0; i < s1.length(); i++)
		{
			if(s1.charAt(i) == ' ' && s2.charAt(i) != ' ' || s1.charAt(i) != ' ' && s2.charAt(i) == ' ')
			{
				System.out.println("No plagiarism");
				return;
			}
			if(s1.charAt(i) != s2.charAt(i))
				count++;
		}
		
		if(count <= n)
			System.out.println("Plagiarized");
		else
			System.out.println("No plagiarism");
	}
}