import java.util.*;
public class j3
{
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int cpink = sc.nextInt();
		int cgreen = sc.nextInt();
		int cred = sc.nextInt();
		int corange = sc.nextInt();
		int total = sc.nextInt();
		
		int count = 0;
		int min = Integer.MAX_VALUE;
		for(int pink = 0; pink <= total; pink++)
		{
			for(int green = 0; green <= total; green++)
			{
				for(int red = 0; red <= total; red++)
				{
					for(int orange = 0; orange <= total; orange++)
					{
						if(pink * cpink + green * cgreen + red * cred + orange * corange == total)
						{
							count ++;
							System.out.println("# of PINK is " + pink + "    # of GREEN is " + green + "    # of RED is " + red + "    # of ORANGE is " + orange);

							if(pink + green + red + orange < min)
								min = pink + green + red + orange;	
						}
					}
				}
			}
		}
		System.out.println("Total combinations is " + count + ".");
		System.out.println("Minimum number of tickets to print is " + min + ".");
	}
}