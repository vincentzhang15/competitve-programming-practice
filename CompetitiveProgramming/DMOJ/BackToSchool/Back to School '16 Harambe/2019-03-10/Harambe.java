import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Harambe
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		int lower = 0;
		int upper = 0;
		for(int i = 0; i < line.length(); i++)
		{
			if(line.charAt(i) >= 'a' && line.charAt(i) <= 'z')
				lower++;
			else if(line.charAt(i) >= 'A' && line.charAt(i) <= 'Z')
				upper++;
		}
		
		if(lower > upper)
			System.out.println(line.toLowerCase());
		else if(upper > lower)
			System.out.println(line.toUpperCase());
		else
			System.out.println(line);
	}
}