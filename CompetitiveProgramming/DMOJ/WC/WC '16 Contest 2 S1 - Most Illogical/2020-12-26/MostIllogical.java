import java.util.*;
import java.io.*;

public class MostIllogical
{
	static String calc(String line, String s, String l, String value)
	{
		int start = line.indexOf(s);
		int length = l.length();
		return (line.substring(0, start) + value + line.substring(start + length));
	}

	static String calcC(String line, String s, String l, String value)
	{
		int start = line.indexOf(s)-2;
		int length = l.length();
		return (line.substring(0, start) + value + line.substring(start + length));
	}
	
	static String find(String line)
	{
		if(line.indexOf("0 and") != -1)
			return find(calc(line, "0 and", "0 and 0", "0"));
		else if(line.indexOf("and 0") != -1)
			return find(calcC(line, "and 0", "0 and 0", "0"));
		else if(line.indexOf("1 and 2") != -1)
			return find(calc(line, "1 and 2", "1 and 2", "2"));
		else if(line.indexOf("2 and 1") != -1)
			return find(calc(line, "2 and 1", "2 and 1", "2"));
		else if(line.indexOf("2 and 2") != -1)
			return find(calc(line, "2 and 2", "2 and 2", "2"));
		else if(line.indexOf("1 or") != -1)
			return find(calc(line, "1 or", "1 or 0", "1"));
		else if(line.indexOf("or 1") != -1)
			return find(calcC(line, "or 1", "1 or 0", "1"));
		else if(line.indexOf("2 or 2") != -1)
			return find(calc(line, "2 or 2", "2 or 2", "2"));
		else if(line.indexOf("0 or 2") != -1)
			return find(calc(line, "0 or 2", "0 or 2", "2"));
		else if(line.indexOf("2 or 0") != -1)
			return find(calc(line, "2 or 0", "0 or 2", "2"));
		else if(line.indexOf("0 or 0") != -1)
			return find(calc(line, "0 or 0", "0 or 0", "0"));
		else if(line.indexOf("1 and 1") != -1)
			return find(calc(line, "1 and 1", "1 and 1", "1"));
		return line;
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		String [] line = br.readLine().split(" ");
		String s = "";
		for(String i : line)
		{
			if(i.equals("true"))
				s += "1 ";
			else if(i.equals("false"))
				s += "0 ";
			else if(i.equals("unknown"))
				s += "2 ";
			else
				s += i + " ";
		}
		s = find(s).trim();
		if(s.equals("0"))
			System.out.println("false");
		else if(s.equals("1"))
			System.out.println("true");
		else
			System.out.println("unknown");
	}
}
