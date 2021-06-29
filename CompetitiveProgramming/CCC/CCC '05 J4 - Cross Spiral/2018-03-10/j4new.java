import java.util.*;

public class j4new
{
	static int boardw = 0;
	static int boardh = 0;
	static int [][] tile;
	// dir: 0: up; 1: right; 2: down; 3: left;
	
	static int find_next_location(int x, int y, int dir)
	{
		//mark current location as visited
		tile[x][y] = 1;
		
		for(int k = 0; k < 3; k ++)
		{
			int d = k - 1 + dir ;
			if(d < 0) d += 4;
			if(d > 3) d -= 4;
			
			int px = 0;
			int py = 0;
			switch(d)
			{
				case 0: px = x;     py = y - 1; break;
				case 1: px = x + 1; py = y;     break;
				case 2: px = x;     py = y + 1; break;
				case 3: px = x -1 ; py = y;     break;
			}
			if(py<0 || py>=boardh)
				continue;
			if(px<0 || px>=boardw)
				continue;
			
			System.out.println(" k=" + k + "    ( "+x+" , "+y+" , "+dir+" ) " +"    ( "+px+" , "+py+" , "+d+" ) " );
			if(tile[px][py] == 0) // the new location found which has not been visited yet and not a wall
			{
				dir = d;
				x = px; 
				y = py;
				return d * 10000 + x * 100 + y;
			}
		}
		return 0;
	}
	
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		boardw = sc.nextInt();
		boardh = sc.nextInt();
		int cutoutw = sc.nextInt();
		int cutouth = sc.nextInt();
		int steps = sc.nextInt();
		
		tile = new int[boardw][boardh];
		
		for(int i=0;i<boardw;i++)
		{
			for(int j=0;j<boardh;j++)
			{
				if(i < cutoutw && (j < cutouth || j >= boardh-cutouth) )
					tile[i][j]=9;
				else if(i >= boardw - cutoutw && (j < cutouth || j >= boardh-cutouth) )
					tile[i][j]=9;
				else
					tile[i][j]=0;
			}
		}

		int x=0, y=0;
		for(int i=0;i<boardw;i++)
		{
			if(tile[i][0] == 0)
			{
				x = i; y = 0; break; // the start location
			}
		}
		
		int count = 0;
		int dir = 1;
		
		for(int i=0; i< steps; i++)
		{
			int ret = find_next_location(x, y, dir);
			if( 0 == ret)
			{
				// no more tile not visited arround the current location;
				break;
			}
			dir = ret / 10000;
			x = ret / 100 % 100;
			y = ret % 100;
		}
		System.out.println(x+1);
		System.out.println(y+1);
	}
}
