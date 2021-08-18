/*
-----------------------------------------------------------------------------
---------------------------- BlueBook - Multiple ----------------------------
Given two positive integers, "a", "b", determine if "a" is a mulitple of "b".
Output "yes" or "no".

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
if a % b == 0
    "yes"
else
    "no"
*/

import java.util.Scanner;

/**
 * Program to check if "a" is a mulitple of "b".
 * @author Vincent Zhang
 * @since 18 August 2021
 */
public class Multiple
{
    /**
     * Solves the problem.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        System.out.println(a%b==0?"yes":"no");
    }
}