import java.util.*;

public class j5bfs
{
	HashSet<Integer> visited = new HashSet<Integer>();
	HashMap<Integer,Node> working = new HashMap<Integer, Node>();
	HashMap<Integer,Node> newelem = new HashMap<Integer, Node>();
	
	class Node
	{
		int x;
		int y;
		int level;

		ArrayList<Node> children = new ArrayList<Node>();
		
		Node parent = null;
		
		Node(int x0, int y0)
		{
			level = 0;
			x = x0;
			y = y0;
		}
		Node(Node p, int x0, int y0)
		{
			parent = p;
			level = parent.level + 1;
			x = x0;
			y = y0;
		}
		void markAsVisited()
		{
			visited.add(x*10+y);
		}
		void markAsWorking()
		{
			working.put(x*10+y, this);
		}
		void markAsNew()
		{
			newelem.put(x*10+y, this);
		}
		boolean insertMove(int x0, int y0)
		{
			if(x0<=0) return false;
			if(x0>8) return false;
			if(y0<=0) return false;
			if(y0>8) return false;
			
			Integer signature = x0 * 10 + y0;
			if(visited.contains(signature))
				return false;
			if(working.containsKey(signature))
				return false;
			if(newelem.containsKey(signature))
				return false;
			
			Node nd = new Node(this, x0, y0);
			children.add(nd);
			nd.markAsNew();
			return true;
		}
		boolean done()
		{
			return x * 10 + y == destination;
		}
	}
	int destination;
	int do_it()
	{
		while(working.size() > 0)
		{
			{
				Set set = working.entrySet();
				  
				Iterator itr = set.iterator();
				  
				while(itr.hasNext()) {
					Map.Entry me = (Map.Entry)itr.next();
					Node nd = (Node)me.getValue();
					
					if(nd.done())
					{
						System.out.println(nd.level);
						return nd.level;
					}

					nd.insertMove(nd.x+1, nd.y+2);
					nd.insertMove(nd.x-1, nd.y+2);
					nd.insertMove(nd.x+1, nd.y-2);
					nd.insertMove(nd.x-1, nd.y-2);
					
					nd.insertMove(nd.x+2, nd.y+1);
					nd.insertMove(nd.x-2, nd.y+1);
					nd.insertMove(nd.x+2, nd.y-1);
					nd.insertMove(nd.x-2, nd.y-1);
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

	void run()
	{
		Scanner scanner = new Scanner(System.in);

		int x0 = scanner.nextInt();
		int y0 = scanner.nextInt();
		int xe = scanner.nextInt();
		int ye = scanner.nextInt();
		
		destination = xe * 10 + ye;
		
		visited.clear();
		working.clear();
		newelem.clear();
			
		Node nd = new Node(x0, y0);
			
		nd.markAsWorking();
			
		if(do_it()==-1)
			System.out.println("IMPOSSIBLE");
			
		System.out.println("");
	}
	
	public static void main(String [] args)
	{
		j5bfs obj = new j5bfs();
		obj.run();
	}   
}