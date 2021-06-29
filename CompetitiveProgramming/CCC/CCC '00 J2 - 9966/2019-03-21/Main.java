import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	static boolean flippable (int j)
	{
		String num = Integer.toString(j);
		for(int i = 0; i < num.length(); i++)
		{
			switch (num.charAt(i))
			{
				case '1': if(num.charAt(num.length()-1-i) != '1') return false; break;
				case '8': if(num.charAt(num.length()-1-i) != '8') return false; break;
				case '0': if(num.charAt(num.length()-1-i) != '0') return false; break;
				case '6': if(num.charAt(num.length()-1-i) != '9') return false; break;
				case '9': if(num.charAt(num.length()-1-i) != '6') return false; break;
				default: return false;
			}
		}
		return true;
	}
	
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int lower = Integer.parseInt(br.readLine());
		int higher = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int i = lower; i <= higher; i++)
			if(flippable(i))
				count++;
		System.out.println(count);
	}
}