import java.util.HashSet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class UniqueElements
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> hs = new HashSet<Integer>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			int a = Integer.parseInt(br.readLine());
			hs.add(a);
		}
		System.out.println(hs.size());
	}
}