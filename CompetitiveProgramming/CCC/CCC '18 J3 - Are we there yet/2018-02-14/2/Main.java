import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int d1 = in.nextInt();
		int d2 = in.nextInt();
		int d3 = in.nextInt();
		int d4 = in.nextInt();		
		int[] outputArray = new int[5];
		System.out.println("0 "+d1+" "+(d1+d2)+" "+(d1+d2+d3)+" "+(d1+d2+d3+d4));
		System.out.println(d1+" 0 "+d2+" "+(d2+d3)+" "+(d2+d3+d4));
		System.out.println((d1+d2)+" "+d2+" 0 "+d3+" "+(d3+d4));
		System.out.println((d1+d2+d3)+" "+(d2+d3)+" "+d3+" "+"0 "+d4);
		System.out.println((d1+d2+d3+d4)+" "+(d2+d3+d4)+" "+(d3+d4)+" "+d4+" 0");		
	}
}