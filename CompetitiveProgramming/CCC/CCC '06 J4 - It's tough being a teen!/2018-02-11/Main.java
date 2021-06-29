import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;
	
public class Main
{
	class Task
	{
		TreeSet<Integer> a = new TreeSet<Integer>();
		TreeSet<Integer> b = new TreeSet<Integer>();
		void before(int taskId)
		{
			b.add(taskId);;
		}
		void after(int taskId)
		{
			a.add(taskId);
		}
	};
	TreeMap<Integer, Task> tasks = new TreeMap<Integer, Task>();
	ArrayList<Integer> output = new ArrayList<Integer>();

	public void run()
	{
		tasks.put(1, new Task());
		tasks.get(1).before(7);
		tasks.put(7, new Task());
		tasks.get(7).after(1);
		
		tasks.get(1).before(4);
		tasks.put(4, new Task());
		tasks.get(4).after(1);

		tasks.put(2, new Task());
		tasks.get(2).before(1);
		tasks.get(1).after(2);

		tasks.put(3, new Task());	
		tasks.get(3).before(4);
		tasks.get(4).after(3);

		tasks.get(3).before(5);
		tasks.put(5, new Task());	
		tasks.get(5).before(3);
		
		Scanner sc = new Scanner(System.in);

		while(true)	
		{
			int c1 = sc.nextInt();
			int c2 = sc.nextInt();

			if(c1 == 0 && c2 == 0)
				break;
			if(!tasks.containsKey(c1))
				tasks.put(c1, new Task());
			tasks.get(c1).before(c2);
			
			if(tasks.containsKey(c2))
				tasks.put(c2, new Task());

			tasks.get(c2).after(c1);
		}
		
		{
			Set set = tasks.entrySet();
			Iterator i = set.iterator();

			while(i.hasNext()){
				Map.Entry me = (Map.Entry)i.next();
				System.out.println(" -- " + me.getKey() + ", " + ((Task)me.getValue()).a+ ", " + ((Task)me.getValue()).b);
			}
		}

		
		for(int i=1; i<=7; i++	)
		{
			int after = -1;
			int before = 100;
			if(tasks.containsKey(i))
			{
				Task t = tasks.get(i);
				for(Integer k : t.b)
				{
					for(int j=0;j<output.size(); j++)
					{
						if(output.get(j) == k)
							if(j< before)
								before = j;
					}
				}
				for(Integer k : t.a)
				{
					for(int j=0;j<output.size(); j++)
					{
						if(output.get(j) == k)
							if(j> after)
								after = j;
					}
				}
			}
			if(after >= before)
			{
				System.out.println("Go to bed.");
				return;
			}
			
			boolean inserted = false;
			int j=0;
			for(j=0;j<output.size() && j<before; j++)
			{
				if(j<=after)
					continue;
				
				if(output.get(j) > i)
				{
					output.add(j, i);
					System.out.println("F "+output);
					inserted = true;
					break;
				}
			}
			if(!inserted)
			{
				output.add(j, i);
				System.out.println("I "+output);
			}
		}
		
		/*
		Collections.sort(list, new Comparator<Task>() {
			public int compare(Task o1, Task o2) {
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
