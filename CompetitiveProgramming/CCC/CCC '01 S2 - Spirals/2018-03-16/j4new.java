/*
	down x 1
	right x 1
	up x 2
	left x 2
	
	down x 3
	right x 3
	up x 4
	left x 4
*/

import java.util.*;

public class j4new
{
	int [][] p;
	int start = 0;
	int end = 0;
	int dim = 0;
	int x = 0;
	int y = 0;
	int dir = 3;

	void moveAStep(int v)
	{
		p[x][y] = v;
		
		int d1 = dir -1;
		if(d1 < 0)
			d1 = 3;
		
		for(int k = 0; k<2; k ++)
		{
			int x1 = x;
			int y1 = y;
			switch(d1)
			{
				case 0: y1 --; break;
				case 1: x1 ++; break;
				case 2: y1 ++; break;
				case 3: x1 --; break;
			}
			//System.out.print("   ( " + x + ", " + y + " ) dir = " + dir + "  -->  ( " + x1 + ", " + y1 + " ) d1 = " + d1);
			if(p[x1][y1] == 0)
			{
				x = x1; 
				y = y1;
				dir = d1;
				//System.out.println("     <-- OK");
				return;
			}
			//System.out.println("");
			d1 = dir;
		}
	}
	
	void run()
	{
		Scanner s = new Scanner(System.in);
		start = s.nextInt();
		end = s.nextInt();
		
		/*
		for(int i = start; i <= end; i++)
		{
			System.out.print(i + " ");
		}
		System.out.println("");
		*/
		
		dim = 1;
		for(;; dim++)
		{
			int capacity = dim * dim;
			if(capacity > end - start)
				break;
		}
		dim += 2;
		p = new int[dim][dim];
		for(int i=0; i<dim; i++)
			for(int j=0; j<dim; j++)
				p[i][j] = 0;

		x = dim / 2;
		y = dim / 2;
		
		for(int v = start; v<=end; v++)
		{
			moveAStep(v);
		}
		
		System.out.println("");
		System.out.println("");

		int xs = 0; 
		int xe = dim - 1;
		int ys = 0;
		int ye = dim - 1;
		
		for(int j = 0; j < dim; j++) // row
		{
			int sum = 0;
			for(int i = 0; i < dim; i++) // column
				sum += p[i][j];
				
			if(sum != 0)
				break;
			ys = j+1;
		}
		
		for(int j = dim-1; j > 0; j--) // row
		{
			int sum = 0;
			for(int i = 0; i < dim; i++) // column
				sum += p[i][j];
				
			if(sum != 0)
				break;
			ye = j-1;
		}
		
		for(int i = 0; i < dim; i++) // column
		{
			int sum = 0;
			for(int j = 0; j < dim; j++) // row
				sum += p[i][j];
				
			if(sum != 0)
				break;
			xs = i+1;
		}
		
		for(int i = dim-1; i >0; i--) // column
		{
			int sum = 0;
			for(int j = 0; j < dim; j++) // row
				sum += p[i][j];
				
			if(sum != 0)
				break;
			xe = i-1;
		}
		
		for(int j = ys; j <= ye; j++) // row
		{
			for(int i = xs; i <= xe; i++) // column
			{
				if(p[i][j] == 0)
					System.out.print("   ");
				else
				{
					String str = String.format("%2d ", p[i][j]);
					System.out.print(str);
				}
			}
			System.out.println();
		}
	}
	
	public static void main (String [] args)
	{
		j4new j = new j4new();
		j.run();
	}
}