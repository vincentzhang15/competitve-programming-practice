import java.util.*;

public class j3
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		ArrayList data = new ArrayList();
		for(int i = 0; i < 11; i++)
		{
			String transfer = sc.next();
			if(transfer.equals("SCHOOL"))
				break;
			data.add(transfer);
		}
		for(int i = data.size() - 1; i >= 0; i--)
		{
			if(data.get(i).equals("L"))
				System.out.print("Turn RIGHT ");
			else if(data.get(i).equals("R"))
				System.out.print("Turn LEFT ");
			else
				System.out.println("onto " + data.get(i) + " street.");
			if(i == 0)
				System.out.println("into your HOME.");
		}
	}
}