import java.util.*;

public class j3
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int adjs = sc.nextInt();
		int nouns = sc.nextInt();

		String [] adj = new String [adjs];
		String [] noun = new String [nouns];
		for(int i = 0; i < adjs; i++)
			adj[i] = sc.next();
		for(int i = 0; i < nouns; i++)
			noun[i] = sc.next();

		for(int i = 0; i < adjs; i++)
		{
			for(int j = 0; j < nouns; j++)
			{
				System.out.println(adj[i] + " as " + noun[j]);
			}
		}
	}
}