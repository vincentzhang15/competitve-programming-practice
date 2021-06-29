import java.util.*;
import java.io.*;
import java.math.*;

public class GradeNineMath
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		int x1 = s.nextInt();
		int y1 = s.nextInt();
		int x2 = s.nextInt();
		int y2 = s.nextInt();
		int x11 = s.nextInt();
		int y11 = s.nextInt();
		int x22 = s.nextInt();
		int y22 = s.nextInt();

		if(x2-x1 == 0)
		{
			if(x22-x11 == 0 && x2 == x22)
			{
				System.out.println("coincident");
				return;
			}
			if(x22-x11 == 0)
			{
				System.out.println("parallel");
				return;
			}
			BigDecimal m2 = (BigDecimal.valueOf(y22).subtract(BigDecimal.valueOf(y11))).divide(BigDecimal.valueOf(x22).subtract(BigDecimal.valueOf(x11)), 8, RoundingMode.HALF_UP);
			BigDecimal b2 = BigDecimal.valueOf(y22).subtract(m2.multiply(BigDecimal.valueOf(x22)));
			BigDecimal y = m2.multiply(BigDecimal.valueOf(x2)).add(b2);
			
			System.out.println(x2 + " " + y);
			return;
		}
		
		if(x22-x11 == 0)
		{
			if(x2-x1 == 0 && x2 == x22)
			{
				System.out.println("coincident");
				return;
			}
			if(x2-x1 == 0)
			{
				System.out.println("parallel");
				return;
			}
			
			BigDecimal m1 = (BigDecimal.valueOf(y2).subtract(BigDecimal.valueOf(y1))).divide(BigDecimal.valueOf(x2).subtract(BigDecimal.valueOf(x1)), 8, RoundingMode.HALF_UP);
			BigDecimal b1 = BigDecimal.valueOf(y2).subtract(m1.multiply(BigDecimal.valueOf(x2)));
			BigDecimal y = m1.multiply(BigDecimal.valueOf(x22)).add(b1);
			
			System.out.println(x22 + " " + y);
			return;
		}
		
		BigDecimal m1 = (BigDecimal.valueOf(y2).subtract(BigDecimal.valueOf(y1))).divide(BigDecimal.valueOf(x2).subtract(BigDecimal.valueOf(x1)), 8, RoundingMode.HALF_UP);
		BigDecimal m2 = (BigDecimal.valueOf(y22).subtract(BigDecimal.valueOf(y11))).divide(BigDecimal.valueOf(x22).subtract(BigDecimal.valueOf(x11)), 8, RoundingMode.HALF_UP);
		
		BigDecimal b1 = BigDecimal.valueOf(y1).subtract(m1.multiply(BigDecimal.valueOf(x1)));
		BigDecimal b2 = BigDecimal.valueOf(y22).subtract(m2.multiply(BigDecimal.valueOf(x22)));
		
		if(m1.equals(m2) && b1.equals(b2))
			System.out.println("coincident");
		else if(m1.equals(m2))
			System.out.println("parallel");
		else
		{
			if(m1.equals("0"))
			{
				BigDecimal x = (BigDecimal.valueOf(y1).subtract(b2)).divide(m2, 8, RoundingMode.HALF_UP);
				System.out.println(x + " " + y1);
				return;
			}
			if(m2.equals("0"))
			{
				BigDecimal x = (BigDecimal.valueOf(y11).subtract(b1)).divide(m1, 8, RoundingMode.HALF_UP);
				System.out.println(x + " " + y11);
				return;
			}
			
			BigDecimal y = (b2.subtract(m2.multiply(b1).divide(m1))).divide(BigDecimal.valueOf(1).subtract(m2.divide(m1)), 8, RoundingMode.HALF_UP);
			BigDecimal x = (y.subtract(b1)).divide(m1, 8, RoundingMode.HALF_UP);
			
			System.out.println(x + " " + y);
		}
	}
}