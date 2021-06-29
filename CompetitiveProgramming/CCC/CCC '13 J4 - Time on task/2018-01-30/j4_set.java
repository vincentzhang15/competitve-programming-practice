import java.util.*;

public class j4_set
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int time = sc.nextInt();
		int chores = sc.nextInt();
		
		TreeSet<Integer> choose = new TreeSet<Integer>();
		
		for(int i = 0; i < chores; i++)
			choose.add(sc.nextInt());

		
		System.out.println(choose);
		
		
		int i = 0;
		int sum = 0;
		for(Iterator it = choose.iterator(); it.hasNext();i++)
		{
			int x = (Integer)it.next();
			sum += x;
			
			System.out.println("i="+i+" x = "+ x+ "  sum="+sum);
			if(sum > time)
			{
				if(i==0)
					break;
				break;
			}
		}
		System.out.println(i);
	}
}