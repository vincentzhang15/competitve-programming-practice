import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int one = Integer.parseInt(br.readLine());
		int two = Integer.parseInt(br.readLine());
		int three = Integer.parseInt(br.readLine());
		int four = Integer.parseInt(br.readLine());
		
		if(one == 8 || one == 9)
			if(four == 8 || four == 9)
				if(two == three)
				{
					System.out.println("ignore");
					return;
				}
				
		System.out.println("answer");
	}
}