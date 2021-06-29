import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class j5bfs09
{
	HashSet<Integer> visited = new HashSet<Integer>();
	HashMap<Integer,Node> working = new HashMap<Integer, Node>();
	HashMap<Integer,Node> newelem = new HashMap<Integer, Node>();
	
	class Node
	{
		int id;
		ArrayList<Node> friends = new ArrayList<Node>();
		
		Node(int index)
		{
			id = index;
		}
		Node(Node p, int index)
		{
			id = index;
			friends.add(p);
		}
		void markAsVisited()
		{
			visited.add(id);
		}
		void markAsWorking()
		{
			working.put(id, this);
		}
		void markAsNew()
		{
			newelem.put(id, this);
		}
		
		boolean insertFriend(int idx)
		{
			if(visited.contains(idx))
				return false;
			if(working.containsKey(idx))
				return false;
			if(newelem.containsKey(idx))
				return false;

			Node nd = new Node(this, idx);

			friends.add(nd); // old parent in 2010
			nd.markAsNew();
			//nd.print();
			return true;
		}
		boolean done()
		{
			return id == destination;
		}
		void print()
		{
			System.out.println("  node: id = " + id);
		}
	};
	
	int destination;
	
	int do_it()
	{
		for(int level = 0; working.size() > 0; level++)
		{
			{
				Set set = working.entrySet();
				  
				Iterator itr = set.iterator();
				  
				while(itr.hasNext()) {
					Map.Entry me = (Map.Entry)itr.next();
					Node nd = (Node)me.getValue();
					
					if(nd.done())
					{
						/*
						System.out.println(" ----------- found ---------- ");
						
						for(Node n = nd; n != null; n = n.parent)
						{
							n.print();
						}
						
						System.out.println(" ----------- level = " + nd.level + " ----------------- ");
						return nd.level;
						*/
						System.out.println( level );
						return level;
					}
					
					int n = nd.id;
					
					for(Integer i : ci)
					{
						int x = i % 10000 / 100 ;
						int y = i % 100;
					
						if(n == x)
							nd.insertFriend(y);
						else if( n == y)
							nd.insertFriend(x);
					}
				}
			}

			if(working.size() > 0)
			{
				Set set = working.entrySet();
				Iterator itr = set.iterator();
				
				while(itr.hasNext()) {
					Map.Entry me = (Map.Entry)itr.next();
					Node nd = (Node)me.getValue();
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
					Node nd = (Node)me.getValue();
					nd.markAsWorking();
				}
				newelem.clear();
			}
		}
		return -1;
	}

	ArrayList<Integer> ci = new ArrayList<Integer>();
	//HashMap<Integer, HashSet<Integer> > cd = new HashMap<Integer, HashSet<Integer> >();
	//ArrayList<Integer> cf = new ArrayList<Integer>();
	//ArrayList<Integer> cn = new ArrayList<Integer>();
	//ArrayList<Integer> cs = new ArrayList<Integer>();
	//ArrayList<Integer> show = new ArrayList<Integer>();

	HashSet<Integer> f = new HashSet<Integer>(); // f is the friend list of n
	HashSet<Integer> fall = new HashSet<Integer>(); // f is the friend of friend list of n
	
	void process_n(int n) //  output the number of friends that person x has
	{
		f.clear();
		for(Integer i : ci)
		{
			int x = i / 100 ;
			int y = i % 100;
		
			if(n == x)
			{
				f.add(y);
			}
			else if( n == y)
			{
				f.add(x);
			}
		}
	}

	
	void process_f(int n) //  output the number of "friends of friends" that person x has. Notice that x and direct friends of x are not counted as "friends of friends." 
	{
		fall.clear();
		process_n(n);
		
		for(Integer i : ci)
		{
			int x = i / 100 ;
			int y = i % 100;
		
			if(f.contains(x) )
			{
				if(y == n)
					continue;
				if(f.contains(y))
					continue;
				fall.add(y);
			}
				
			if(f.contains(y) )
			{
				if(x == n)
					continue;
				if(f.contains(x))
					continue;
				fall.add(x);
			}
		}
	}

	void process_s(int x, int y) //  output the degree of separation between x and y. If there is no path from x to y, output Not connected. 
	{
		System.out.print(" s("+x+","+y+")=");
		
		destination = y;
		
		visited.clear();
		working.clear();
		newelem.clear();
			
		Node nd = new Node(x);
			
		nd.markAsWorking();
			
		if(do_it()==-1)
			System.out.println("Not connected.");
			
		//System.out.println("");
	}
	
	void addrelation(int x, int y)
	{
		ci.add(x*100 + y);
	}

	void delrelation(int x, int y)
	{
		for(int i=ci.size()-1; i>=0; i--)
		{
			int n = ci.get(i);
			int xx = n / 100;
			int yy = n % 100;
			if( x == xx && y == yy || x == yy && y == xx)
			{
				ci.remove(i);
			}
		}
	}
	
	void run()
	{
		addrelation(1, 6);
		addrelation(2, 6);
		addrelation(3, 6);
		addrelation(3, 4);
		addrelation(4, 5);
		addrelation(4, 6);
		addrelation(5, 6);
		addrelation(7, 6);
		addrelation(5, 3);
		addrelation(3, 15);
		addrelation(15, 13);
		addrelation(14, 13);
		addrelation(12, 13);

		addrelation(11, 12);
		addrelation(10, 11);
		addrelation(9, 10);
		addrelation(9, 12);
		addrelation(9, 8);
		addrelation(7, 8);


		addrelation(16, 17);
		addrelation(18, 17);
		addrelation(18, 16);
		
		
		Scanner scanner = new Scanner(System.in);

		for(;;)
		{
			String cmd = scanner.next();
			
			if(cmd.equals("i"))
			{
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				addrelation(x, y);
			}
			else if(cmd.equals("d"))
			{
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				delrelation(x,y);
			}
			else if(cmd.equals("n"))
			{
				int x = scanner.nextInt();
				
				process_n(x);
				System.out.println(" n("+x+")="+f.size());
			}
			else if(cmd.equals("f"))
			{
				int x = scanner.nextInt();
				process_f(x);
				System.out.println(" f("+x+")="+fall.size() + "    : " + f + " ; "+ fall);
				
			}
			else if(cmd.equals("s"))
			{
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				process_s(x, y);
			}
			else // if(cmd.equals("q"))
			{
				break;
			}
		}
	}
	
	public static void main(String [] args)
	{
		j5bfs09 obj = new j5bfs09();
		obj.run();
	}   
}