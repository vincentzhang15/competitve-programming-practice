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
		
//		xdestination = Math.abs(xdestination);
//		ydestination = Math.abs(ydestination);		
//		System.out.println(xstart + "     ...........    " + ystart);		
		
		int dx = xdestination - xstart;
		int dy = ydestination - ystart;

//		System.out.println(xdestination + "     ...........    " + ydestination);			
		dx = Math.abs(dx);
		dy = Math.abs(dy);	
		int distance = dx + dy;
		
		if(fuel < distance )
			System.out.println("N");
		else if( (fuel -distance )% 2 == 0)
			System.out.println("Y");
		else 
			System.out.println("N");
	}
}

