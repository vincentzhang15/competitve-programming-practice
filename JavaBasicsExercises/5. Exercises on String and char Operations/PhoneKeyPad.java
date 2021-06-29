import java.util.Scanner;

/**
* A program outputs the number of a keypad.
*
* @author  Vincent Zhang
* @version 1.0
* @since   2018-07-26
*
*/

public class PhoneKeyPad
{
	public static void main (String [] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a letter: ");
		char c = s.next().toLowerCase().charAt(0);
		
		switch(c)
		{
			case 'a': case 'b': case 'c':
				System.out.println(2); break;
			case 'd': case 'e': case 'f':
				System.out.println(3); break;
			case 'g': case 'h': case 'i':
				System.out.println(4); break;
			case 'j': case 'k': case 'l':
				System.out.println(5); break;
			case 'm': case 'n': case 'o':
				System.out.println(6); break;
			case 'p': case 'q': case 'r': case 's':
				System.out.println(7); break;
			case 't': case 'u': case 'v':
				System.out.println(8); break;
			case 'w': case 'x': case 'y': case 'z':
				System.out.println(9); break;
			default:
				System.out.println("Not a letter.");
		}
	}
}