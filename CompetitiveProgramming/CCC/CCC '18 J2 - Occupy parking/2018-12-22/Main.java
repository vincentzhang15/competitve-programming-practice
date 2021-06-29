import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String l1 = br.readLine();
		String l2 = br.readLine();
		char [][] parking = new char [n][2];
		int count = 0;
		
		for(int i = 0; i < n; i++)
			parking[i][0] = l1.charAt(i);
		for(int i = 0; i < n; i++)
			parking[i][1] = l2.charAt(i);
		
		for(int i = 0; i < n; i++)
			if(parking[i][0] == parking[i][1] && parking[i][1] == 'C')
				count++;
		System.out.println(count);
	}
}