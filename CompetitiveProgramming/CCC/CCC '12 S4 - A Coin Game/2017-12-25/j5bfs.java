import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;


public class j5bfs
{
	HashSet<String> signatures = new HashSet<String>();
	
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
		void save()
		{
			signatures.add(signature);
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
		void insertMove(int position, int direction, Node p)
		{
			Node nd = new Node(this, move, position, direction);
			/*
			for(Node pa = p; pa != null; pa = pa.parent)
			{
				if(nd.sameWith(p.move))
					return;
			}
			*/
			nd.updateSignature();
			if(signatures.contains(nd.signature))
				return;
			
			children.add(nd);
			nd.save();
			//nd.print();
			//return children.get(children.size() - 1);
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
			finished = true;
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
	boolean finished = false;
	
	int do_it(Node nd)
	{
		//System.out.print(" -- "); nd.print();
		
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
		for(int i=0; i<nd.children.size(); i++)
		{
			int ret = do_it(nd.children.get(i));
			if(ret > 0)
				return ret;
		}
		
		/*
			System.out.print(" inside do_it       coins: ");
			for(int i=0; i<nd.move.length; i++)
				System.out.print(" " + nd.move[i]);
			System.out.println("");
		*/
		
		return 0;
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

			Node nd = new Node(ncoins);
			
			for(int i=0; i<ncoins; i++)
			{
				nd.move[i] = scanner.next();
			}
			nd.updateSignature();
			nd.save();
			
			System.out.print("        coins: ");
			for(int i=0; i<nd.move.length; i++)
				System.out.print(" " + nd.move[i]);
			System.out.println("");

			finished = false;
			do_it(nd);
			if( finished == false )
				System.out.println("IMPOSSIBLE");
			
			System.out.println("");
		}
	}
	
	public static void main(String [] args)
	{
		j5bfs obj = new j5bfs();
		obj.run();
	}   
}