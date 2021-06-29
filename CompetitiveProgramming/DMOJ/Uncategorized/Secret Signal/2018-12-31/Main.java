import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.*;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] l1 = br.readLine().split(" ");
		Integer K = Integer.parseInt(l1[1]);
		String [] l2 = br.readLine().split(" ");
		
		Integer [] nums = new Integer [l2.length];
		for(Integer i = 0; i < l2.length; i++)
			nums[i] = Integer.parseInt(l2[i]);

		Integer count = 0;
		/////////////////////////////////////////////
		for(Integer i = 0; i < l2.length; i++)
		{
			Integer sum1 = 0;
			for(Integer j = i; j < l2.length; j++)
			{
				sum1 += nums[j];
				System.out.println("COUNT1:"+sum1+":"+i+":"+j+":"+nums[j]+":"+(sum1 % K == 0));
				if(sum1 % K == 0)
				{
					System.out.println("COUNT:"+sum1);
					count++;
				}
			}
		}
		///////////////////////////////////////////////
		System.out.println(count);
	}
}

/*

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] l1 = br.readLine().split(" ");
		Integer K = Integer.parseInt(l1[1]);
		String [] l2 = br.readLine().split(" ");
		
		Integer [] nums = new Integer [l2.length];
		for(Integer i = 0; i < l2.length; i++)
			nums[i] = Integer.parseInt(l2[i]);

		Integer count = 0;
		/////////////////////////////////////////////
		for(Integer i = 0; i < l2.length-2; i+=3)
		{
			Integer sum1 = 0;
			Integer sum2 = 0;
			Integer sum3 = 0;
			boolean add2 = true;
			boolean add3 = true;
			for(Integer j = i; j < l2.length; j++)
			{
				sum1 += nums[j];
				if(j >= l2.length-1)
					add2 = false;
				else
					sum2 += nums[j+1];
				if(j >= l2.length-2)
					add3 = false;
				else
					sum3 += nums[j+2];
				
				System.out.println("COUNT1:"+sum1+":"+i+":"+j+":"+nums[j]+":"+(sum1 % K == 0));
				if(sum1 % K == 0)
				{
					System.out.println("COUNT:"+sum1);
					count++;
				}
				System.out.println("COUNT2:"+sum2+":"+(i+1)+":"+(j+1)+":"+nums[j]+":"+(add2 && sum2 % K == 0));
				if(add2 && sum2 % K == 0)
				{
					System.out.println("COUNT:"+sum2);
					count++;
				}
				System.out.println("COUNT3:"+sum3+":"+(i+2)+":"+(j+2)+":"+nums[j]+":"+(add3 && sum3 % K == 0));
				if(add3 && sum3 % K == 0)
				{
					System.out.println("COUNT:"+sum2);
					count++;
				}
			}
		}
		///////////////////////////////////////////////
		System.out.println(count);
	}
}

*/