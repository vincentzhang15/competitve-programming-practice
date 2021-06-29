import java.util.*;
import java.io.*;

public class AssigningPartners
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		
		String [] one = br.readLine().split(" ");
		String [] two = br.readLine().split(" ");
		
		for(int i = 0; i < number; i++)
		{
			if(one[i].equals(two[i]))
			{
				System.out.println("bad");
				return;
			}
			
			for(int j = 0; j < number; j++)
			{
				if(one[j].equals(two[i]))
				{
					if(!two[j].equals(one[i]))
					{
						System.out.println("bad");
						return;
					}
				}
			}				
		}
		System.out.println("good");
	}
}