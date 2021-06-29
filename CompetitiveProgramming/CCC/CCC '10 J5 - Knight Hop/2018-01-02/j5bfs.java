import java.util.*;

public class j5bfs
{
	HashSet<String> visited = new HashSet<String>();
	HashMap<String,Node> working = new HashMap<String, Node>();
	HashMap<String,Node> newelem = new HashMap<String, Node>();

	int x1;
	int y1;	
	int x2;	
	int y2;
	int finalcordinatesnumber;
	
	int scord;		
	int ecord;	

	class Node
	{
		String signature;
		int level;
		int [] move;
		
		ArrayList<Node> children = new ArrayList<Node>();
		
		Node parent = null;
		
		Node(int ncoins)
		{
			move = new String[ncoins];
			level = 0;
		}
		Node(Node p, int [] m, int position, int direction)
		{
			Node nd = new Node(ncoins);
			parent = p;
			level = parent.level + 1;
			move = new String[m.length];
			for(int i=0; i< m.length; i++)
			{
				//1
				if(x1 + 1 <= 8 && y1 + 2 <= 8)
				{
					nd.finalcordinatesnumber = (((m[i] / 10) + 1)*10) + ((m[i] % 10) + 2);
					children.add(nd.finalcordinatesnumber);
				}
				//4
				if(x1 + 1 <= 8 && y1 - 2 > 0)
				{
					children.add((((m[i] / 10) + 1)*10) + ((m[i] % 10) - 2));
				}
				//8
				if(x1 - 1 > 0 && y1 + 2 <= 8)
				{
					children.add((((m[i] / 10) - 1)*10) + ((m[i] % 10) + 2));
				}				
				//5
				if(x1 - 1 > 0 && y1 - 2 > 0)
				{
					children.add((((m[i] / 10) - 1)*10) + ((m[i] % 10) - 2));
				}				
				//2
				if(x1 + 2 <= 8 && y1 + 1 <= 8)
				{
					children.add((((m[i] / 10) + 2)*10) + ((m[i] % 10) + 1));
				}				
				//3
				if(x1 + 2 <= 8 && y1 - 1 > 0)
				{
					children.add((((m[i] / 10) + 2)*10) + ((m[i] % 10) - 1));
				}				
				//7
				if(x1 - 2 > 0 && y1 + 1 <= 8)
				{
					children.add((((m[i] / 10) - 2)*10) + ((m[i] % 10) + 1));
				}				
				//6
				if(x1 - 2 > 0 && y1 - 1 > 0)
				{
					children.add((((m[i] / 10) - 2)*10) + ((m[i] % 10) - 1));
				}
/*
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
				}*/
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
			//nd.print();
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
		void print()
		{
			System.out.print("  node: ");
			for(int i=0; i<move.length; i++)
			{
				System.out.print(" " + move[i]);
				if(move[i].length()==0)
				{
					System.out.print("_");
				}
			}
			
			System.out.println("");
		}
	};
	
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
						System.out.println(" ----------- found ---------- ");
						
						for(Node n = nd; n != null; n = n.parent)
						{
							n.print();
						}
						
						System.out.println(" ----------- level = " + nd.level + " ----------------- ");
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
		
		x1 = scanner.nextInt();
		y1 = scanner.nextInt();
		x2  = scanner.nextInt();
		y2 = scanner.nextInt();
		
		scord = (x1 * 10) + y1;
		ecord = (x2 * 10) + y2;

		System.out.println(scord);
		System.out.println(ecord);
/*
		Scanner scanner = new Scanner(System.in);
		for(int k=0;;k++)
		{
			int ncoins = scanner.nextInt();
			
			if(ncoins < 1)
				return;

			System.out.println("Case " + (k + 1) + ":");
			System.out.println("        ncoins = " + ncoins);

			visited.clear();
			working.clear();
			newelem.clear();
			
			Node nd = new Node(ncoins);
			
			for(int i=0; i<ncoins; i++)
			{
				nd.move[i] = scanner.next();
			}
			nd.updateSignature();
			nd.markAsWorking();
			
			System.out.print("        coins: ");
			for(int i=0; i<nd.move.length; i++)
				System.out.print(" " + nd.move[i]);
			System.out.println("");

			if(do_it()==-1)
				System.out.println("IMPOSSIBLE");
			
			System.out.println("");

		}*/
	}
	
	public static void main(String [] args)
	{
		j5bfs obj = new j5bfs();
		obj.run();
	}   
}