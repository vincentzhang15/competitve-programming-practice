import java.util.*;
import java.io.*;

public class Sretan3
{
	public static void main (String [] args) throws IOException
	{
		System.out.print(Integer.toBinaryString(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()) + 1).replace("0", "4").replace("1", "7").substring(1));
	}
}