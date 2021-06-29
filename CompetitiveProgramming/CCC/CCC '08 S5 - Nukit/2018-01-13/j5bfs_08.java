import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class j5bfs_08
{
	HashSet<String> visited = new HashSet<String>();
	HashMap<String,Node> working = new HashMap<String, Node>();
	HashMap<String,Node> newelem = new HashMap<String, Node>();
	
	class Node
	{
		String signature;
		int level;
		int a;
		int b;
		int c;
		int d;
		int reaction; 
		
		ArrayList<Node> children = new ArrayList<Node>();
		
		Node parent = null;
		
		Node()
		{
			level = 0;
			a = b = c = d = 0;
			reaction = 0;
		}
		Node(Node p, int aa, int bb, int cc, int dd, int r)
		{
			parent = p;
			level = parent.level + 1;
			a = aa;
			b = bb;
			c = cc;
			d = dd;
			reaction = r;
		}
		void updateSignature()
		{
			signature = "" + a + ", " + b + ", " + c + ", " + d;
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
		
		int insertMove(int aa, int bb, int cc, int dd, int r)
		{
			Node nd = new Node(this, aa, bb, cc, dd, r);
			
			nd.updateSignature();
			if(visited.contains(nd.signature))
				return 0;
			if(working.containsKey(nd.signature))
				return 0;
			if(newelem.containsKey(nd.signature))
				return 0;
			
			children.add(nd);
			nd.markAsNew();
			//nd.print("");
			return 1;
		}
			/*
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
			*/
		void print(String prefix)
		{
			System.out.print(prefix);
			System.out.println("  node: ( " + a + ", " + b + ", " + c + ", " + d + " ),  l= " + level + " r=" + reaction);
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
					
					/*
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
					*/
					
					nd.print(" do_it: ");
					boolean finished = true;
					
					if(nd.a >=2 && nd.b >=1 && nd.d >=2) // AABDD
					{
						nd.insertMove(nd.a-2, nd.b-1, nd.c, nd.d-2, 1);
						//System.out.println(" 1    insert = "+ inserted);
						finished = false;
					}
					if(nd.a >=1 && nd.b >=1 && nd.c >=1 && nd.d >=1) // ABCD
					{
						nd.insertMove(nd.a-1, nd.b-1, nd.c-1, nd.d-1, 2);
						//System.out.println(" 2    insert = "+ inserted);
						finished = false;
					}
					if(nd.c >=2 && nd.d >=1) // CCD
					{
						nd.insertMove(nd.a, nd.b, nd.c-2, nd.d-1, 3);
						//System.out.println(" 3    insert = "+ inserted);
						finished = false;
					}
					if(nd.b >=3) // BBB
					{
						nd.insertMove(nd.a, nd.b-3, nd.c, nd.d, 4);
						//System.out.println(" 4    insert = "+ inserted);
						finished = false;
					}
					if(nd.a >=1 && nd.d >=1) // AD
					{
						nd.insertMove(nd.a-1, nd.b, nd.c, nd.d-1, 5);
						//System.out.println(" 5    insert = "+ inserted);
						finished = false;
					}
					
					if(finished)
					{
						System.out.println(" ----------- found ---------- ");
						
						for(Node n = nd; n != null; n = n.parent)
						{
							n.print("");
						}
						
						if(nd.level % 2 == 0)
						{
							System.out.println(" ----------- level = " + nd.level + " ----------------- Roland");
						}
						else
						{
							System.out.println(" ----------- level = " + nd.level + " ----------------- Patrick");
						}
						return nd.level;
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
		int ncases = scanner.nextInt();
		
		for(int k=0;k<ncases;k++)
		{
			Node nd = new Node();
			nd.a = scanner.nextInt();
			nd.b = scanner.nextInt();
			nd.c = scanner.nextInt();
			nd.d = scanner.nextInt();
			
			System.out.println("Case " + (k + 1) + ":");
			nd.print("");
			
			visited.clear();
			working.clear();
			newelem.clear();
			
			nd.updateSignature();
			nd.markAsWorking();

			do_it();
			
			System.out.println("");
		}
	}
	
	public static void main(String [] args)
	{
		j5bfs_08 obj = new j5bfs_08();
		obj.run();
	}   
}