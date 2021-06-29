import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
	
public class Main
{
	class After
	{
		TreeSet<Integer> a = new TreeSet<Integer>();
		After(int taskId)
		{
			a.add(taskId);;
		}
		void add(int taskId)
		{
			a.add(taskId);
		}
	};
	TreeMap<Integer, After> tasks = new TreeMap<Integer, After>();
	ArrayList<Integer> output = new ArrayList<Integer>();

	public void run()
	{
		/*
		tasks.add(new After(1, 7));
		tasks.add(new After(1, 4));
		tasks.add(new After(2, 1));
		tasks.add(new After(3, 4));
		tasks.add(new After(3, 5));
		*/	
		tasks.put(7, new After(1));
		tasks.put(4, new After(1));
		tasks.put(1, new After(2));
		tasks.get(4).add(3);	
		tasks.put(5, new After(3));
		
		Scanner sc = new Scanner(System.in);

		while(true)	
		{
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();

			if(c1 == 0 && c2 == 0)
				break;
			//tasks.add(new After(c1, c2));
			if(tasks.containsKey(c2))
				tasks.get(c2).add(c1);
			else
				tasks.put(c2, new After(c1));
		}
		
		for(int i=7; i>=1; i--	)
		{
			int after = 0;
			if(tasks.containsKey(i))
			{
				After t = tasks.get(i);
				for(Integer k : t.a)
				{
					for(int j=0;j<output.size(); j++)
					{
						if(output.get(j) == k)
							if( after < j)
								after = j;
					}
				}
			}
			
			boolean inserted = false;
			int j=0;
			for(j=0;j<output.size(); j++)
			{
				if(j<=after)
					continue;
					if(output.get(j) > i)
				{
					output.add(j, i);
					inserted = true;
					break;
				}
			}
			if(!inserted)
			{
				output.add(j, i);
			}
		}
		
		/*
		Collections.sort(list, new Comparator<After>() {
			public int compare(After o1, After o2) {
				if(o1.b == o2.t) return 1;
				if(o2.b == o1.t) return -1;
			}
		});
		*/

		for(Integer x : output)
		{
			System.out.print("" + x + " ");
		}
		System.out.println("");	
	}
	
	public static void main(String [] args)
	{
		Main m = new Main();
		m.run();
	}	
}
