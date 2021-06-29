import java.util.*;

public class j4
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner (System.in);
		int boardw = sc.nextInt();
		int boardh = sc.nextInt();
		int cutoutw = sc.nextInt();
		int cutouth = sc.nextInt();
		int steps = sc.nextInt();
		
		int x = cutoutw + 1;
		int y = 1;
		int count = 0;

		while(true)
		{
			//right step 1
			for(int i = 1; i < boardw - (cutoutw * 2); i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				x++;
			}
			//down step 2
			for(int i = 0; i < cutouth; i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				y++;
			}
			//right step 3
			for(int i = 0; i < cutoutw; i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				x++;
			}
			//down step 4
			for(int i = 1; i < boardh - (cutouth * 2); i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				y++;
			}
			//left step 5
			for(int i = 0; i < cutoutw; i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				x--;
			}
			//down step 6
			for(int i = 0; i < cutouth; i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				y++;
			}
			//left step 7
			for(int i = 1; i < boardw - (cutoutw * 2); i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				x--;
			}
			//up step 8
			for(int i = 0; i < cutouth; i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				y--;
			}
			//left step 9
			for(int i = 0; i < cutoutw; i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				x--;
			}
			//up step 10
			for(int i = 1; i < boardh - (cutouth * 2); i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				y--;
			}
			//right step 11
			for(int i = 0; i < cutoutw; i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				x++;
			}
			//up step 12
			for(int i = 0; i < cutouth; i++)
			{
				if(count == steps)
				{
					System.out.println(x);
					System.out.println(y);
					return;
				}
				count++;
				System.out.println("Coordinates: (" + x + ", " + y + ")");
				y--;
			}
		}
	}
}