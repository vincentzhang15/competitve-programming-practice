import java.util.*;

public class j5_1
{
	HashSet<String> black = new HashSet<String>();
	HashMap<String,Node> grey = new HashMap<String, Node>();
	HashMap<String,Node> white = new HashMap<String, Node>();	

	class Node
	{
		String signature;
		int level;
		String [] configuration;
		Node parent = null;
		ArrayList<Node> children = new ArrayList<Node>();

		Node(int coins)
		{
			configuration = new String[coins];
			level = 0;
		}
		Node(Node p, int position, int direction)
		{
			parent = p;
			level = parent.level+1;
			
			configuration = new String [p.configuration.length];
			for(int i=0; i< p.configuration.length; i++)
			{
				if(i == position) 
				{
					if(direction == 1) //  right
					{
						configuration[i] = p.configuration[i].substring(0, p.configuration[i].length() - 1);
					}
					else if(direction == 2) //  left
					{
						configuration[i] = p.configuration[i] + p.configuration[i+1].charAt(p.configuration[i+1].length() - 1);
					}
				}
				else if(i == position + 1)
				{
					if(direction == 1) //  right
					{
						configuration[i] = p.configuration[i] + p.configuration[i-1].charAt(p.configuration[i-1].length() - 1);
					}
					else if(direction == 2) //  left
					{
						configuration[i] = p.configuration[i].substring(0, p.configuration[i].length() - 1);
					}
				}
				else
				{
					configuration[i] = p.configuration[i];
				}
			}	
		}
		void updateSignature()
		{
			signature = "";
			for(int i=0; i<configuration.length-1; i++)
			{
				signature += configuration[i];
				signature += ",";
			}
		}		
		void markAsblack()
		{
			black.add(signature);
		}
		void markAsgrey()
		{
			grey.put(signature, this);
		}
		void markAsNew()
		{
			white.put(signature, this);
		}		
		
		boolean insertconfiguration(int position, int direction)
		{
			Node node = new Node(this, position, direction);
			
			node.updateSignature();
			if(black.contains(node.signature))
				return false;
			if(grey.containsKey(node.signature))
				return false;
			if(white.containsKey(node.signature))
				return false;
			
			children.add(node);
			node.markAsNew();
			//node.print();
			return true;
		}
		boolean done()
		{
			for(int i=0; i<configuration.length-1; i++)
			{
				if(configuration[i].length() != 1)
					return false;
				if(configuration[i+1].length() != 1)
					return false;
				if(configuration[i].charAt(0) > configuration[i+1].charAt(0))
					return false;
			}
			return true;
		}
	}
	int work()
	{
		while(grey.size() > 0)
		{
			Set set = grey.entrySet();
			  
			Iterator itr = set.iterator();
			  
			while(itr.hasNext()) {
				Map.Entry me = (Map.Entry)itr.next();
				Node node = (Node)me.getValue();
				
					if(node.done())
					{
						System.out.println(node.level);
						return node.level;
					}
					
					for(int i=0;i<node.configuration.length-1; i++)
					{
//						System.out.println("i: " + i + "  configuration: " + node.configuration.length+",["+ node.configuration[i+1]+"]");

						int l1 = node.configuration[i].length();
						int l2 = node.configuration[i+1].length();
						
						
						//  right
						if(   l1 > 0 && l2 == 0
							|| l1 > 0 && l2 >0 && node.configuration[i].charAt(l1-1) < node.configuration[i+1].charAt(l2-1)
							)
						{
							node.insertconfiguration(i, 1); // 1 stand for right
						}
						
						//  left
						
						if(  l1 == 0 && l2 > 0 
							||  l1 > 0 && l2 > 0 && node.configuration[i].charAt(l1-1) > node.configuration[i+1].charAt(l2-1)
							)
						{
							node.insertconfiguration(i, 2); // 2 stand for left
						}
					}
				}
			if(grey.size() > 0)
			{
				set = grey.entrySet();
				itr = set.iterator();
				
				while(itr.hasNext()) {
					Map.Entry me = (Map.Entry)itr.next();
					Node node = (Node)me.getValue();
					node.markAsblack();
					itr.remove();
				}
			}
			if(white.size() > 0)
			{
				set = white.entrySet();
				itr = set.iterator();
				
				while(itr.hasNext()) {
					Map.Entry me = (Map.Entry)itr.next();
					Node node = (Node)me.getValue();
					node.markAsgrey();
				}
				white.clear();
			}
		}
		return -1;
	}
	void run()
	{
		Scanner scanner = new Scanner(System.in);
		for (int j = 0;;j++)
		{
			int coins = scanner.nextInt();
			
			if(coins<1)
				return;

			black.clear();
			grey.clear();
			white.clear();
			Node node = new Node(coins);
			
			String [] configuration = new String [coins];
			for(int i = 0; i < coins; i++)
			{
				node.configuration [i] = scanner.next();
			}
			node.updateSignature();
			node.markAsgrey();		
			
//			System.out.print("        coins: ");
//			for(int i=0; i<node.configuration.length; i++)
//				System.out.print(" " + node.configuration[i]);
//			System.out.println("");

			if(work()==-1)
				System.out.println("IMPOSSIBLE");
			
		}
	}
	public static void main(String [] args)
	{
		j5_1 obj = new j5_1();
		obj.run();
	}
}