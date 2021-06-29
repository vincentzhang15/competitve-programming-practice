import java.util.*;

public class j1
{
	public static void main (String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int tiles = sc.nextInt();
		int side = (int)Math.sqrt(tiles);
		System.out.println("The largest square has side length " + side + ".");
	}
}