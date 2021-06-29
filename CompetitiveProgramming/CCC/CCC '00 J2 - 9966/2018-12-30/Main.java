import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	static boolean isDigit (char c)
	{
		switch (c)
		{
			case '0': return true;
			case '1': return true;
			case '8': return true;
			default: return false;
		}
	}
	
	static boolean isOdd (int i, String check)
	{
		if(isDigit(check.charAt(check.length()/2)))
			return true;
		return false;
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int start = Integer.parseInt(br.readLine());
		int end = Integer.parseInt(br.readLine());
		
		boolean isValid = false;
		int count = 0;
		for(int i=start; i<=end; i++)
		{
			String check = Integer.toString(i);
			for(int j=0; j<check.length()/2; j++)
			{
				if(check.charAt(j) == check.charAt(check.length()-1-j))
				{
					if(isDigit(check.charAt(j)))
					{
						////////////////////////////////
						if(check.length() % 2 != 0)
							if(!isOdd(i, check))
							{
								//System.out.println(i + ":" + !isOdd(i, check));
								isValid = false;
								break;
							}
						isValid = true;
						//System.out.println(count + ":" + i + ":" + j + ":" + (check.length()-1-j));
						////////////////////////////////
					}
					else
					{
						isValid = false;
						break;
					}
				}
				else if((check.charAt(j) == '6' && check.charAt(check.length()-1-j) == '9') || (check.charAt(j) == '9' && check.charAt(check.length()-1-j) == '6'))
				{
					if(check.length() % 2 != 0)
						if(!isOdd(i, check))
						{
							//System.out.println(i + ":" + !isOdd(i, check));
							isValid = false;
							break;
						}
					isValid = true;
					//System.out.println(count + ":" + i + ":" + j + ":" + (check.length()-1-j));
				}
				else
				{
					isValid = false;
					break;
				}
			}
			if(isValid)
				count++;
		}
		if(start <= 1 && end >= 1)
			count++;
		if(start <= 8 && end >= 8)
			count++;
		System.out.println(count);
	}
}