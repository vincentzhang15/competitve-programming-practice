import java.util.Scanner;
import java.util.TreeSet;
import java.util.Iterator;

public class j2_1
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		int p3 = sc.nextInt();
		int pp = sc.nextInt();

		int count = 0;
		int q1 = 0;
		
		TreeSet<Integer> combinations = new TreeSet<Integer>();
		
		for(int i=0;i<=100;i++)
		{
			if(i*p1>pp) 
				break;
			for(int j=0;j<=100;j++)
			{
				if(i*p1 + j*p2 > pp)
					break;
				for(int k=0;k<=100;k++)
				{
					if(i+j+k==0)
						continue;
					if(i*p1 + j*p2 + k*p3 > pp)
						break;
					combinations.add(i*1000000 + j * 1000 + k);
				}
			}
		}
		for(Iterator it = combinations.iterator(); it.hasNext();)
		{
			int x = (Integer)it.next();
			System.out.println("" + (x/1000000) + " Brown Trout, " + (x/1000%1000) + " Northern Pike, " + (x%1000) + " Yellow Pickerel");
		}
		System.out.println(""+combinations.size());
	}
}