import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BetterCensor
{
	static boolean isChar(char c)
	{
		if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
			return true;
		return false;
	}
	
	public static void main(String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			int count = 0;
			String line = br.readLine() + " ";
			String newStr = "";
			for(int j = 0; j < line.length(); j++)
			{
				newStr += line.charAt(j);
				if(isChar(line.charAt(j)))
					count++;
				else
					count = 0;
				if(count == 4)
				{
					if(!isChar(line.charAt(j+1)))
					{
						newStr = newStr.substring(0, j-4+1) + "****";
					}
				}
			}
			System.out.println(newStr);
		}
	}
}