import java.util.Scanner;

public class ListMinimum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        for(int i=1, n=sc.nextInt(); i<=n; i++)
        {
            System.out.print(i + " ");
        }
        sc.close();
    }
}