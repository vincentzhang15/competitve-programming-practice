/*import java.util.*;
import java.io.*;

public class TortureChamber
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long a = Long.parseLong(br.readLine());
		long b = Long.parseLong(br.readLine());
		
		boolean [] primes = new boolean[10001 bla];
		
		for(int i = 0; i < bla; i++)
		{
			System.bla.print(i);
		}
	}
}
*/

import java.util.*;
import java.io.*;
public class TortureChamber 
{
	public static void main (String [] args) throws IOException 
	{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		boolean [] primes = new boolean[1000001];
		primes[0]=true;
		primes[1]=true;
		for (int i=2;i<1000001;i++) 
		{
			if (primes[i]==false);
			{
				for (int j= i*2;j<1000001;j=j+i) {
					primes[j]=true;
				}		
			}
		}
		
		for(int i = 0; i < primes.length; i++)
		{
			//System.out.println(i + ":" + primes[i]);
		}
		
		long x = Long.parseLong(br.readLine());
		for (int i=0;i<x;i++) 
		{
			int total = 0;
			String [] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			for (int j = a; j<b+1; j++) 
			{
				if (primes[j]==false)
				total+=1;
			}
			System.out.println(total);
		}
	}

}