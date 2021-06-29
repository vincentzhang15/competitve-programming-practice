import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		int start = Integer.parseInt(input[0]);
		int end = Integer.parseInt(input[1]);
		
		System.out.printf("%3s %3s %3s %3s %3s %3s %3s\n", "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat");

		if(start >= 2)
		{
			System.out.printf("%3s", " ");
			for(int i = 2; i < start; i++)
				System.out.printf("%4s", " ");
		}
		
		int count = start;
		for(int i = 1; i <= end; i++)
		{
			if((count-1)%7 == 0)
				System.out.printf("%3s", Integer.toString(i));
			else
				System.out.printf("%4s", Integer.toString(i));
			if(count%7 == 0)
				System.out.println();
			count++;
		}
		
		if(count%7 != 1)
			System.out.println();
	}
}