import java.util.*;
public class j5new
{
	int row;
	int col;
	int nMoves;
	char [] moves;
	char[][] initialPos;

	void collectInput()
	{
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();

		String[] input = new String[row];
		initialPos = new char[row][col];
		for(int i = 0; i < row; i++)
			input[i] = sc.next();
		
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				initialPos[i][j] = input[i].charAt(j);

		nMoves = sc.nextInt();
		moves = new char [nMoves];
		for(int i = 0; i < nMoves; i++)
			moves [i] = sc.next().charAt(0);	
	}
	void testPrint(String comment)
	{
		System.out.println(comment);
		//print
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
				System.out.print(initialPos[i][j]);
			System.out.println();
		}
		//end print
	}
	void printMoves()
	{
		System.out.println("");
		System.out.print("........");
		for(int i=0; i<moves.length; i++)
		{
			System.out.print(" " + moves[i]);
		}
		System.out.println("");
		System.out.println("");
	}
	
	int next(int x, int y, int dir)
	{
		switch(dir)
		{
			case 0: y--; break;
			case 1: x++; break;
			case 2: y++; break;
			case 3: x--; break;
		}
		
		if(y<0) return -1;
		if(x<0) return -1;
		if(y>=row) return -1;
		if(x>=col) return -1;

		if(initialPos[y][x] == 'X')
			return -1;

		return y * 1000 + x;
	}
	
	int turnLeft(int dir)
	{
		dir --;
		if(dir < 0)
			dir = 3;
		return dir;
	}
	int turnRight(int dir)
	{
		dir ++;
		if(dir > 3)
			dir = 0;
		return dir;
	}
	
	void doInstruction()
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(initialPos[i][j] == 'X')
					continue;
				for(int d = 0; d < 4; d++)
				{
					int dir = d;
					int x = j;
					int y = i;
					boolean fail = false;
					System.out.println(" .... (" + i + ", " + j + ") dir = " + dir);
					for(int loop = 0; loop < moves.length && !fail; loop++)
					{
						switch(moves[loop])
						{
							case 'F': 
								int ret = next(x, y, dir); 
								if(ret < 0)
								{
									fail = true;
									break;
								}
								x = ret % 1000; 
								y = ret / 1000; 
								break;
							case 'L':
								dir = turnLeft(dir);
								break;
							case 'R':
								dir = turnRight(dir);
								break;
						}
						System.out.println(" .. " + moves[loop] + " (" + y + ", " + x + ") dir= " + dir + " fail= " + fail);
					}
					
					if(!fail)
					{
						initialPos[y][x] = '*';
						testPrint(" move " + i + " " + j + " " + d);
					}
				}
			}
		}		
	}
	void run()
	{
		collectInput();
		testPrint("Init");
		printMoves();
		doInstruction();
		testPrint("Final");
	}
	public static void main(String [] args)
	{
		j5new obj = new j5new();
		obj.run();
	}
}