import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ListMinimumEasy
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for(int i = 1; i <= n; i++)
			System.out.print(i + " ");
	}
}