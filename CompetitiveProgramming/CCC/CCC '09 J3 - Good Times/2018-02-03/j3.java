import java.util.Scanner;

public class j3
{
	static int toHour(int time)
	{
		int hour = time / 60;
		int min = time % 60;
		
		int combined = hour * 100 + min;
		return combined;
	}
	public static void main(String [] args)
	{
		Scanner sc = new Scanner(System.in);
		int ottawa = sc.nextInt();

		int hour = ottawa / 100;
		int min = (ottawa % 100) + (hour * 60);
		
		int ottawa1 = min;
		System.out.println(toHour(ottawa1) + " in Otttawa.");
//		
		int victoria;
		if(min - 180 < 0)
			victoria = min - 180 + 1440;
		else	
			victoria = min - 180;
		System.out.println(toHour(victoria) + " in Victoria.");
//
		int edmonton;
		if(min - 120 < 0)
			edmonton = min - 120 + 1440;
		else	
			edmonton = min - 120; 
		System.out.println(toHour(edmonton) + " in Edmonton.");
//
		int winnipeg;
		if(min - 60 < 0)
			winnipeg = min - 60 + 1440;
		else	
			winnipeg = min - 60;  
		System.out.println(toHour(winnipeg) + " in Winnipeg.");
//
		int toronto = min;        
		System.out.println(toHour(toronto) + " in Toronto.");
//
		int halifax;
		if(min + 60 > 1140)
			halifax = min + 60 - 1440;
		else	
			halifax = min + 60;   
		System.out.println(toHour(halifax) + " in Halifax.");
//
		int stjohns;
		if(min + 90 > 1140)
			stjohns = min + 90 - 1440;
		else	
			stjohns = min + 90;   
		System.out.println(toHour(stjohns) + " in St. John's.");
	}
}