import java.util.*;

public class j5
{
	HashSet<String> ways = new HashSet<String>(); 
	int[] plan;
	int k;
	
	void save_plan()
	{
		List<Integer> tmp = new ArrayList<Integer>(k);
		
		for(int i = 0; i<k; i++)
		{
			tmp.add(plan[i]);
		}
		
		Collections.sort(tmp, new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});

		String str = new String();
		for(int i = 0; i<k; i++)
		{
			str += tmp.get(i).toString() + ".";
		}
		ways.add(str);
	}
	
	int calculate(int n, int k, int level)
	{
		if(n == 0 || k > n)
			return 0;
		
		if(n == k)
		{
			plan[level] = n;
			save_plan();
			return 1;
		}
		
		int count = 0;
		for(int i = 1; i <= k; i++)
		{
			plan[level] = i;
			int left = n - i;
			count += calculate(left, k - 1, level + 1);
		}
		return count;
	}
	void run()
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		k = s.nextInt();
		plan = new int[k];
		
		calculate(n, k, 0);
		System.out.println(ways.size());
	}
	public static void main(String [] args)
	{
		j5 obj = new j5();
		obj.run();
	}
}