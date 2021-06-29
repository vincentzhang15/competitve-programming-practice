import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class j5
{
	//black
	HashSet<String> visited = new HashSet<String>();
	//grey
	HashMap<String,Node> working = new HashMap<String, Node>();
	//white
	HashMap<String,Node> newelem = new HashMap<String, Node>();
	
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
		Node(Node p, int position, int direction)
		{
			parent = p;
			level = parent.level + 1;
			move = new String[p.move.length];
			for(int i=0; i< p.move.length; i++)
			{
				if(i == position) 
				{
					if(direction == 1) // move right
					{
						move[i] = p.move[i].substring(0, p.move[i].length() - 1);
					}
					else if(direction == 2) // move left
					{
						move[i] = p.move[i] + p.move[i+1].charAt(p.move[i+1].length() - 1);
					}
				}
				else if(i == position + 1)
				{
					if(direction == 1) // move right
					{
						move[i] = p.move[i] + p.move[i-1].charAt(p.move[i-1].length() - 1);
					}
					else if(direction == 2) // move left
					{
						move[i] = p.move[i].substring(0, p.move[i].length() - 1);
					}
				}
				else
				{
					move[i] = p.move[i];
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
		
		boolean insertMove(int position, int direction)
		{
			Node nd = new Node(this, position, direction);
			
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
							nd.insertMove(i, 1); // 1 stand for move right
						}
						
						// move left
						
						if(  l1 == 0 && l2 > 0 
							||  l1 > 0 && l2 > 0 && nd.move[i].charAt(l1-1) > nd.move[i+1].charAt(l2-1)
							)
						{
							nd.insertMove(i, 2); // 2 stand for move left
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
		}
	}
	
	public static void main(String [] args)
	{
		j5 obj = new j5();
		obj.run();
	}   
}