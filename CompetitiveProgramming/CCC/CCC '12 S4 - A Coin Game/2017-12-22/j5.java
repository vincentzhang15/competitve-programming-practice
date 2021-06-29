import java.util.Scanner;

public class j5
{
	int count = 1;
	void run()
	{
		System.out.print("Enter number of discs: ");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			int numberofdisks = scanner.nextInt();
			caluculate(numberofdisks, 'A', 'B', 'C');
	
			if(numberofdisks == 0)
				return;
		System.out.println(count);

		}
		
	}
	void caluculate(int disks, char from, char middle, char to)
	{
		if (disks == 1)
		{
			System.out.println("1");
		}
		else
		{
			caluculate(disks - 1, from, to, middle);
			count++;
//         System.out.println("Disk " + disks + " from " + from + " to " + to);
			caluculate(disks - 1, middle, from, to);
		}
	}
	public static void main(String [] args)
	{
		j5 obj = new j5();
		obj.run();
	}   
}