import java.util.Scanner;

public class j3
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int xstart = in.nextInt();
		int ystart = in.nextInt();
		
		int xdestination = in.nextInt();
		int ydestination = in.nextInt();
		
		int fuel = in.nextInt();
		
		xstart = Math.abs(xstart);
		ystart = Math.abs(ystart);

//		xdestination = Math.abs(xdestination);
//		ydestination = Math.abs(ydestination);		
//		System.out.println(xstart + "     ...........    " + ystart);		
		
		int xnew = xdestination - xstart;
		int ynew = ydestination - ystart;

//		System.out.println(xdestination + "     ...........    " + ydestination);			
		xnew = Math.abs(xnew);
		ynew = Math.abs(ynew);	
//		System.out.println(xnew + "     ...........    " + ynew);	
//		System.out.println(xstart + "     ...........    " + ystart);
//		System.out.println("22222222222 2   ---- " + fuel + "    " + fuel % 2);
		if(fuel % 2 == 0)
		{
//			System.out.println("33333333333");
			if(xnew % 2 == 0 && ynew % 2 == 0)
			{
				System.out.println(xnew + "   .......   " + ynew);
				if(xnew == 0 && ynew == 0)
				{
					if(fuel == 0)
						System.out.println("Y");
					else
						System.out.println("N");
				}
				else
					System.out.println("Y");
			}
			else if(xnew % 2 != 0 && ynew % 2 != 0)
				System.out.println("Y");
			else if(xnew % 2 != 0 || ynew % 2 != 0)
				System.out.println("N");
			else
				System.out.println("N");
		}
		else
		{
//			System.out.println("11111111");
			if(xnew % 2 != 0 || ynew % 2 != 0)
			{
				if(xnew == 0 || ynew == 0)
					System.out.println("Y");//new change
				else
					System.out.println("N");
			}
			else if(xnew % 2 != 0 && ynew % 2 != 0)
				System.out.println("Y");
			else
				System.out.println("N");
		}
	}
}

