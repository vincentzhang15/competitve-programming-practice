import java.io.*;
import java.util.*;

public class Main
{
    static boolean isPalindrome(String s)
    {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
    public static void main (String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        ArrayList<String> data = new ArrayList<String>();
        
        // ABCD
        for(int i = 0; i < s.length(); i++)
        // ABCD, ABC, AB, A
        // BCD, BC, B
        {
            String s1 = s.substring(i);
            for(int j = 0; j < s1.length(); j++)
            {
                String s2 = s1.substring(0, s1.length()-j);
                if(isPalindrome(s2))
                    data.add(s2);
            }
        }
        
        int index = 0;
        for(int i = 1; i < data.size(); i++)
            if(data.get(i).length() > data.get(index).length())
                index = i;
                
        System.out.println(data.get(index).length());
    }
}