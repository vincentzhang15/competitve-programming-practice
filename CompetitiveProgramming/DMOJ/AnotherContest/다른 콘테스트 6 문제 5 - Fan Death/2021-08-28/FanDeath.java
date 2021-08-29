import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class FanDeath
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        int s = 0;
        for(int i=1; i<=Math.sqrt(n); i++)
        {
            if(n%i == 0)
            {
                s += i;
                if(i * i != n)
                    s += n / i;
            }
        }
        System.out.println(s * 5 - 24);
    }
}