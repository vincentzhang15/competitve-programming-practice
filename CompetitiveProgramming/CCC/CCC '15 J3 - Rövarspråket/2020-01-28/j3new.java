import java.util.*;
public class j3new
{
	boolean isVowel(char c)
	{
		switch(c)
		{
			case 'a': 
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				return true;
		}
		return false;
	}
	
	char nearestVowel(char c)
	{
		int x=0;
		int y=0;
		char c1 = 0;
		char c2 = 0;
		for(char i=c; i>='a'; i--)
		{
			if(isVowel(i))
			{
				c1 = i;
				break;
			}
			x++;
		}
		if(c1 == 0)
			x = 100;
		
		for(char j=c; j<='u'; j++)
		{
			if(isVowel(j))
			{
				c2 = j;
				break;
			}
			y++;
		}
		if(c2 == 0)
			y = 100;
		System.out.println(" -- "+ x+ ", "+ c1+ ", "+ y+ ", "+ c2);
		if(x<y)
			return c1;
		return c2;
	}
	
	void run()
	{
		Scanner sc = new Scanner(System.in);
		String word = sc.next();

		String output = "";
		
		for(int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			output += c;
			if(isVowel(c))
				continue;
			
			char v = nearestVowel(c);
			output += v;
			if(c=='z')
				output += 'z';
			else if(isVowel((char)(c+1)))
				output += (char)(c+2);
			else
				output += (char)(c+1);
		}
		System.out.println(output);
	}
	public static void main (String [] args)
	{
		j3new obj = new j3new();
		obj.run();
	}
	
}