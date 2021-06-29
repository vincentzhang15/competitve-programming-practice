import java.util.*;



public class Main
{
	static final long F = 1000000;
	
	class Flight // or portal
	{
		int p1, p2; // planet;
		int c1, c2; // city 1, city 2
		int cost;
		Flight(int planet1, int city1, int planet2, int city2, int energy)
		{
			p1 = planet1;
			p2 = planet2;
			c1 = city1;
			c2 = city2;
			cost = energy;
		}
		long signature(int id)
		{
			if(id == 1)
				return p1 * F + c1;
			else
				return p2 * F + c2;
		}
		void print()
		{
			//System.out.println("  node: id = " + id);
		}
	};

	ArrayList<Flight> flights = new ArrayList<Flight>();

	int	remove_flights_from_and_to_same_city()
	{
		int saved = 0;
		for(int i = flights.size()-1; i >= 0; i--)
		{
			if(flights.get(i).c1 == flights.get(i).c2)
			{
				saved += flights.get(i).cost;
				flights.remove(i);
			}
		}
		return saved;
	}
	int	remove_duplicated_flights()
	{
		int saved = 0;
		for(int i=0; i< flights.size(); i++)
		{
			while(i<flights.size())
			{
				boolean changed = false;
				for(int j=i+1; j<flights.size(); j++)
				{
					if( ( flights.get(i).c1 == flights.get(j).c1 && flights.get(i).c2 == flights.get(j).c2) 
						|| ( flights.get(i).c1 == flights.get(j).c2 && flights.get(i).c2 == flights.get(j).c1) )
					{
						if(flights.get(i).cost > flights.get(j).cost )
						{
							saved += flights.get(i).cost;
							flights.remove(i);
							changed = true;
						}
						else
						{
							saved += flights.get(j).cost;
							flights.remove(j);
							changed = true;
						}
					}
				}
				if(!changed)
					break;
			}
		}
		return saved;
	}
	
	TreeSet<Integer> flightInLoop = new TreeSet<Integer> flightInLoop;
	TreeSet<Integer> flightVisited = new TreeSet<Integer> flightVisited;
	
	boolean same_city(int fn1, int i1, int fn2, int i2)
	{
		Flight f1 = flights.get(fn1);
		Flight f2 = flights.get(fn2);
		
		int p1 = (i1 == 1) ? f1.p1 : f1.p2;
		int p2 = (i2 == 1) ? f2.p1 : f2.p2;
		int c1 = (i1 == 1) ? f1.c1 : f1.c2;
		int c2 = (i2 == 1) ? f2.c1 : f2.c2;
		
		return (p1 == p2) && (c1 == c2);
	}

	boolean get_same_city(int fn1, int fn2, int id[2])
	{
		if(same_city(fn1, 1, fn2, 1))
		{
			id[0] = 1;
			id[1] = 1;
			return true;
		}
		if(same_city(fn1, 1, fn2, 2))
		{
			id[0] = 1;
			id[1] = 2;
			return true;
		}
		if(same_city(fn1, 2, fn2, 1))
		{
			id[0] = 2;
			id[1] = 1;
			return true;
		}
		if(same_city(fn1, 2, fn2, 2))
		{
			id[0] = 2;
			id[1] = 2;
			return true;
		}
		return false;
	}

	int	remove_highest_cost_flight_or_portal_in_a_loop()
	{
		int saved = 0;
		boolean deleted = false;
		
		do
		{
			deleted = false;
		
			flightVisited.clear();
			long start;
			long end;

			do
			{
				flightInLoop.clear();
				
				// find 2 flight visit same city;
				
				for(int i = 0; i < flights.size(); i+)
				{
					boolean found = false;
					for(int j = i + 1; j < flights.size(); j++)
					{
						int id[2];
						if( get_same_city(i, j, id) )
						{
							start = flights[i].signature(3-id[0]);
							end   = flights[j].signature(3-id[1]);
							
							flightInLoop.add(i);
							flightInLoop.add(j);
							found = true;
						}
						if(found)
							break;
					}
					if(found)
						break;
				}
				
				if(flightInLoop.size() == 0) // impossible
					return saved;
				
				//////////////////////
				
				boolean loopFound = false;
				boolean flightFound = false;

				do
				{
					flightFound = false;
					
					for(int i = 0; i < flights.size(); i+)
					{
						if(flightVisited.contains(i))
						{
							continue;
						}
						if(flightInLoop.contains(i))
						{
							continue;
						}
						
						long c1 = flights[i].signature(1);
						long c2 = flights[i].signature(2);
							
						if(c1 == start)
						{
							flightInLoop.add(i);
							loopFound = true;
							break;
						}
						else if(c2 == start)
						{
							flightInLoop.add(i);
							loopFound = true;
							break;
						}
						else if(c1 == end)
						{
							flightInLoop.add(i);
							end = c2;
							flightFound = true;
						}
						else if(c2 == end)
						{
							flightInLoop.add(i);
							end = c1;
							flightFound = true;
						}
						else
						{
							flightVisited.add(i);
						}
					}
				} while(flightFound);
				
			}
			while(!loopFound)

							

			if(loopFound)
			{
				int max_id = -1;
				int max_cost = 0;
				
				 for(Integer f:flightInLoop)
				 {
					 if(max_cost < flights[f].cost)
					 {
						 max_cost = flights[f].cost;
						 max_id = f;
					 }
				 }
				 if(max_cost > 0)
				 {
					flights.remove(max_id);
					saved += max_cost;
					deleted = true;
				 }
			}
		} while(deleted == true);
		
		return saved;
	}
	
	void run()
	{
		Scanner s = new Scanner(System.in);
		int N_planets = s.nextInt();
		int M_cities = s.nextInt();
		int P_flights = s.nextInt();
		int Q_portals = s.nextInt();
		
		for(int i = 0; i < P_flights; i++)
		{
			int city1 = s.nextInt();
			int city2 = s.nextInt();
			int energy = s.nextInt();
			flights.add(new Flight(1, city1, 1, city2, energy));
		}

		int total_saved = 0;
		total_saved += remove_flights_from_and_to_same_city();
		total_saved += remove_duplicated_flights();
		
		total_saved *= N_planets;
		
		int number_of_flights_on_a_planet = flights.size();
		for(int j = 2; j <= N_planets; j ++)
		{
			for(int i=0;i<number_of_flights_on_a_planet; i++)
			{
				flights.add(new Flight(j, flights.get(i).c1, j, flights.get(i).c2, flights.get(i).cost));
			}
		}

		for(int i = 0; i < Q_portals; i++)
		{
			int planet1 = s.nextInt();
			int planet2 = s.nextInt();
			int energy = s.nextInt();
			
			for(int j = 1; j <= M_cities; j ++)
			{
				flights.add(new Flight(planet1, j, planet2, j, energy));
			}
		}
		
		total_saved += remove_highest_cost_flight_or_portal_in_a_loop();
		
		System.out.println(total_saved);
	}
	
	public static void main(String [] args)
	{
		Main obj = new Main();
		obj.run();
	}   
}	
/*
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
						/ *
						System.out.println(" ----------- found ---------- ");
						
						for(Node n = nd; n != null; n = n.parent)
						{
							n.print();
						}
						
						System.out.println(" ----------- level = " + nd.level + " ----------------- ");
						return nd.level;
						* /
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
	
	
*/