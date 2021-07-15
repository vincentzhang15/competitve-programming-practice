/*
/////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// CCC '08 J2 - Do the Shuffle ////////////////////////////
A music player plays 5 songs: "ABCDE" in order.
4 buttons on the player may switch and output the order.
    Button 1: move first song to end.
    Button 2: move last song to start.
    Button 3: swap first two songs.
    Button 4: output songs and quit program.
Additionally, a button may be pressed one to 10 times inclusive.

Sample Input
2
1
3
1
2
3
4
1

Sample Input Explanation
Odd lines: b, button that is pressed.
Even lines: n, number of times button "b" is pressed.
Note: line counting starts at 1 not 0.

Sample Output
B C D A E
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * Program to determine the order of a playlist after some shuffling.
 * @author Vincent Zhang
 * @since 15 July 2021
 */
public class DoTheShuffle
{
    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @throws IOException BufferedReader exception
     * @return void
     */
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "ABCDE";
        final int SONGS = 5;
        while(true)
        {
            // Input button and number of presses.
            int b = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            // First to end.
            if(b == 1)
                for(int i=0; i<n%SONGS; i++)
                    s = s.substring(1) + s.charAt(0);
            // Last to start.
            if(b == 2)
                for(int i=0; i<n%SONGS; i++)
                    s = s.charAt(s.length()-1) + s.substring(0, s.length()-1);
            // Swap first two.
            if(b == 3)
                if(n%2 == 1)
                    s = s.charAt(1) + "" + s.charAt(0) + s.substring(2);
            // Output and quit.
            if(b == 4)
            {
                String output = "";
                for(int i=0; i<s.length(); i++)
                    output += s.charAt(i) + " ";
                // Remove extra space at the end.
                System.out.println(output.trim());
                break;
            }
        }
    }
}