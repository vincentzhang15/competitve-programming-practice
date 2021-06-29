import java.util.*;
public class j5
{
	int row;
	int col;
	int nMoves;
	String [] moves;
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
		String [] moves = new String [nMoves];
		for(int i = 0; i < nMoves; i++)
			moves [i] = sc.next();	
	}
	void testPrint()
	{
		//print
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
				System.out.print(initialPos[i][j]);
			System.out.println();
		}
		for(int i = 1; i < nMoves; i++)
			System.out.println("........" + moves[i]);
		//end print
	}
	void doInstruction()
	{
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				for(int d = 0; d < 4; d++)
				{
					for(int loop = 0; loop < moves[].size; loop++)
					if(d = 0)
				}
			}
		}		
	}
	void run()
	{
		collectInput();
		testPrint();
		doInstruction();
	}
	public static void main(String [] args)
	{
		j5 obj = new j5();
		obj.run();
	}
}