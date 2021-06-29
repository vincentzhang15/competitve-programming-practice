import java.util.*;
import java.io.*;

public class TicTacMoe
{
	static boolean [][] data;
	static TreeSet<Boolean> t;
	static void has()
	{
		for(int i = 0; i < 3; i++)
			if(data[i][0] == data[i][1] && data[i][1] == data[i][2])
				t.add(data[i][0]);
		for(int i = 0; i < 3; i++)
			if(data[0][i] == data[1][i] && data[1][i] == data[2][i])
				t.add(data[0][i]);
		if(data[0][0] == data[1][1] && data[1][1] == data[2][2])
			t.add(data[0][0]);
		if(data[0][2] == data[1][1] && data[1][1] == data[2][0])
			t.add(data[1][1]);
	}
	
	public static void main (String [] args) throws IOException
	{
		data = new boolean [3][3];
		t = new TreeSet<Boolean>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 3; i++)
		{
			String line = br.readLine();
			for(int j = 0; j < 3; j++)
			{
				if(line.charAt(j) == 'O')
					data[i][j] = false;
				else
					data[i][j] = true;
			}
		}
		
		has();
		if(t.size() == 2)
			System.out.println("Error, redo");
		else if(t.contains(false))
			System.out.println("Griffy");
		else if(t.contains(true))
			System.out.println("Timothy");
		else
			System.out.println("Tie");
	}
}