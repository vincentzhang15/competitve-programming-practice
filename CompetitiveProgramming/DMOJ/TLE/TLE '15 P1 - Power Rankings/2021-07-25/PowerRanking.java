/*
#####################################################################################
############################ TLE '15 P1 - Power Rankings ############################
Output the rankings of names based on number of minutes viewing PowerPoints.
The ranking is ordered by 3 + students with a greater total time viewing PowerPoints.

Sample Input
5 3
EnochPoon
LiuJason
Nathanl3
AlexW
TT1103
3 4 2 1 0
1 3 4 2 0
5 1 7 4 0

Sample Input Explanation
L1: n p, number of names, number of PowerPoints.
L2 to Ln+1: names.
Ln+1+1 to Ln+1+p: t[0] t[1] ... t[n], time the ith student spends on a PowerPoint.

Sample Output
3. Nathanl3
4. EnochPoon
5. LiuJason
6. AlexW
7. TT1103

########################################################################
############################ SOLUTION LOGIC ############################
Pair time and name of each person.
Sort by time in reverse order.
Output starting from 3.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Program to find the "power ranking".
 * @author Vincent Zhang
 * @since 25 July 2021
 */
public class PowerRanking
{
    /**
     * Class to store the data including the sum and name of each person.
     * @author Vincent Zhang
     * @since 25 July 2021
     */
    class Data implements Comparable<Data>
    {
        int sum;
        String name;

        /**
         * Initialize values upon instantiation.
         * @param sum Sum of the time spent reading PowerPoints
         * @param name Name of the person
         */
        public Data(int sum, String name)
        {
            this.sum = sum;
            this.name = name;
        }

        /**
         * Comparable method used by sort, to sort data in reverse order.
         * @param d Data to compare against
         * @return If d.sum < this.sum, return a value < 0
         */
        @Override
        public int compareTo(Data d)
        {
            return Integer.compare(d.sum, this.sum);
        }
    }

    // Global declarations.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    /**
     * Main method to solve the problem.
     * @return void
     */
    void run()
    {
        int n = nextInt();
        int p = nextInt();

        // Get the data including the sum of time spent reading PowerPoints and names of each person.
        List<Data> info = new ArrayList<>();
        for(int i=0; i<n; i++)
            info.add(new Data(0, nextLine()));
        for(int i=0; i<p; i++)
        {
            for(int j=0; j<n; j++)
            {
                int time = nextInt();
                info.set(j, new Data(info.get(j).sum + time, info.get(j).name));
            }
        }

        // Sort and output data in order of the "power ranking".
        Collections.sort(info);
        for(int i=0; i<n; i++)
            System.out.println((i+3) + ". " + info.get(i).name);
    }

    /**
     * Instantiates PowerRanking to reference from non-static context.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        PowerRanking pr = new PowerRanking();
        pr.run();
    }

    /**
     * Find the next token in the input string.
     * @return Next token in input string
     */
    String nextToken()
    {
        while(st == null || !st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch(IOException e) {e.printStackTrace();}
        return st.nextToken();
    }

    /**
     * Find the next token in integer value.
     * @return Integer value of the next token of the input string
     */
    int nextInt()
    {
        int n = -1;
        try {
            n = Integer.parseInt(nextToken());
        } catch(NumberFormatException e) {e.printStackTrace();}
        return n;
    }

    /**
     * Read entire line.
     * @return Entire string line of input
     */
    String nextLine()
    {
        String s = "";
        try {
            s = br.readLine();
        } catch(IOException e) {e.printStackTrace();}
        return s;
    }

}