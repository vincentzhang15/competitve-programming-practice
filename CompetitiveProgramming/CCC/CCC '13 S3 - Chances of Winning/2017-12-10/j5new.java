import java.util.*;

public class j5new
{
	int games [] = new int [6];
	int favouriteteam;
	int count = 0;
	
	int [][] result = new int [5][6];
	
	void findPosibilities(int level)
	{
		if(level < 6)
		{
			int a = games[level] / 10;
			int b = games[level] % 10;
			
			result[a][level] = 3;
			result[b][level] = 0;
			findPosibilities(level+1);
			
			result[a][level] = 1;
			result[b][level] = 1;
			findPosibilities(level+1);
			
			result[a][level] = 0;
			result[b][level] = 3;
			findPosibilities(level+1);
		}
		else if(level == 6) 
		{
			int mark[] = new int[5];
			
			for(int i=1;i<5;i++)
			{
				//System.out.print(" team: "+ i+": ");
				mark[i] = 0;
				for(int j=0;j<6;j++)
				{
					//System.out.print(result[i][j]+", ");
					mark[i] += result[i][j];
				}
				//System.out.println(" mark = "+mark[i]);
			}
			boolean notwin = false;
			for(int i=1;i<5;i++)
			{
				if(i == favouriteteam) continue;
				if(mark[favouriteteam] <= mark[i])
					notwin = true;
			}
			if(!notwin)
			{
				//System.out.println("               <===== win");
				count ++;
			}
			//else 
				//System.out.println(" ");
		}
	}
	
	
	void run()
	{
		Scanner in = new Scanner(System.in);
		favouriteteam = in.nextInt();
		int gamessofar = in.nextInt();
		
		for(int i=0; i<5;i++)
		for(int j=0; j<6;j++)
			result[i][j] = 0;
		
		for(int i = 0; i < gamessofar; i++)
		{
			int a, b, sa, sb;
			a = in.nextInt();
			b = in.nextInt();
			sa = in.nextInt();
			sb = in.nextInt();
			
			int id = a * 10 + b;
			if(a > b)
				id = b * 10 + a;
			
			games[i] = id;
			
			if(sa > sb)
			{
				result[a][i] = 3;
				result[b][i] = 0;
			}
			else if(sa == sb)
			{
				result[a][i] = 1;
				result[b][i] = 1;
			}
			else // sb > sa
			{
				result[a][i] = 0;
				result[b][i] = 3;
			}
		}
		
		int n = gamessofar;
		for(int i=1; i<=4; i++)
		for(int j=1; j<=4; j++)
		{
			if(i>=j)
				continue;
			int id = i * 10 + j;
			
			boolean done = false;
			for(int k=0;k<n;k++)
			{
				if(games[k] == id)
				{
					done = true;
					break;
				}
			}
			if(!done)
			{
				System.out.println("i="+ i+", j="+j+", n="+n+", id="+id);
				games[n] = id;
				n ++;
			}
		}

		findPosibilities(gamessofar);
		
		System.out.println(count);
	}
	
	public static void main(String [] args)
	{
		j5new obj = new j5new();
		obj.run();
	}

}

