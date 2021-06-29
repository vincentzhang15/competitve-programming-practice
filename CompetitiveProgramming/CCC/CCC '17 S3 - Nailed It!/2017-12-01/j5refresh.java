import java.util.Scanner;

public class j5refresh
{
	public static void main(String [] args)
	{		
		Scanner in = new Scanner(System.in);
		int loopnumber = in.nextInt();

		int fbasenumber;
		int sbasenumber;
		
		int faddnumber;
		int saddnumber;
		
		int count = 0;
		int a = 0;
		int[] listofnumbers = new int[loopnumber + 1];

		if(loopnumber == 2)
		{
			System.out.println("1 1");
		}
		else
		{
			for(int i = 0; i < loopnumber; i++)
			{				
				listofnumbers[i] = in.nextInt();
			}
		}
		
		while(a < listofnumbers.length)
		{
			fbasenumber = listofnumbers[a];
System.out.println("First 111: " + fbasenumber);
			for(int b = 0; b < listofnumbers.length; b++)
			{
				if(listofnumbers[b] == listofnumbers[a])
				{
					b++;

					sbasenumber = listofnumbers[b];								
System.out.println(sbasenumber + "   . . . ..");
				}
				else
				{
					sbasenumber = listofnumbers[b];	
				}						
				for(int c = 1; c < listofnumbers.length; c++)
				{
					if(listofnumbers[c] == listofnumbers[a] || listofnumbers[c] == listofnumbers[b])
					{
						c++;
						faddnumber = listofnumbers[c];
System.out.println("c: " + faddnumber);						
					}
					else
					{
						faddnumber = listofnumbers[c];		
System.out.println("Third 2222: " + faddnumber);						
					}
						for(int d = 2; d < listofnumbers.length; d++)
						{
							if(listofnumbers[d] == listofnumbers[a] || listofnumbers[d] == listofnumbers[b] || listofnumbers[d] == listofnumbers[c])
							{
								d++;
								saddnumber = listofnumbers[d];
	System.out.println("fourth 111: " + saddnumber);							
							}									
							else
							{
								saddnumber = listofnumbers[d];
		System.out.println("fourth 2222: " + saddnumber);						
								if(fbasenumber + sbasenumber == faddnumber + saddnumber)
								{
									count += 2;
								}										
							}
						}
				}
			}
		 a++;	
		}		
		if(count == 1)
		{
			int fact;
			for(i = 1; i < loopnumber; i++)
			{    
				fact=fact*i;
			}
		}
	System.out.println(count + " " + fact);		
	}
}

