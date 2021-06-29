import java.util.*;

public class j4
{
	static String [] commands;
	static int [] number;

	static void calculate(int current)
	{
		int runNumber = current;
		System.out.println("-----------Entered: " + runNumber);
		
		int waitTime = -1;
		boolean foundR = false;
		for(int i = 0; i < commands.length; i++)
		{
			if(number[i] == current)
			{
				if(!commands[i].equals("W"))
				{
					if(commands[i].equals("R"))
						foundR = true;
					else
					{
						System.out.println(current + " " + waitTime);
						return;
					}
				}
			}
			if(foundR)
			{
				if(commands[i].equals("W"))
					waitTime += number[i];
				else
					waitTime ++;
			}
		}
	}
	
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int messages = scanner.nextInt();
		commands = new String [messages];
		number = new int [messages];
		TreeSet<Integer> toDo = new TreeSet<Integer>();
		
		for(int i = 0; i < messages; i++)
		{
			commands[i] = scanner.next();
			number[i] = scanner.nextInt();
			if(!commands[i].equals("W"))
				toDo.add(number[i]);
		}
		
		Iterator<Integer> it = toDo.iterator();
		Integer current = 0;

		while(it.hasNext())
		{
			current = it.next();
			System.out.println("   Current: " + current);
			calculate(current);
		}
			
		/////printing
		System.out.println();
		System.out.println("--------------PRINTING------------");
		System.out.println(messages);
		for(int i = 0; i < messages; i++)
		{
			System.out.print(commands[i] + " ");
			System.out.println(number[i]);
		}
		System.out.println(toDo);
		System.out.println("--------------PRINTING------------");
		/////printing
	}
}