/*
CCC '18 J3 - Are we there yet?

O(1) solution by simplying adding.

@author Vincent Zhang
@since 26 June 2022
@context Java Review
*/

import java.util.Scanner;

public class AreWeThereYet_O1Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        sc.close();

        System.out.println(String.format("0 %d %d %d %d ", a, a+b, a+b+c, a+b+c+d));
        System.out.println(String.format("%d 0 %d %d %d ", a, b, b+c, b+c+d));
        System.out.println(String.format("%d %d 0 %d %d ", a+b, b, c, c+d));
        System.out.println(String.format("%d %d %d 0 %d ", a+b+c, b+c, c, d));
        System.out.println(String.format("%d %d %d %d 0 ", a+b+c+d, b+c+d, c+d, d));
    }
}
