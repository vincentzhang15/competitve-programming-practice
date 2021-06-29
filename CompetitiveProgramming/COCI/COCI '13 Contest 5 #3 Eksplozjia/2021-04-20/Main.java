import java.io.*;
import java.util.*;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String s2 = br.readLine();
		
		while(s.indexOf(s2) != -1)
			s = s.replaceAll(s2, "");
		
		if(s.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(s);
	}
}