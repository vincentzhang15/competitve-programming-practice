import java.util.Scanner;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;
import java.util.Iterator;




public class Main
{
	boolean _debug = true;
	//boolean _debug = false;
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
		
		Page parent = null;
		
		Page(int pn, String line)
		{
			pagenumber = pn;
			String[] strs = line.trim().split("\\s+");

			for (int i = 0; i < strs.length; i++) {
				int n = Integer.parseInt(strs[i]);
				if(i==0)
					continue;
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
			
			nd.markAsNew();
			nd.parent = this;
			//nd.print();
			return true;
		}
		
		boolean done()
		{
			if(jumps.size()==0)
			{
				//finished = true;
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
	int finished = 0;
	
	int do_it()
	{
		while(working.size() > 0)
		{
			{
				Set set = working.entrySet();
				  
				Iterator itr = set.iterator();
				  
				if(_debug)
					System.out.println(" === sz = "+ working.size());
				while(itr.hasNext()) {
					Map.Entry me = (Map.Entry)itr.next();
					Page nd = (Page)me.getValue();
					
				if(_debug)
					System.out.println(" working:  "+ nd.pagenumber);
				
					if(nd.done())
					{
						if(finished == 0)
						{
							int nn = 0;
							if(_debug)
								System.out.println(" ----------- found ---------- ");
						
							for(Page n = nd; n != null; n = n.parent)
							{
								if(_debug)
									n.print();
								nn++;
							}
							
							if(_debug)
								System.out.println(" ----------- level = " + nd.level + " ----------------- ");
						
							finished = nn; //nd.level;
						}
						//System.out.println("Y");
						//System.out.println(nd.level);
						
						//return nd.level;
					}
					
					for(int i=0;i<nd.jumps.size(); i++)
					{
						int num = nd.jumps.get(i);
						if(num!=0)
						{
							Page nextpage = all.get(num);
							if(nextpage != null)
							{
								nd.insertNew(num, nextpage);
								nextpage.level = nd.level + 1;
							}
						}
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
		finished = 0;
		do_it();
		if(_debug)
			System.out.println("v " + visited.size() + " a "+ all.size());
		if(visited.size() < all.size()+1)
			System.out.println("N");
		else
		{
			System.out.println("Y");
			System.out.println(finished);
		}
		
		//System.out.println("");
		
	}
	
	public static void main(String [] args)
	{
		Main obj = new Main();
		obj.run();
	}   
}