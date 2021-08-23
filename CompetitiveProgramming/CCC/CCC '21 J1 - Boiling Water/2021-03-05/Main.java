import java.io.*;

public class Main
{
    public static void main (String [] args) throws IOException
    {
        int p = 5*Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine())-400;
        System.out.println(p + "\n" + ((p==100)?(0):((p>100)?(-1):(1))));
    }
}
