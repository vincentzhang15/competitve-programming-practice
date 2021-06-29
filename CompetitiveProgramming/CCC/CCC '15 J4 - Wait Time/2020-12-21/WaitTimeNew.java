import java.io.*;
import java.util.*;

public class WaitTimeNew
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int [] sent = new int [1001];
		int [] receive = new int [1001];
		int [] total = new int [1001];
		
		int t = 0;
		for(int i = 0; i < n; i++)
		{
			String cmd = sc.next();
			int x = sc.nextInt();
			
			if(cmd.equals("R"))
			{
				sent[x] = -1;
				receive[x] = t;
			}
			else if(cmd.equals("S"))
			{
				sent[x] = 1;
				total[x] += t - receive[x];
			}
			else
			{
				t += x-2;
			}
			t++;
		}
		
		for(int i = 0; i < 1001; i++)
		{
			if(sent[i] != 0)
			{
				System.out.print(i + " ");
				if(sent[i] == -1)
					System.out.println(-1);
				else
					System.out.println(total[i]);
			}
		}
	}
}