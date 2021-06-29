import java.util.Scanner;
public class j5
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

	int move (int a1, int b1, int c1, int d1)
	{
		for(int i = 0;; i++)
		{
			if(a1 > 0 && b1 > 0 && c1 > 0 && d1 > 0)
			{
				move(a1 - 2, b1 - 1, c1 - 0, d1 - 2);//, step + 1);
				j++;
//				System.out.println(step);          );//
				move(a1 - 1, b1 - 1, c1 - 1, d1 - 1);//, step + 1);
				j++;
//				System.out.println(step);          );//
				move(a1 - 0, b1 - 0, c1 - 2, d1 - 1);//, step + 1);
				j++;
//				System.out.println(step);          );//
				move(a1 - 0, b1 - 3, c1 - 0, d1 - 0);//, step + 1);
				j++;
//				System.out.println(step);          );//
				move(a1 - 1, b1 - 0, c1 - 0, d1 - 1);//, step + 1);
				j++;
//				System.out.println(step);
			}
			return j;
		}
	}
	
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int rounds = scanner.nextInt();
		
		int [] a = new int [rounds];
		int [] b = new int [rounds];
		int [] c = new int [rounds];
		int [] d = new int [rounds];

		for(int i = 0; i < rounds; i++)
		{
			a[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
			c[i] = scanner.nextInt();
			d[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < rounds; i++)
			System.out.println("a: " + a[i]);
		
		for(int i = 0; i < rounds; i++)
			System.out.println("b: " + b[i]);
		
		for(int i = 0; i < rounds; i++)
			System.out.println("c: " + c[i]);
		
		for(int i = 0; i < rounds; i++)
			System.out.println("d: " + d[i]);
	}
}