/*
	down x 1
	right x 1
	up x 2
	left x 2
	
	down x 3
	right x 3
	up x 4
	left x 4
*/

import java.util.*;

public class j5
{
	
	public static void main (String [] args)
	{
		ArrayList conns = new ArrayList();
		
		Scanner s = new Scanner(System.in);
		while(true)
		{
			String conn = s.next();
			if(conn.charAt(0) == '*')
				break;
			conns.add(conn);
		}
		boolean failed;
		boolean removed;
		int count = 0;
		while(true)
		{
			if(removed = false)
			{
				failed = true;
				break;
			}
			for(int i = 0; i< conns.size(); i++)
			{
				TreeSet<Character> visited = new TreeSet<Character>();
				visited.add('A');
				failed = false;
				System.out.println( " ........................ " + conns.get(i));
				
				for(int j = 0; j< conns.size(); j++)
				{
					if(i==j)
						continue;
					
					String conn = (String)conns.get(j);
					char c1 = conn.charAt(0);
					char c2 = conn.charAt(1);
					if(visited.contains(c1))
					{
						System.out.println( " 1 " + conn);
						if(c2 == 'B')
						{
							failed = true;
							System.out.println(" .... end");
							break;
						}
						visited.add(c2);
						System.out.println(" .... v "+ visited);
					}
					if(visited.contains(c2))
					{
						System.out.println( " 2 " + conn);
						if(c1 == 'B')
						{
							failed = true;
							System.out.println(" .... end");
							break;
						}
						visited.add(c1);
						System.out.println(" .... v "+ visited);
					}
					visited.remove(c1);
					if(c1 == 0)
						removed = false;
					visited.remove(c2);
					if(c2 == 0)
						removed = false;
				}
				if(!failed)
				{
					System.out.println(conns.get(i));
					count ++;
				}
			}
		}
		System.out.println(" count = " + count);
	}
}