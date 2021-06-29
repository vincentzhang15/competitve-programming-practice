import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;




public class j5bfs
{
	boolean _debug = false;
	TreeSet<Integer> visited = new TreeSet<Integer>();
	TreeMap<Integer,Page> working = new TreeMap<Integer, Page>();
	TreeMap<Integer,Page> newelem = new TreeMap<Integer, Page>();
	TreeMap<Integer,Page> all = new TreeMap<Integer, Page>();
	
	class Page
	{
		int pagenumber = 0;
		String signature;
		int level;
		ArrayList<Integer> jumps = new ArrayList<Integer>();
		ArrayList<Page> children = new ArrayList<Page>();
		
		Page parent = null;
		
		Page(int pn, String line)
		{
			pagenumber = pn;
			String[] strs = line.trim().split("\\s+");

			for (int i = 0; i < strs.length; i++) {
				int n = Integer.parseInt(strs[i]);
				jumps.add(n);
				if(_debug)
					System.out.print(n + " ");
			}
			if(_debug)
				System.out.println("");
			level = 1;
		}
		void markAsVisited()
		{
			visited.add(pagenumber);
		}
		void markAsWorking()
		{
			working.put(pagenumber, this);
		}
		void markAsNew()
		{
			newelem.put(pagenumber, this);
		}
		boolean insertNew(int num, Page p)
		{
			if(!all.containsKey(num))
				return false;
				
			Page nd = all.get(num);
			
			if(visited.contains(num))
				return false;
			if(working.containsKey(num))
				return false;
			if(newelem.containsKey(num))
				return false;
			
			children.add(nd);
			nd.markAsNew();
			nd.parent = this;
			//nd.print();
			return true;
		}
		
		boolean done()
		{
			if(jumps.size()==0)
			{
				finished = true;
				return true;
			}
			if(jumps.size()==1)
				if(jumps.get(0) == 0)
				{
					finished = true;
					return true;
				}
			return false;
		}
		void print()
		{
			if(!_debug)
				return;
			System.out.print("  page: " + pagenumber + " jumps: ");
			for(int i=0; i<jumps.size(); i++)
			{
				System.out.print(" " + jumps.get(i));
			}
			
			System.out.println("");
		}
	};
	boolean finished = false;
	
	int do_it()
	{
		while(working.size() > 0)
		{
			{
				Set set = working.entrySet();
				  
				Iterator itr = set.iterator();
				  
				if(_debug)
					System.out.println(" === ");
				while(itr.hasNext()) {
					Map.Entry me = (Map.Entry)itr.next();
					Page nd = (Page)me.getValue();
					
				if(_debug)
					System.out.println(" working:  "+ nd.pagenumber);
				
					if(nd.done())
					{
						if(_debug)
						{
							System.out.println(" ----------- found ---------- ");
						
							for(Page n = nd; n != null; n = n.parent)
							{
								n.print();
							}
							
							System.out.println(" ----------- level = " + nd.level + " ----------------- ");
						}
						System.out.println("Y");
						System.out.println(nd.level);
						
						return nd.level;
					}
					
					for(int i=0;i<nd.jumps.size(); i++)
					{
						int num = nd.jumps.get(i);
						Page nextpage = all.get(num);
						nd.insertNew(num, nextpage);
						nextpage.level = nd.level + 1;
					}
				}
			}

			if(working.size() > 0)
			{
				Set set = working.entrySet();
				Iterator itr = set.iterator();
				
				while(itr.hasNext()) {
					Map.Entry me = (Map.Entry)itr.next();
					Page nd = (Page)me.getValue();
					nd.markAsVisited();
					itr.remove();
				}
			}
			if(newelem.size() > 0)
			{
				Set set = newelem.entrySet();
				Iterator itr = set.iterator();
				
				while(itr.hasNext()) {
					Map.Entry me = (Map.Entry)itr.next();
					Page nd = (Page)me.getValue();
					nd.markAsWorking();
				}
				newelem.clear();
			}
		}
		
		return -1;
	}

	void run()
	{
		Scanner scanner = new Scanner(System.in);
		int npages = 0;
		
		for(int k=0; scanner.hasNextLine(); k++)
		{
            String line = scanner.nextLine();
			if(k == 0)
			{
				npages = Integer.parseInt(line);
				
				if(_debug)
					System.out.println("pages = " + npages);
			}
			else
			{
				Page p = new Page(k, line);
				if(k==1)
					p.markAsWorking();
				else
					all.put(k, p);
			}
        }		
		finished = false;
		do_it();
		if( finished == false )
			System.out.println("N");
		
		System.out.println("");
		
	}
	
	public static void main(String [] args)
	{
		j5bfs obj = new j5bfs();
		obj.run();
	}   
}