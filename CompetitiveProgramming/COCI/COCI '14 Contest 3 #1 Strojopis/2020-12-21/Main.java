import java.util.*;
import java.io.*;

public class Main
{
	public static void main (String [] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		// <([{\^-=$!|]})?*+.>
		System.out.println(line.length() - line.replaceAll("[1QAZ]", "").length());
		System.out.println(line.length() - line.replaceAll("[2WSX]", "").length());
		System.out.println(line.length() - line.replaceAll("[3EDC]", "").length());
		System.out.println(line.length() - line.replaceAll("[4RFV5TGB]", "").length());
		System.out.println(line.length() - line.replaceAll("[6YHN7UJM]", "").length());
		System.out.println(line.length() - line.replaceAll("[8IK,]", "").length());
		System.out.println(line.length() - line.replaceAll("[9OL\\.]", "").length());
		System.out.println(line.length() - line.replaceAll("[\\\\'\\[\\]\\-\\=0P;/]", "").length());
	}
}