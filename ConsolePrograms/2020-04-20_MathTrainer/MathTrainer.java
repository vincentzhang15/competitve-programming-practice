import java.util.*;
import java.io.*;

class Store
{
	int a;
	int b;
	Store(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
}

/**
 * Program to train memory of single digit addition.
 * 
 * @author Vincent Zhang
 * @since 20 April 2020
 */
public class MathTrainer
{
	static void test(ArrayList<Store> data) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < data.size(); i++)
		{
			int random = (int)(Math.random() * data.size());
			int a = data.get(random).a;
			int b = data.get(random).b;
			System.out.print(a + " + " + b + " = ");
			
			int n = Integer.parseInt(br.readLine());
			if(n == (a+b))
				System.out.print("    Correct");
			else
				System.out.print("    " + (a+b));
			System.out.println();
			data.remove(random);
		}
	}
	public static void main (String [] args) throws IOException
	{
		ArrayList<Store> addition = new ArrayList<Store>();
		for(;;)
		{
			for(int a = 2; a <= 9; a++)
			{
				for(int b = a; b <= 9; b++)
				{
					Store s = new Store(a, b);
					addition.add(s);
				}
			}
			test(addition);
		}
	}
}