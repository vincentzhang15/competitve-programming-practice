import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class AStringProblem
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int[] alpha = new int[26];
        for(int i=0; i<26; i++)
        {
            char c = (char)(i + 97);
            alpha[i] = line.length() - line.replaceAll(""+c, "").length();
        }
        Arrays.sort(alpha);
        int sum = 0;
        for(int i=0; i<alpha.length-2; i++)
        {
            sum += alpha[i];
        }
        System.out.println(sum);
    }
}