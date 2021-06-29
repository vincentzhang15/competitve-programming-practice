import java.util.*;

public class j5new
{
	static boolean isAWord(String w)
	{
		if(w.equals("A"))
			return true;
		if(w.length() >= 3)
		{
			if(w.charAt(0) == 'B' && w.charAt(w.length()-1) == 'S')
			{
				String mid = w.substring(1, w.length()-1);
				if(isMonkeyWord(mid))
					return true;
			}
		}
		return false;
	}

	static boolean isMonkeyWord(String w)
	{
		if(isAWord(w))
			return true;
		
		if(w.length() >= 3)
		{
			for(int i=1; i<w.length()-1; i++)
			{
				if(w.charAt(i) == 'N')
				{
					String pre  = w.substring(0, i);
					String post = w.substring(i+1);
					if(isAWord(pre) && isMonkeyWord(post))
						return true;
				}
			}
		}
		return false;
	}

	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		String word = "";
		boolean monkey = true;
		while(true)
		{
			word = sc.next();
			if(word.equals("X"))
				return;

			System.out.print("................." + word + "                          " );
			if(isMonkeyWord(word))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}

