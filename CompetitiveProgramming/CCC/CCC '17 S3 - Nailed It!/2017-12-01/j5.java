import java.util.Scanner;

public class j5
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
		int[] listofnumbers = new int[loopnumber];

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
//System.out.println("inside the arry " + listofnumbers[i]);				
//System.out.println("START1 ---------------------------------------");						
//System.out.println("This is input: " + listofnumbers[i]);				
					while(a < listofnumbers.length)
					{
//System.out.println("START2 ---------------------------------------");		
//System.out.println("This is a: " + listofnumbers[a]);
						fbasenumber = listofnumbers[a];	
//System.out.println("This is listofnumbers a: " + listofnumbers[a]);						
						for(int b = 0; b < listofnumbers.length; b++)
						{
System.out.println("This is  fbasenumber: " + fbasenumber);	
							if(listofnumbers[b] == listofnumbers[a])
							{
//								System.out.println("This is  b: " + b);
								b++;
								sbasenumber = listofnumbers[b];								
								System.out.println("sbasenumber: " + sbasenumber);
//System.out.println("This is listofnumbers b: " + listofnumbers[b]);
							}
							else
							{
								sbasenumber = listofnumbers[b];	
							}						
							for(int c = 0; c < listofnumbers.length; c++)
							{
//System.out.println("This is c: " + listofnumbers[c]);								
								while(listofnumbers[c] != listofnumbers[a] && listofnumbers[c] != listofnumbers[b])
								{
									c++;
									faddnumber = listofnumbers[c];
									if(listofnumbers[c] != listofnumbers[a] && listofnumbers[c] != listofnumbers[b])
										break;
System.out.println("This is c if equal: " + listofnumbers[c]);
								}
//								else
//								{
//									faddnumber = listofnumbers[c];
//System.out.println("This is listofnumbers c: " + listofnumbers[c]);	
//System.out.println("This is c if not equal: " + listofnumbers[c]);	
//								}							
									for(int d = 0; d < listofnumbers.length; d++)
									{
//System.out.println("This is  d: " + listofnumbers[d]);
										if(listofnumbers[d] == listofnumbers[a] || listofnumbers[d] == listofnumbers[b])
										{
											d++;
//System.out.println("This is  d if equal: " + listofnumbers[d]);	
										}									
										else
										{
//System.out.println("This is  d if not equal: " + listofnumbers[d]);											
											saddnumber = listofnumbers[d];
//System.out.println("This is listofnumbers d: " + listofnumbers[d]);	
											if(listofnumbers[a] + listofnumbers[b] == listofnumbers[c] + listofnumbers[d])
											{
//System.out.println("This is  a: " + listofnumbers[a] + " b: " + listofnumbers[b] + " c: " + listofnumbers[c] + " d: " + listofnumbers[d]);												
												count += 2;
System.out.println("This is  count: " + count);		
											}										
										}
									}
							}
						}
					 a++;	
					}		
//		for(int j = 0; j < listofnumbers.length; j ++)
			System.out.print(" " + count);
	}
}

