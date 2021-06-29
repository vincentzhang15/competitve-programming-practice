import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Calendar
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().split(" ");
		int start = Integer.parseInt(line[0]);
		int days = Integer.parseInt(line[1]);
		
		System.out.println("Sun Mon Tue Wed Thr Fri Sat");
		if(start == 2)
			System.out.print("   ");
		else if(start > 2)
		{
			System.out.print("   ");
			for(int i = 2; i < start; i++)
				System.out.print("    ");
		}
		
		for(int i = 1; i <= days; i++)
		{
			if((i + start - 1) % 7 == 1)
				System.out.format("%3s", i);
			else
				System.out.format("%4s", i);
			if((i + start - 1) % 7 == 0)
				System.out.println();
		}
		if((days + start - 1) % 7 == 0)
		{}
		else
			System.out.println();
	}
}
