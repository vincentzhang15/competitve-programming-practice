import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine());
		int m1 = Integer.parseInt(br.readLine());
		int m2 = Integer.parseInt(br.readLine());
		int m3 = Integer.parseInt(br.readLine());
		
		int count = 0;
		//System.out.println("$:"+money+" M1:"+m1+" M2:"+m2+" M3:"+m3+" C:"+count+" :INIT");
		while(true)
		{
			if(m1 == 35)
			{
				money += 30;
				m1 = 0;
				//System.out.println("$:"+money+" M1:"+m1+" M2:"+m2+" M3:"+m3+" C:"+count+" :IF1");
			}
			if(m2 == 100)
			{
				money += 60;
				m2 = 0;
				//System.out.println("$:"+money+" M1:"+m1+" M2:"+m2+" M3:"+m3+" C:"+count+" :IF2");
			}
			if(m3 == 10)
			{
				money += 9;
				m3 = 0;
				//System.out.println("$:"+money+" M1:"+m1+" M2:"+m2+" M3:"+m3+" C:"+count+" :IF3");
			}
			
			if(money <= 0) break;
			m1++; money--; count++;
			if(money <= 0) break;
			//System.out.println("$:"+money+" M1:"+m1+" M2:"+m2+" M3:"+m3+" C:"+count+" :COUNT1");
			m2++; money--; count++;
			if(money <= 0) break;
			//System.out.println("$:"+money+" M1:"+m1+" M2:"+m2+" M3:"+m3+" C:"+count+" :COUNT2");
			m3++; money--; count++;
			if(money <= 0) break;
			//System.out.println("$:"+money+" M1:"+m1+" M2:"+m2+" M3:"+m3+" C:"+count+" :COUNT3");
		}
		System.out.println("Martha plays " + count + " times before going broke.");
	}
}
//25 min 58 sec