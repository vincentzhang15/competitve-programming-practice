import java.util.*;

public class Main
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
		Scanner scanner = new Scanner(System.in);
		String pages = scanner.nextInt();

		for(int i = 0; i < pages; i++)
		{
		}
	}
	
	public static void main(String [] args)
	{
		Main obj = new Main();
		obj.run();
	}   
}