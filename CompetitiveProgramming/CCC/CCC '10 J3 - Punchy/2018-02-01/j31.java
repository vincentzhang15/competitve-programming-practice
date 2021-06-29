import java.util.Scanner;

public class j31
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		int a = 0;
		int b = 0;
		for(int i = 0;; i++)
		{
			int cmd = scanner.nextInt();
			if(cmd == 7)
				return;
			String letter = scanner.next();
			
			System.out.println(" cmd= " + cmd + " letter = " + letter);
			switch(cmd)
			{
				case 1: 
					if(letter.equals("A"))
						a = scanner.nextInt();
					else
					{
						b = scanner.nextInt();
						System.out.println(" b = "+ b);
					}
					break;
				case 2:
					if(letter.equals("A"))
						System.out.println(a);
					else
						System.out.println(b);
					break;
				case 3:
					String second = scanner.next();
					if(letter.equals("A"))
					{
						if(second.equals("A"))
							a += a;
						else
							a += b;
					}
					else
					{
						if(second.equals("A"))
							b += a;
						else
							b += b;
					}						
					break;
				case 4:
					String second1 = scanner.next();
					if(letter.equals("A"))
					{
						if(second1.equals("A"))
							a *= a;
						else
							a *= b;
					}
					else
					{
						if(second1.equals("A"))
							b *= a;
						else
							b *= b;
					}
					break;
				case 5:
					String second2 = scanner.next();
					if(letter.equals("A"))
					{
						if(second2.equals("A"))
							a -= a;
						else
							a -= b;
					}
					else
					{
						if(second2.equals("A"))
							b -= a;
						else
							b -= b;
					}
					break;
				case 6:
					String second3 = scanner.next();
					if(letter.equals("A"))
					{
						if(second3.equals("A"))
							a = a / a;
						else
							a = a / b;
					}
					else
					{
						if(second3.equals("A"))
							b = b / a;
						else
							b = b / b;
					}
					break;
				case 7: return;
			}
		}
	}
}