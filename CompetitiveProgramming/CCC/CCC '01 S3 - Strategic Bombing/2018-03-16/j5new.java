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

public class j5new
{
	
	public static void main (String [] args)
	{
		ArrayList conns1 = new ArrayList();
		
		Scanner s = new Scanner(System.in);
		while(true)
		{
			String conn = s.next();
			if(conn.charAt(0) == '*')
				break;
			conns1.add(conn);
		}
		
		int count = 0;
		
		for(int i = 0; i< conns1.size(); i++)
		{
			ArrayList conns = new ArrayList();
			for(int k=0; k<conns1.size(); k++)
				if(i != k)
					conns.add(conns1.get(k));
			
			//System.out.println( " ........................ " + conns1.get(i));
			
			TreeSet<Character> visited = new TreeSet<Character>();
			visited.add('A');
			boolean failed = false;
			
			while(true)
			{
				boolean changed = false;
				for(int j = 0; j< conns.size(); j++)
				{
					String conn = (String)conns.get(j);
					char c1 = conn.charAt(0);
					char c2 = conn.charAt(1);
					if(visited.contains(c1))
					{
						//System.out.println( " 1 " + conn);
						if(c2 == 'B')
						{
							failed = true;
							//System.out.println(" .... end");
							break;
						}
						visited.add(c2);
						//System.out.println(" .... v "+ visited);
						conns.remove(j);
						j--;
						changed = true;
					}
					else if(visited.contains(c2))
					{
						//System.out.println( " 2 " + conn);
						if(c1 == 'B')
						{
							failed = true;
							//System.out.println(" .... end");
							break;
						}
						visited.add(c1);
						//System.out.println(" .... v "+ visited);
						conns.remove(j);
						j--;
						changed = true;
					}
				}
				if(failed)
					break;
				if(!changed)
					break;
			}
			if(!failed)
			{
				System.out.println(conns1.get(i));
				count ++;
			}
		}
		System.out.println(" count = " + count);
	}
}