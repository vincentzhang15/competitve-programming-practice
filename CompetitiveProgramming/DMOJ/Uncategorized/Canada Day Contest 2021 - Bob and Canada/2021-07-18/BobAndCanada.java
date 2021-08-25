/*
8
3
RWR
3
WWW
3
WRR
4
RWRW
6
WWWRRR
6
WWRRWW
10
RRRRWWRWRR
10
WWRRWWWWRW


0
2
2
1
1
3
1
3
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BobAndCanada
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nT = Integer.parseInt(br.readLine());
		for(int t=0; t<nT; t++)
		{
			int n = Integer.parseInt(br.readLine());
			int[] r = new int[n];
			int[] w = new int[n];

			String line = br.readLine();
			for(int i=0; i<n; i++)
			{
				if(line.charAt(i) == 'R')
					r[i] = 1;
				else if(line.charAt(i) == 'W')
					w[i] = 1;
			}

			//for(int i=0; i<n; i++) System.out.print(r[i] + " "); System.out.println();
			//for(int i=0; i<n; i++) System.out.print(w[i] + " "); System.out.println();

			for(int i=1; i<n; i++)
			{
				r[i] += r[i-1];
				w[i] += w[i-1];
			}

			//for(int i=0; i<n; i++) System.out.print(r[i] + " "); System.out.println();
			//for(int i=0; i<n; i++) System.out.print(w[i] + " "); System.out.println();

			int a = 0;
			int b = 0;
			//int totalMin = Integer.MAX_VALUE;
			int minA = w[0] - r[0];
			for(int i=1; i<n; i++)
			{
				int diff = w[i] - r[i];
				if(diff < minA)
				{
					minA = diff;
					a = i;
				}

				/*
				int total = (w[n-1] - w[b]) + (r[b] - r[a]) + w[a];
				if(total < totalMin)
				{
					totalMin = total;
					b = i;
				}
				*/
			}
			System.out.println(a);

			//System.out.println(totalMin);
		}

	}
}


/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BobAndCanada
{
	static int process(String middle)
	{
		System.out.println(middle);
		if(middle.indexOf("W") == -1)
			return 1;
		if(middle.indexOf("R") == -1)
			return 0;
		
		int r = middle.length() - middle.replaceAll("R", "").length();
		int w = middle.length() - middle.replaceAll("W", "").length();
		w--;
		
		return Math.min(r, w);
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			int x = Integer.parseInt(br.readLine());
			String s = br.readLine();
			
			if(s.length() == 3)
			{
				if(s.equals("WWW")) System.out.println(2);
				if(s.equals("WWR")) System.out.println(1);
				if(s.equals("WRW")) System.out.println(3);
				if(s.equals("WRR")) System.out.println(2);
				if(s.equals("RWW")) System.out.println(1);
				if(s.equals("RWR")) System.out.println(0);
				if(s.equals("RRW")) System.out.println(2);
				if(s.equals("RRR")) System.out.println(1);
			}
			else
			{
				String middle = s.substring(s.indexOf("W"), s.lastIndexOf("W"));
				if(s.startsWith("R") && s.endsWith("R"))
				{
					System.out.println(process(middle));
				}
				else if(s.startsWith("R"))
				{
					System.out.println(process(middle.substring(0, middle.length()-1))+1);
				}
				else if(s.endsWith("R"))
				{
					System.out.println(process(middle.substring(1))+1);
				}
				else
				{
					System.out.println(process(middle.substring(1, middle.length()-1))+2);
				}
			}
			System.out.println();/////
		}
	}
}

*/

/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BobAndCanada
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++)
		{
			int x = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int first = s.indexOf('W');
			int last = s.lastIndexOf('W');
			
			String middle = s.substring(first, last+1);
			if(middle.length() == s.length() && middle.indexOf("R") == -1)
				System.out.println("2");
			else
			{
				if(middle.indexOf("R") == -1 && middle.length()+1 == s.length())
					System.out.println("1");
				else
				{
					if(middle.length() == s.length())
					{
						middle = middle.substring(1, middle.length()-1)
						int r = middle.length() - middle.replace("R", "").length();
						int w = middle.length() - middle.replace("W", "").length();
						System.out.println(Math.min(r, w)+2);
					}
					else
					{
						int r = middle.length() - middle.replace("R", "").length();
						int w = middle.length() - middle.replace("W", "").length();
						System.out.println(Math.min(r, w));
					}
				}
			}
		}
	}
}
*/