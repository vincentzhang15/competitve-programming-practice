import java.util.*;
import java.io.*;

public class ABC
{
	public static void main (String [] args)
	{
		ArrayList<Integer> data = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 3; i++)
			data.add(sc.nextInt());
		Collections.sort(data);
		String line = sc.next();
		for(int i = 0; i < line.length(); i++)
		{
			switch(line.charAt(i))
			{
				case 'A':
					System.out.print(data.get(0) + " ");
					break;
				case 'B':
					System.out.print(data.get(1) + " ");
					break;
				case 'C':
					System.out.print(data.get(2) + " ");
					break;
			}
		}
	}
}