import java.io.*;
import java.util.*;
import java.text.*;

public class PerfectTiming
{
	public static void main (String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line1 = br.readLine().split(" ");
		int x1 = Integer.parseInt(line1[0]);
		int y1 = Integer.parseInt(line1[1]);
		String [] line2 = br.readLine().split(" ");
		int x2 = Integer.parseInt(line2[0]);
		int y2 = Integer.parseInt(line2[1]);

		int sec = Math.abs(x2-x1) + Math.abs(y2-y1);

		String date = br.readLine();
		Date date1 = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").parse(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		cal.add(Calendar.SECOND, sec);
		System.out.println(new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(cal.getTime()));
	}
}