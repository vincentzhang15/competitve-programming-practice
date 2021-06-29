import java.util.*;

public class s3
{
	int row, col;
	String [] r;
	char [][] map;

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
		r = new String [row];
		map = new char [row][col];

		for(int i = 0; i < row; i++)
			r[i] = s.next();
		
		for(int i = 0; i < row; i++)
		for(int j = 0; j < col; j++)
			map[i][j] = r[i].charAt(j);
	}
	int location()
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(map[i][j] == '.')
				{
					map[i][j] = '_';
					System.out.println("(" + (i+1) + "," + (j+1) + ")");
					int num = i*100 + j;
					System.out.println(num);
					return num;
				}
			}
		}
		return -1;
	}
	void run()
	{
		input();
		printMap();
		for(int i = 0; i < (row + col) ; i++)
		{
			System.out.println("run: "+location());
			if(location() == -1)
			{
				System.out.println("Break");
				break;
			}
			//int x = location() / 100;
			//int y = location() % 100;
			//System.out.println("(" + x + "," + y + ")");
		}
	//	printMap();
	}
	public static void main (String [] args)
	{
		s3 obj = new s3();
		obj.run();
	}
}