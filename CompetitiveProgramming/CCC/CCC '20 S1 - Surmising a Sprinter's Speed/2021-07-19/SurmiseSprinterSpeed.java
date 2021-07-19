/*
###################################################################################################
############################ CCC '20 S1 - Surmising a Sprinter's Speed ############################
Find the max possible speed of a sprinter, given observations of their positions at various times.

Sample Input 1
3
0 100
20 50
10 120

Sample Input 1 Explanation
Line 1: n, number of observations.
Lin3 2...n+1: time position, observations.

Sample Output 1
7.0


Sample Input 2
5
20 -5
0 -17
10 31
5 -3
30 11

Sample Output 2
6.8

########################################################################
############################ SOLUTION LOGIC ############################
speed = distance / time
    distance = |displacement|
    displacement = pos2 - pos1
speed = |pos2 - pos1| / time
The max of speed will be the answer.
Ensure to sort the data structure by time as one cannot travel back in time in this question.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Program to find fassted possible speed.
 * @author Vincent Zhang
 * @since 19 July 2021
 */
public class SurmiseSprinterSpeed
{
    // Global declarations.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    /**
     * Main method to solve the problem.
     * @return void
     */
    void run()
    {
        // Store time and positions in TreeMap so that times are sorted.
        int n = nextInt();
        Map<Integer, Integer> timePos = new TreeMap<>();
        for(int i=0; i<n; i++)
        {
            int time = nextInt();
            int pos = nextInt();
            timePos.put(time, pos);
        }

        // Find max speed.
        double max = Integer.MIN_VALUE;
        int t1, t2, p1, p2;
        t1 = t2 = p1 = p2 = 0;
        boolean first = true;
        Iterator<Map.Entry<Integer, Integer>> it = timePos.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer, Integer> me = it.next();
            t2 = me.getKey();
            p2 = me.getValue();

            if(first)
                first = false;
            else
            {
                double speed = Math.abs(p2-p1) / (double)(t2-t1);
                if(speed > max)
                    max = speed;
            }
            t1 = t2;
            p1 = p2;
        }
        System.out.println(max);
        brClose();
    }

    /**
     * Parse the line into tokens.
     * @return Token on a line
     */
    String nextToken()
    {
        while(st == null || !st.hasMoreTokens())
        {
            String s = "";
            try
            {
                s = br.readLine();
            } catch(IOException e) {e.printStackTrace();}
            st = new StringTokenizer(s);
        }
        return st.nextToken();
    }

    /**
     * Convert token to integer.
     * @return Integer value of token
     */
    int nextInt()
    {
        int n = Integer.MAX_VALUE;
        try
        {
            n = Integer.parseInt(nextToken());
        } catch(NumberFormatException e) {e.printStackTrace();}
        return n;
    }

    /**
     * Close BufferedReader.
     * @return void
     */
    void brClose()
    {
        try
        {
            br.close();
        }
        catch(IOException e) {e.printStackTrace();}
    }

    /**
     * Instantiate class to reference from non-static context.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        SurmiseSprinterSpeed sss = new SurmiseSprinterSpeed();
        sss.run();
    }
}