import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SimpleEncryption
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String top = br.readLine();
		String line = br.readLine();
		
		int [] shift = new int [top.length()];
		for(int i = 0; i < top.length(); i++)
			shift[i] = top.charAt(i) - 'A';
		
		int mod = 0;
		for(int i = 0; i < line.length(); i++)
		{
			if(line.charAt(i) >= 'A' && line.charAt(i) <= 'Z')
			{
				int num = ((line.charAt(i) - 'A') + shift[mod])%26;
				System.out.print((char)(num + 'A'));

				mod++;
				if(mod == top.length())
					mod = 0;
			}
		}
		System.out.println();
	}
}