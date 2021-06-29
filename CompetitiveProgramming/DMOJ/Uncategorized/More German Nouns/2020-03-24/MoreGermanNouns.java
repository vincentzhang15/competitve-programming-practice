import java.util.*;
import java.io.*;

public class MoreGermanNouns
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		int n = Integer.parseInt(br.readLine());
		
		PrintStream out = new PrintStream(System.out, true, "UTF-8");
		
		for(int i = 0; i < n; i++)
		{
			String [] s = br.readLine().split(" ");
			for(String str : s)
			{
				String temp = "";
				for(int j = 0; j < str.length(); j++)
				{
					if(Character.isLetter(str.charAt(j)))
					{
						if(temp.equals(""))
							if(!Character.isUpperCase(str.charAt(j)))
								break;
						out.print(str.charAt(j));
						temp += str.charAt(j);
					}
				}
				if(!temp.equals(""))
					out.println();
			}
		}
	}
}