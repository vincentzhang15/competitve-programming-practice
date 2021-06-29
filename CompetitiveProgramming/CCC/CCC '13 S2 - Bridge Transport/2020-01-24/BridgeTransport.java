import java.io.*;
import java.util.*;

public class BridgeTransport
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.parseInt(br.readLine());
		int trains = Integer.parseInt(br.readLine());
		
		int [] list = new int [trains];
		
		for(int i = 0; i < trains; i++)
		{
			list[i] = Integer.parseInt(br.readLine());
		}
		
		if(trains == 1)
		{
			if(list[0] > max)
			{
				System.out.println(0);
			}
			else
				System.out.println(1);
		}
		else if(trains == 2)
		{
			if(list[0] + list[1] > max)
			{
				if(list[0] > max)
				{
					System.out.println(0);
				}
				else
					System.out.println(1);
			}
			else
				System.out.println(2);
		}
		else if(trains == 3)
		{
			if(list[0] + list[1] + list[2] > max)
			{
				if(list[0] + list[1] > max)
				{
					if(list[0] > max)
					{
						System.out.println(0);
					}
					else
						System.out.println(1);
				}
				else
					System.out.println(2);
			}
			else
				System.out.println(3);
		}
		else
		{
			if(list[0] + list[1] + list[2] > max)
			{
				if(list[0] + list[1] > max)
				{
					if(list[0] > max)
					{
						System.out.println(0);
						return;
					}
					else
					{
						System.out.println(1);
						return;
					}
				}
				else
				{
					System.out.println(2);
					return;
				}
			}

			for(int i = 0; i < trains-3; i++)
			{
				int sum = 0;
				sum += list[i];
				sum += list[i+1];
				sum += list[i+2];
				sum += list[i+3];
				
				if(sum > max)
				{
					System.out.println(i+3);
					return;
				}
			}
			System.out.println(trains);
		}
		
		
	}
}