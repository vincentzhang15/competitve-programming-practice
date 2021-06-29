import java.util.*;

public class j1
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int bear1 = sc.nextInt();
		int bear2 = sc.nextInt();
		int bear3 = sc.nextInt();

		TreeSet<Integer> bears = new TreeSet<Integer>();
		ArrayList<Integer> newarr = new ArrayList<Integer>();
		bears.add(bear1);
		bears.add(bear2);
		bears.add(bear3);   
		
	//	System.out.println(bears.get(1));
		
		for(Iterator it = bears.iterator(); it.hasNext();)
		{
			int number = (Integer)it.next();
			newarr.add(number);
		}
		System.out.println(newarr.get(1));
	}
}