import java.util.Scanner;
public class j2
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();

		int happy = 0;
		int sad = 0;
		for(int i = 0; i+2 < sentence.length(); i++)
		{
			if(sentence.charAt(i) == ':')
				if(sentence.charAt(i+1) == '-')
					if(sentence.charAt(i+2) == ')')
						happy += 1;
					else if(sentence.charAt(i+2) == '(')
						sad += 1;
		}
		if(happy > sad)
			System.out.println("happy");
		else if(sad > happy)
			System.out.println("sad");
		else if(sad == 0 && happy == 0)
			System.out.println("none");
		else
			System.out.println("unsure");
	}
}