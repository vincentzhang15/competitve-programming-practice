import java.util.*;
import java.io.*;

public class WhenInRome
{
	String decToRome(int n)
	{
		if(n > 1000)
			return "CONCORDIA CUM VERITATE";
		
		TreeMap<Integer, String> data = new TreeMap<Integer, String>();
		data.put(0, "");
		data.put(1, "I");
		data.put(5,"V");
		data.put(6,"VI");
		data.put(6,"VII");
		data.put(8,"VIII");
		data.put(10, "X");
		data.put(50, "L");
		data.put(100, "C");
		data.put(500, "D");
		data.put(1000, "M");
		data.put(4, "IV");
		data.put(9, "IX");
		data.put(40, "XL");
		data.put(90, "XC");
		data.put(400, "CD");
		data.put(900, "CM");

		String s = "";
		for(int i = String.valueOf(n).length()-1; i >= 0; i--)
		{
			int digit = (int)(n%Math.pow(10, i+1) - n%Math.pow(10, i));
			if(data.containsKey(digit))
				s += data.get(digit);
			else
			{
				int backup = digit;
				while(!data.containsKey(digit))
				{
					digit--;
				}
				
				for(int j = 0; j < backup/digit; j++)
					s += data.get(digit);
			}	
		}
		return s;
	}
	
	int romeToDec(String s)
	{
		int sum = 0;
		sum += 1*(s.length() - s.replace("I", "").length());
		sum += 5*(s.length() - s.replace("V", "").length());
		sum += 10*(s.length() - s.replace("X", "").length());
		sum += 50*(s.length() - s.replace("L", "").length());
		sum += 100*(s.length() - s.replace("C", "").length());
		sum += 500*(s.length() - s.replace("D", "").length());
		sum += 1000*(s.length() - s.replace("M", "").length());
		
		sum -= (s.indexOf("IV") != -1 && s.indexOf("IIV") == -1)?(2*1*(s.length() - s.replace("IV", "").length())/2):(0);
		sum -= (s.indexOf("IX") != -1 && s.indexOf("IIX") == -1)?(2*1*(s.length() - s.replace("IX", "").length())/2):(0);
		sum -= (s.indexOf("XL") != -1 && s.indexOf("XXL") == -1)?(2*10*(s.length() - s.replace("XL", "").length())/2):(0);
		sum -= (s.indexOf("XC") != -1 && s.indexOf("XXC") == -1)?(2*10*(s.length() - s.replace("XC", "").length())/2):(0);
		sum -= (s.indexOf("CD") != -1 && s.indexOf("CCD") == -1)?(2*100*(s.length() - s.replace("CD", "").length())/2):(0);
		sum -= (s.indexOf("CM") != -1 && s.indexOf("CCM") == -1)?(2*100*(s.length() - s.replace("CM", "").length())/2):(0);
		return sum;
	}
	
	void run() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			String line0 = br.readLine();
			String [] line = line0.split("\\+");
			System.out.println(line0 + decToRome(romeToDec(line[0])+romeToDec(line[1].substring(0, line[1].length()-1))));
		}
	}
	
	public static void main (String [] args) throws IOException
	{
		WhenInRome wheninrome = new WhenInRome();
		wheninrome.run();
	}
}