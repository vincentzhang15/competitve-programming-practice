import java.util.*;

public class j2
{
	static ArrayList<String> songs = new ArrayList<String>();
	static void print()
	{
		for(int q = 0; q < songs.size(); q++)
		{
			System.out.print(songs.get(q) + " ");
		}
			System.out.println();
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int b = 0;
		int n = 0;
		
		songs.add("A");
		songs.add("B");
		songs.add("C");
		songs.add("D");
		songs.add("E");

		print();
		while(b != 4 && n != 1)
		{
			System.out.println("Button number: ");
			b = sc.nextInt();
			System.out.println("Number of presses: ");
			n = sc.nextInt();
			
			if(b == 1)
			{
				for(int i = 0; i < n; i++)
				{
					print();
					String transfer = songs.get(0);
					songs.remove(0);
					print();
				}
			}
			else if(b == 2)
			{
				for(int i = 0; i < n; i++)
				{
					print();
					String transfer1 = songs.get(0);
					String transfer2 = songs.get(1);
					String transfer3 = songs.get(2);
					String transfer4 = songs.get(3);
					String transfer5 = songs.get(4);
					songs.clear();
					print();
					songs.add(transfer5);
					songs.add(transfer1);
					songs.add(transfer2);
					songs.add(transfer3);
					songs.add(transfer4);
					print();
				}
			}
			else if(b == 3)
			{
				for(int i = 0; i < n; i++)
				{
					print();
					String transfer1 = songs.get(0);
					String transfer2 = songs.get(1);
					String transfer3 = songs.get(2);
					String transfer4 = songs.get(3);
					String transfer5 = songs.get(4);
					songs.clear();
					print();
					songs.add(transfer2);
					songs.add(transfer1);
					songs.add(transfer3);
					songs.add(transfer4);
					songs.add(transfer5);
					print();
				}
			}
		}
		for(int i = 0; i < songs.size(); i++)
		{
			System.out.print(songs.get(i) + " ");
		}
			System.out.println();
	}
}