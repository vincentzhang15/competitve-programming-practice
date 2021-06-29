import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Boolean
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int n = (s.length()-4)/4;
		
		if(n%2==0)
		{
			if(s.charAt(s.length()-2) == 'u')
				System.out.println("True");
			else
				System.out.println("False");
		}
		else
		{
			if(s.charAt(s.length()-2) == 'u')
				System.out.println("False");
			else
				System.out.println("True");
		}
	}
}