/*
###################################################################################
############################ CCCHK '08 J3 - Phone book ############################
Find the most frequently called person.
Ties are broken by a lower numerical phone number.

Sample Input
5
Mary 26000404
Susan 92132122
May 21232132
Ann 62343244
Peter 21321322
8
92132122
62343244
62343244
26000404
21321322
21232132
62343244
92132122

Sample Input Explanation
Line 1: n, number of contacts.
Line 2 to n+1: name number, in the contact list.
Line n+1+1: d, number of numbers that have been dialed.
Line n+1+1+1 to n+1+1+d: dialed numbers.

Sample Output
Ann

########################################################################
############################ SOLUTION LOGIC ############################
Store phonebook in dictionary to get O(1) name lookup by number.
Store frequency. Find max frequency. Find least value in max frequency.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

/**
 * Program to find the most frequently called phone number.
 * @author Vincent Zhang
 * @since 20 July 2021
 */
public class PhoneBook
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Main method to solve the problem.
     * @param args Command-line arguments
     * @throws IOException BufferedReader throws this exception
     */
    public static void main(String[] args) throws IOException
    {
        // Store phone book and initialize frequencies.
        Map<Integer, String> contacts = new TreeMap<>();
        Map<Integer, Integer> freq = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++)
        {
            String[] line = br.readLine().split(" ");
            String name = line[0];
            int num = Integer.parseInt(line[1]);

            contacts.put(num, name);
            freq.put(num, 0);
        }

        // Find the max frequency.
        int max = 0;
        int d = Integer.parseInt(br.readLine());
        for(int i=0; i<d; i++)
        {
            int num = Integer.parseInt(br.readLine());
            freq.put(num, freq.get(num) + 1);
            if(freq.get(num) > max)
                max = freq.get(num);
        }

        // First occurance of max frequency is answer since TreeMap is sorted.
        Iterator<Map.Entry<Integer, Integer>> it = freq.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<Integer, Integer> me = it.next();
            int num = me.getKey();
            int f = me.getValue();

            if(f == max)
            {
                String name = contacts.get(num);
                System.out.println(name);
                break;
            }
        }
        
    }
}