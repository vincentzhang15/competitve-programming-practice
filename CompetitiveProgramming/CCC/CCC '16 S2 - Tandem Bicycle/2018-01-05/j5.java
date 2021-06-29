import java.util.*;

public class j5
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		int participants = in.nextInt();
		
		List<Integer> peg = new ArrayList<Integer>(participants);
		List<Integer> dmo = new ArrayList<Integer>(participants);

		for(int i = 0; i < participants; i++)
			peg.add(in.nextInt());

		for(int i = 0; i < participants; i++)
			dmo.add(in.nextInt());

		Collections.sort(peg, new Comparator<Integer>(){
			public int compare(Integer o1, Integer o2)
			{
				return o1 - o2;
			}
		});
		
		if(q == 1)
		{
			Collections.sort(dmo, new Comparator<Integer>(){
				public int compare(Integer o1, Integer o2)
				{
					return o1 - o2;
				}
			});
		}
		else
		{
			Collections.sort(dmo, new Comparator<Integer>(){
				public int compare(Integer o1, Integer o2)
				{
					return o2 - o1;
				}
			});
		}
		int total = 0;
		for(int i = 0; i < participants; i++)
		{
			if(peg.get(i) > dmo.get(i))
				total += peg.get(i);
			else
				total += dmo.get(i);
		}
		System.out.println(total);
	}
}