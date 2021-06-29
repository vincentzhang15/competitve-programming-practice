import java.util.*;

public class j5
{
	TreeSet<String> visited = new TreeSet<String>();
	TreeMap<String,Node> working = new TreeMap<String, Node>();
	TreeMap<String,Node> newelem = new TreeMap<String, Node>();
	
	class Node
	{
		String signature;
		int level;
		String [] move;
		
		ArrayList<Node> children = new ArrayList<Node>();
		
		Node parent = null;
		
		Node(int ncoins)
		{
			move = new String[ncoins];
			level = 0;
		}
		Node(Node p, String [] m, int position, int direction)
		{
			parent = p;
			level = parent.level + 1;
			move = new String[m.length];
			for(int i=0; i< m.length; i++)
			{
				if(i == position) 
				{
					if(direction == 1) // move right
					{
						move[i] = m[i].substring(0, m[i].length() - 1);
					}
					else if(direction == 2) // move left
					{
						move[i] = m[i] + m[i+1].charAt(m[i+1].length() - 1);
					}
				}
				else if(i == position + 1)
				{
					if(direction == 1) // move right
					{
						move[i] = m[i] + m[i-1].charAt(m[i-1].length() - 1);
					}
					else if(direction == 2) // move left
					{
						move[i] = m[i].substring(0, m[i].length() - 1);
					}
				}
				else
				{
					move[i] = m[i];
				}
			}
		}
		void updateSignature()
		{
			signature = "";
			for(int i=0; i<move.length-1; i++)
			{
				signature += move[i];
				signature += ",";
			}
		}
		void markAsVisited()
		{
			visited.add(signature);
		}
		void markAsWorking()
		{
			working.put(signature, this);
		}
		void markAsNew()
		{
			newelem.put(signature, this);
		}
		
		boolean sameWith(String [] m)
		{
			for(int i=0; i< m.length; i++)
			{
				if(!move[i].equals(m[i]))
					return false;
			}
			return true;
		}
		boolean insertMove(int position, int direction, Node p)
		{
			Node nd = new Node(this, move, position, direction);
			
			nd.updateSignature();
			if(visited.contains(nd.signature))
				return false;
			if(working.containsKey(nd.signature))
				return false;
			if(newelem.containsKey(nd.signature))
				return false;
			
			children.add(nd);
			nd.markAsNew();
			return true;
		}
		boolean done()
		{
			for(int i=0; i<move.length-1; i++)
			{
				if(move[i].length() != 1)
					return false;
				if(move[i+1].length() != 1)
					return false;
				if(move[i].charAt(0) > move[i+1].charAt(0))
					return false;
			}
			return true;
		}
	};

	int process()
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
					
					for(int i=0;i<nd.move.length-1; i++)
					{
						int l1 = nd.move[i].length();
						int l2 = nd.move[i+1].length();
						
						// move right
						if(   l1 > 0 && l2 == 0
							|| l1 > 0 && l2 >0 && nd.move[i].charAt(l1-1) < nd.move[i+1].charAt(l2-1)
							)
						{
							nd.insertMove(i, 1, nd.parent); // 1 stand for move right
						}
						
						// move left
						
						if(  l1 == 0 && l2 > 0 
							||  l1 > 0 && l2 > 0 && nd.move[i].charAt(l1-1) > nd.move[i+1].charAt(l2-1)
							)
						{
							nd.insertMove(i, 2, nd.parent); // 2 stand for move left
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
		for(int i=0;;i++)
		{
			int ncoins = scanner.nextInt();
			
			if(ncoins < 1)
				return;

			visited.clear();
			working.clear();
			newelem.clear();
			
			Node nd = new Node(ncoins);
			
			for(int j=0; j<ncoins; j++)
			{
				nd.move[j] = scanner.next();
			}
			nd.updateSignature();
			nd.markAsWorking();
			
			if(process()==-1)
				System.out.println("IMPOSSIBLE");
			
			System.out.println("");
		}
	}
	public static void main (String [] args)
	{
		j5 obj = new j5();
		obj.run();
	}		
}