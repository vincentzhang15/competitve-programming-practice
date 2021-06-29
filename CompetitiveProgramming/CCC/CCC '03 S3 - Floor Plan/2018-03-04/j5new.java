import java.util.*;

public class j5new
{
	ArrayList [] ln;
	int row = 0;
	int col = 0;
	int flooring = 0;
	
	void read_input_data()
	{
		Scanner in = new Scanner (System.in);
		flooring = in.nextInt();
		row = in.nextInt();
		col = in.nextInt();
		
		ln = new ArrayList[row];
		for(int i=0;i<row;i++)
		{
			ln[i] = new ArrayList();
			String str = in.next();
			for(int j=0; j<col; j++)
			{
				if(str.charAt(j) == 'I')
					ln[i].add(9);
				else
					ln[i].add(0);
			}
		}
	}

	void debug_print(String info)
	{
		System.out.println(info);
		// debug begin
		for(int i=0;i<row;i++)
		{
			for(int j=0; j<col; j++)
			{
				int n = (int)ln[i].get(j);
				if(n == 0)
					System.out.print(".");
				else if( n==1)
					System.out.print("-");
				else
					System.out.print("I");
			}
			System.out.println("");
		}
		// debug end
	}
	
	int find_empty_space()
	{
		for(int i=0;i<row;i++)
		{
			for(int j=0; j<col; j++)
			{
				int n = (int)ln[i].get(j);
				if(n == 0)
				{
					return i * 100 + j;
				}
			}
		}
		return -1;
	}
	
	boolean isEmpty(int x, int y)
	{
		if( ((int)ln[x].get(y)) == 0)
			return true;
		return false;
	}
	
	int visit(int area, int x, int y)
	{
		ln[x].set(y, 1);
		area ++;
		//debug_print(" " +area);
		
		if(isEmpty(x+1, y)) area = visit(area, x+1, y);
		if(isEmpty(x-1, y)) area = visit(area, x-1, y);
		if(isEmpty(x, y+1)) area = visit(area, x, y+1);
		if(isEmpty(x, y-1)) area = visit(area, x, y-1);
		return area;
	}
	ArrayList rooms = new ArrayList();
	
	void identify_rooms()
	{
		for(int n = find_empty_space(); n>=0; n = find_empty_space())
		{
			int r = n/100;
			int c = n%100;
			int area = visit(0, r, c);
			rooms.add(area);
			
			System.out.println("room : " + area);
		}
		
		Collections.sort(rooms, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		
		System.out.println(rooms);
		
		int i = 0;
		for(i = 0; i < rooms.size(); i++)
		{
			if(flooring - (int)rooms.get(i) < 0)
				break;
			flooring -= (int)rooms.get(i);
		}
		System.out.println(i + " rooms, " + flooring + " square metre(s) left over");
	}
	
	void run()
	{
		read_input_data();
		debug_print("after read data");
		identify_rooms();
	}
	
	public static void main (String [] args)
	{
		j5new j = new j5new();
		j.run();
	}
}