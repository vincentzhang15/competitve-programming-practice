import java.util.*;

public class j4	
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		String one = sc.nextLine();
		String two = sc.nextLine();

		ArrayList<Character> one1 = new ArrayList<Character>();
		ArrayList<Character> two1 = new ArrayList<Character>();

		for(int i = 0; i < one.length(); i++)
		{
			if(one.charAt(i) != ' ')
				one1.add(one.charAt(i));
		}
		for(int i = 0; i < two.length(); i++)
		{
			if(two.charAt(i) != ' ')
				two1.add(two.charAt(i));
		}
		
		Collections.sort(one1, new Comparator<Character>(){
			public int compare(Character o1, Character o2){
				return o1 - o2;
			}
		});
		Collections.sort(two1, new Comparator<Character>(){
			public int compare(Character o1, Character o2){
				return o1 - o2;
			}
		});

		int size = 0;
		if(one1.size() > two1.size())
			size = one1.size();
		else
			size = two1.size();
		for(int i = 0; i < size; i++)
		{
			if(one1.get(i) != two1.get(i))
			{
				System.out.println("Is not an anagram");
				return;
			}
		}
		System.out.println("Is an anagram");
	}
}