import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String dir = "";
		while(!(line = br.readLine()).equals("99999"))
		{
			int sum = (int)line.charAt(0)-48 + (int)line.charAt(1)-48;
			if(sum == 0)
				System.out.print(dir + " ");
			else if(sum %2 == 0)
				System.out.print((dir = "right") + " ");
			else
				System.out.print((dir = "left") + " ");
			System.out.println(line.substring(2));
		}
	}
}