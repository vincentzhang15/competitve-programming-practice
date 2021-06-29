import java.util.*;

public class s3new
{
	HashSet<Integer> visited = new HashSet<Integer>();
	HashMap<Integer,Node> working = new HashMap<Integer, Node>();
	HashMap<Integer,Node> newelem = new HashMap<Integer, Node>();
	
	//int all_fail = 0;
	
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
			visited.add(x*1000+y);
		}
		void markAsWorking()
		{
			working.put(x*1000+y, this);
		}
		void markAsNew()
		{
			newelem.put(x*1000+y, this);
		}
		
		boolean insertMove(int y0, int x0)
		{
			//System.out.println("insertMove " + x0 + " " + y0 + " OK ");
			
			Node nd = new Node(this, x0, y0);

			children.add(nd);
			nd.markAsNew();
			//nd.print();
			return true;
		}
		boolean done()
		{
			return ( x == xe ) && ( y == ye );
		}
		void print()
		{
			System.out.println("  node: " + x + ", " + y);
		}
	};
	char getCellType(int y, int x)
	{
		if(x>0 && x<col-1)
		if(y>0 && y<row-1)
		{
			return map[y][x];
		}
		return 'W';
	}
	
	void  addVisitedNode(Node parent, int y, int x)
	{
		Node nd = new Node(parent, x, y);
		nd.markAsVisited();
	}
	
	void tryMove(Node nd, int y, int x)
	{
		if(x<=0) return;
		if(x>=col-1) return;
		if(y<=0) return;
		if(y>=row-1) return;
			
		Integer signature = x * 1000 + y;
		if(visited.contains(signature))
			return;
		if(working.containsKey(signature))
			return;
		if(newelem.containsKey(signature))
			return;
		
		//System.out.println("tryMove y=" + y + ", x=" + x);
		char t = getCellType(y, x);
		switch(t)
		{
			case 'U': addVisitedNode(nd, y, x); tryMove(nd, y-1, x); break;
			case 'D': addVisitedNode(nd, y, x); tryMove(nd, y+1, x); break;
			case 'L': addVisitedNode(nd, y, x); tryMove(nd, y, x-1); break;
			case 'R': addVisitedNode(nd, y, x); tryMove(nd, y, x+1); break;
			case '.': nd.insertMove(y, x); break;
		}
	}
	
	int do_it()
	{
		while(working.size() > 0)
		{
			/*
			{
				////////// debug only begin
				System.out.println("----------------------------------");
				System.out.println("visited = " + visited);
				{   Iterator itr = visited.iterator();
					while(itr.hasNext()) 
					{ int n = (int)itr.next(); System.out.println(" " + n%10 + ", " + n/10); }
				}
				
				System.out.print("working: "); 
				{Set set = working.entrySet(); Iterator itr = set.iterator();
					while(itr.hasNext()) 
					{ Map.Entry me = (Map.Entry)itr.next(); Node nd = (Node)me.getValue(); System.out.println(" " + nd.x + ", " + nd.y); }
				}
						
				System.out.println("newelem: ");
				{Set set = newelem.entrySet(); Iterator itr = set.iterator();
					while(itr.hasNext()) 
					{ Map.Entry me = (Map.Entry)itr.next(); Node nd = (Node)me.getValue(); System.out.println(" " + nd.x + ", " + nd.y); }
				}
				////////// debug only end
			}
			*/

			
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
						*/
						return nd.level;
					}
					
					tryMove(nd, nd.y-1, nd.x);
					tryMove(nd, nd.y+1, nd.x);
					tryMove(nd, nd.y, nd.x-1);
					tryMove(nd, nd.y, nd.x+1);
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

	void findMinNumberOfSteps(int y, int x)
	{
		int steps  = -1;
		if(map[y][x] == '.')
		{
			xe = x;
			ye = y;
			
			visited.clear();
			working.clear();
			newelem.clear();
				
			Node nd = new Node(xs, ys);
				
			nd.markAsWorking();
				
			steps = do_it();
		}
		System.out.println(" ********************************************* steps = " + steps);
	}
	
	///////
	
	int row, col;
	char [][] map;
	int xs=-1;
	int ys=-1;
	int xe = -1;
	int ye = -1;
	
	void printMap()
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
				System.out.print(map[i][j]);
			System.out.println();
		}
		System.out.println();
	}
	void input()
	{
		Scanner s = new Scanner(System.in);
		row = s.nextInt();
		col = s.nextInt();
		map = new char [row][col];

		for(int i = 0; i < row; i++)
		{
			String r = s.next();
			for(int j = 0; j < col; j++)
			{
				map[i][j] = r.charAt(j);
			}
		}
	}
	void findStartLocation()
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(map[i][j] == 'S')
				{
					xs = j;
					ys = i;
				}
			}
		}
	}

	void markAllCameraSpotableLocation(int i, int j)
	{
		for(int y = i+1; y < row; y++)
		{
			if(map[y][j]=='W')
				break;
			if(map[y][j]=='.')
				map[y][j]='+';
			//if(map[y][j]=='S')				all_fail = 1;
		}
		
		for(int y = i-1; y > 0; y--)
		{
			if(map[y][j]=='W')
				break;
			if(map[y][j]=='.')
				map[y][j]='+';
			//if(map[y][j]=='S')				all_fail = 1;
		}

		for(int x = j+1; x < col; x++)
		{
			if(map[i][x]=='W')
				break;
			if(map[i][x]=='.')
				map[i][x]='+';
			//if(map[i][x]=='S')				all_fail = 1;
		}
		
		for(int x = j-1; x > 0; x--)
		{
			if(map[i][x]=='W')
				break;
			if(map[i][x]=='.')
				map[i][x]='+';
			//if(map[i][x]=='S')				all_fail = 1;
		}
	}
	
	void findCameraCanSeeLocations()
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(map[i][j] == 'C')
				{
					markAllCameraSpotableLocation(i,j);
				}
			}
		}
	}
	
	
	boolean isEmptyLocation(int y, int x)
	{
		if(map[y][x] == '.')
			return true;
		if(map[y][x] == '+')
			return true;
		return false;
	}
	void run()
	{
		input();
		printMap();
		findStartLocation();
		
		System.out.println("");
		findCameraCanSeeLocations();
		printMap();
		
		//if(all_fail==1)		{			System.out.println("All Failed");			return;		}

		System.out.println("");

		
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(isEmptyLocation(i, j))
				{
					findMinNumberOfSteps(i, j);
				}
			}
		}
	}
	public static void main (String [] args)
	{
		s3new obj = new s3new();
		obj.run();
	}
}