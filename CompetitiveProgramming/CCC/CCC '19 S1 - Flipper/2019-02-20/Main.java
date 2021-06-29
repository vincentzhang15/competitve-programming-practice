import java.util.*;
import java.io.*;

public class Main
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		String line = s.next();
		int v = 0;
		int h = 0;
		
		for(int i = 0; i < line.length(); i++)
		{
			if(line.charAt(i)=='V')
				v+=1;
			else
				h+=1;
		}
		int vMod = v % 2;
		int hMod = h % 2;
		if(vMod == 0 && hMod == 0)
			System.out.println("1 2\n3 4");
		if(vMod == 1 && hMod == 0)
			System.out.println("2 1\n4 3");
		if(vMod == 0 && hMod == 1)
			System.out.println("3 4\n1 2");
		if(vMod == 1 && hMod == 1)
			System.out.println("4 3\n2 1");
	}
}