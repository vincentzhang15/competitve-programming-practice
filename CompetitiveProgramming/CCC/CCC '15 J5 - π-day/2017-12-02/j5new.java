import java.util.Scanner;
import java.util.*;

public class j5new
{
	int peopleinline;
	HashSet<String> ways = new HashSet<String>(); 
	int[] plan;
	
	void save_plan()
	{
		List<Integer> tmp = new ArrayList<Integer>(peopleinline);
		
		for(int i = 0; i<peopleinline; i++)
		{
			tmp.add(plan[i]);
		}
		
		Collections.sort(tmp, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		String str = new String();
		for(int i = 0; i<peopleinline; i++)
		{
			str += tmp.get(i).toString() + ".";
		}
		ways.add(str);
	}
	
	int numberOfWays(int pieces, int people, int level)
	{
		if(pieces == 0)
			return 0;
		
		if(pieces < people)
			return 0;

		if(people == 1)
		{
			plan[level] = pieces;
			save_plan();
			return 1;
		}

		int count = 0;
		for(int j = 1; j <= pieces; j++)
		{
			plan[level] = j;
			int left = pieces - j;
			count += numberOfWays(left, people -1, level+1);
		}
		return count;
	}
	
	void run()
	{
		Scanner in = new Scanner(System.in);
		int piecesofpie = in.nextInt();
		peopleinline = in.nextInt();
		plan = new int[peopleinline];
		
		numberOfWays(piecesofpie, peopleinline, 0);
		
		System.out.println(ways.size());
	}
	
	public static void main(String [] args)
	{		
		j5new obj = new j5new();
		obj.run();
	}
}

