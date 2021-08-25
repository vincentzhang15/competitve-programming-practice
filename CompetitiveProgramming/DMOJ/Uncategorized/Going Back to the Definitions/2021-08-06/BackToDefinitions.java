import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class BackToDefinitions
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static int nextInt()
    {
        try
        {
            return Integer.parseInt(br.readLine());
        }
        catch(NumberFormatException | IOException nfeioe)
        {
            nfeioe.printStackTrace();
        }
        return -1;
    }

    static String nextStr()
    {
        try
        {
            return br.readLine();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args)
    {
        int n = nextInt();
        String[] nums = new String[n];

        for(int i=0; i<n; i++)
        {
            nums[i] = nextStr();
        }

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String s1, String s2)
            {
                return (s2+s1).compareTo(s1+s2);
            }
        });

        for(int i=0; i<n; i++)
        {
            System.out.print(nums[i]);
        }
    }
}