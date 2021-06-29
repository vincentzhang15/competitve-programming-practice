import java.util.*;
import java.io.*;

public class CodedMessage
{
	static String encode(String line)
	{
		String s = "";
		int c = 5;
		int r = (int)Math.ceil(line.length()/5.0);
		
		char [][] data = new char [r][c];
		
		int index = 0;
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				if(index == line.length())
					break;
				data[i][j] = line.charAt(index);
				index++;
			}
		}
		
		for(int j = 0; j < c; j++)
		{
			for(int i = 0; i < r; i++)
			{
				if(data[i][j] == ' ')
					s += " ";
				else if(data[i][j] != '\u0000')
					s += data[i][j];
				
				if(i == r-1 && j <= 4 && data[i][j] == '\u0000')
					s += " ";
			}
		}
		
		return s;
	}
	
	static String decode(String line)
	{
		String s = "";
		
		for(int i = 0; i < 5-line.length()%5; i++)
			line += " ";

		int c = 5;
		int r = line.length()/5;
		char [][] data = new char [r][c];
		
		int index = 0;
		for(int j = 0; j < c; j++)
		{
			for(int i = 0; i < r; i++)
			{
				if(index == line.length())
					break;
				data[i][j] = line.charAt(index);
				index++;
			}
		}
		
		for(int i = 0; i < r; i++)
		{
			for(int j = 0; j < c; j++)
			{
				if(data[i][j] == ' ')
					s += " ";
				else if(data[i][j] != '\u0000')
					s += data[i][j];
				
				if(i == r-1 && j <= 4 && data[i][j] == '\u0000')
					s += " ";
			}
		}		
		return s;
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 5; i++)
		{
			String command = br.readLine();
			String line = br.readLine();
			System.out.println((command.equals("E"))?(encode(line)):(decode(line)));
		}
	}
}