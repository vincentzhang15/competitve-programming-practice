import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CountYears
{
	static boolean checkString(String s)
	{
		boolean [] list = new boolean [10];
		for(int j = 0; j < s.length(); j++)
		{
			//System.out.println((list[(int)(s.charAt(j) - '0')]) + ":" + ((int)(s.charAt(j) - '0')));
			if(!list[(int)(s.charAt(j) - '0')])
				list[(int)(s.charAt(j) - '0')] = true;
			else
				return false;
		}
		return true;
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = n+1;;i++)
		{
			String s = Integer.toString(i);
			if(checkString(s))
			{
				System.out.println(i);
				return;
			}
		}
	}
}