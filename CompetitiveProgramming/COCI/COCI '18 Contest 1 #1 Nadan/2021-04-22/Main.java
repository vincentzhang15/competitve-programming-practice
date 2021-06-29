import java.util.*;
import java.io.*;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < k-1; i++)
			System.out.println(k--);
	}
}