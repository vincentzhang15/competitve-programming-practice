import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Braille
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		for(int j = 0; j < 3; j++)
		{
			for(int i = 0; i < s.length(); i++)
			{
				char c = s.charAt(i);
				if(j == 0)
				{
					if(c == 'A' || c == 'K' || c == 'U' || c == 'B' || c == 'L' || c == 'V' || c == 'E' || c == 'O' || c == 'Z' || c == 'H' || c == 'R')
						System.out.print("o.");
					else if(c == 'I' || c == 'S' || c == 'J' || c == 'T' || c == 'W')
						System.out.print(".o");
					else if(c == ' ')
						System.out.print("..");
					else
						System.out.print("oo");
				}
				else if(j == 1)
				{
					if(c == 'B' || c == 'L' || c == 'V' || c == 'F' || c == 'P' || c == 'I' || c == 'S')
						System.out.print("o.");
					else if(c == 'D' || c == 'N' || c == 'E' || c == 'O' || c == 'Y' || c == 'Z')
						System.out.print(".o");
					else if(c == ' ' || c == 'X' || c == 'C' || c == 'M' || c == 'A' || c == 'K' || c == 'U')
						System.out.print("..");
					else
						System.out.print("oo");
				}
				else
				{
					if(c == 'K' || c == 'L' || c == 'M' || c == 'N' || c == 'O' || c == 'P' || c == 'Q' || c == 'R' || c == 'S' || c == 'T')
						System.out.print("o.");
					else if(c == 'W')
						System.out.print(".o");
					else if(c == 'U' || c == 'V' || c == 'W' || c == 'X' || c == 'Y' || c == 'Z')
						System.out.print("oo");
					else
						System.out.print("..");
				}
			}
			System.out.println();
		}
	}
}