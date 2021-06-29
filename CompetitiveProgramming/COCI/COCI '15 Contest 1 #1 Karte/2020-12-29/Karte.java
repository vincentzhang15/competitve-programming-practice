import java.util.*;
import java.io.*;

public class Karte
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		boolean [] p = new boolean [13];
		boolean [] k = new boolean [13];
		boolean [] h = new boolean [13];
		boolean [] t = new boolean [13];
		for(int i = 0; i < line.length(); i+=3)
		{
			switch(line.charAt(i))
			{
				case 'P':
					if(p[Integer.parseInt(line.charAt(i+1) + "" + line.charAt(i+2))-1])
					{
						System.out.println("GRESKA");
						System.exit(0);
					}
					p[Integer.parseInt(line.charAt(i+1) + "" + line.charAt(i+2))-1] = true;
					break;
				case 'K':
					if(k[Integer.parseInt(line.charAt(i+1) + "" + line.charAt(i+2))-1])
					{
						System.out.println("GRESKA");
						System.exit(0);
					}
					k[Integer.parseInt(line.charAt(i+1) + "" + line.charAt(i+2))-1] = true;
					break;
				case 'H':
					if(h[Integer.parseInt(line.charAt(i+1) + "" + line.charAt(i+2))-1])
					{
						System.out.println("GRESKA");
						System.exit(0);
					}
					h[Integer.parseInt(line.charAt(i+1) + "" + line.charAt(i+2))-1] = true;
					break;
				case 'T':
					if(t[Integer.parseInt(line.charAt(i+1) + "" + line.charAt(i+2))-1])
					{
						System.out.println("GRESKA");
						System.exit(0);
					}
					t[Integer.parseInt(line.charAt(i+1) + "" + line.charAt(i+2))-1] = true;
					break;
			}
		}
		int count = 0;
		for(boolean b : p)
			if(b)
				count++;
		System.out.print(13-count + " ");

		count = 0;
		for(boolean b : k)
			if(b)
				count++;
		System.out.print(13-count + " ");

		count = 0;
		for(boolean b : h)
			if(b)
				count++;
		System.out.print(13-count + " ");

		count = 0;
		for(boolean b : t)
			if(b)
				count++;
		System.out.println(13-count);

	}
}