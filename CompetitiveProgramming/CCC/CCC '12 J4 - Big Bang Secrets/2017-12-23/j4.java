//10:05
//10:15
//10:35
//10:55
//8min
//10min
//7min
//5min
import java.util.Scanner;
//import static java.lang.System.out;
public class j4
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		String coded = scanner.next();
	
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		char separated [] = new char[alphabet.length];

     
		//find separated of string
		for ( int i = 0; i < coded.length(); i++ )
		{
			char c = coded.charAt(i);
			separated[i] = c;     
        }
		
		//find svalue
		int [] svalue = new int[coded.length()];
		for ( int i = 0; i < coded.length(); i++ )
		{		
			svalue[i] = -((3 * (i+1)) + k);
		}
		
		//find alpha value of current letter
		int [] x = new int[alphabet.length]; 
		int [] y = new int[alphabet.length];
		int [] currentvalue = new int [coded.length()];
		int anumber = 0;
		for ( int i = 0; i < alphabet.length; i++)
		{
			x[i] = Character.getNumericValue(separated[i]);
			y[i] = Character.getNumericValue(alphabet[i]);
		}
			for (int w = 0; w < alphabet.length; w++)
			for(int j = 0; j < alphabet.length; j++)
			{
				if(x[w] == y[j])
				{
	//				System.out.println(anumber);
					currentvalue[anumber] = y[j];
					anumber++;
					
	//				System.out.println(currentvalue[w]);
				}
			}
		for(int i = 0; i < alphabet.length; i++)
		{
//			System.out.println(svalue[i]);
		}
		//backup
		int [] tochangevalue = new int [coded.length()+1];
		//calculating with svalue
		for(int i = 0; i < coded.length(); i ++)
		{
			tochangevalue[i] = currentvalue[i] + svalue[i];
			if(tochangevalue[i] < 10)
				tochangevalue[i] += 26;
		}
		//changing back to alpha
		for(int i = 0; i <= coded.length(); i++)
		{
//			System.out.println("i is : " + i);
//			System.out.println("tochangevalue is : " + tochangevalue[i]);
			if(tochangevalue[i] == 10)
				System.out.print("A");
			else if(tochangevalue[i] == 11)
				System.out.print("B");
			else if(tochangevalue[i] == 12)
				System.out.print("C");
			else if(tochangevalue[i] == 13)
				System.out.print("D");
			else if(tochangevalue[i] == 14)
				System.out.print("E");
			else if(tochangevalue[i] == 15)
				System.out.print("F");
			else if(tochangevalue[i] == 16)
				System.out.print("G");
			else if(tochangevalue[i] == 17)
				System.out.print("H");
			else if(tochangevalue[i] == 18)
				System.out.print("I");
			else if(tochangevalue[i] == 19)
				System.out.print("J");
			else if(tochangevalue[i] == 20)
				System.out.print("K");
			else if(tochangevalue[i] == 21)
				System.out.print("L");
			else if(tochangevalue[i] == 22)
				System.out.print("M");
			else if(tochangevalue[i] == 23)
				System.out.print("N");
			else if(tochangevalue[i] == 24)
				System.out.print("O");
			else if(tochangevalue[i] == 25)
				System.out.print("P");
			else if(tochangevalue[i] == 26)
				System.out.print("Q");
			else if(tochangevalue[i] == 27)
				System.out.print("R");
			else if(tochangevalue[i] == 28)
				System.out.print("S");
			else if(tochangevalue[i] == 29)
				System.out.print("T");
			else if(tochangevalue[i] == 30)
				System.out.print("U");
			else if(tochangevalue[i] == 31)
				System.out.print("V");
			else if(tochangevalue[i] == 32)
				System.out.print("W");
			else if(tochangevalue[i] == 33)
				System.out.print("X");
			else if(tochangevalue[i] == 34)
				System.out.print("Y");
			else if(tochangevalue[i] == 35)
				System.out.print("Z");

		}
		//printing	
		for ( int i = 0; i < coded.length(); i++ )//10 - 35
		{		
//			System.out.println(separated[i] + ": " + svalue[i]);
//			System.out.println(alphabet[i] + "----------- ");
//			System.out.println("--=-==-=-=-=-==-=--=-"+y[i]);
//			System.out.println("--=-==-=-=-=-this is x"+x[i]);
//			System.out.println("--=-=-=-this is svalue"+svalue[i]);
//			System.out.println("--=-=-=-this is currentvalue"+currentvalue[i]);
//			System.out.println("--=-=-=-this is tochangevalue"+tochangevalue[i]);
		}
	}
}
//3:13