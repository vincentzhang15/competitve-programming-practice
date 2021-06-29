import java.util.*;

public class j1
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int sDay = s.nextInt();
		int nDay = s.nextInt();
		
		System.out.println("Sun Mon Tue Wed Thr Fri Sat");
		switch(sDay)
		{
			case 2: System.out.print("    "); break;
			case 3: System.out.print("        "); break;
			case 4: System.out.print("            "); break;
			case 5: System.out.print("                "); break;
			case 6: System.out.print("                    "); break;
			case 7: System.out.print("                        "); break;
		}
		for(int i = 1; i <= nDay; i++)
		{
			if(i < 10)
				System.out.print("  " + i + " ");
			else
				System.out.print(" " + i + " ");
			if((i + sDay - 1) % 7 == 0)
				System.out.println();
		}
	}
}