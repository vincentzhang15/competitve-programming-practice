import java.io.*;

public class Main
{
	public static void main(String[] args) throws IOException
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String [] line1 = br.readLine().split(" ");
	    int x1 = Integer.parseInt(line1[0]);
	    int y1 = Integer.parseInt(line1[1]);
	    
	    String [] line2 = br.readLine().split(" ");
	    int x2 = Integer.parseInt(line2[0]);
	    int y2 = Integer.parseInt(line2[1]);
	    
	    String [] line3 = br.readLine().split(" ");
	    int x3 = Integer.parseInt(line3[0]);
	    int y3 = Integer.parseInt(line3[1]);
	    
	    int d = Integer.parseInt(br.readLine());
	    
	    System.out.println((Math.hypot(Math.abs(x3-x1), Math.abs(y3-y1)) <= d || Math.hypot(Math.abs(x3-x2), Math.abs(y3-y2)) <= d)?"Yes":"No");
	}
}