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

/**
 * Program to find the most frequently called phone number.
 * @author Vincent Zhang
 * @since 20 July 2021
 */

#include <iostream>
#include <map>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name.
 * @param argv Argument vector, program name and command-line arguments
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing before each I/O operation on the other stream.
    std::cin.tie(nullptr);

    // Store phone book and initialize frequency map.
    int n; std::cin >> n;
    std::map<int, std::string> contact;
    std::map<int, int> freq;
    for(int i=0; i<n; i++)
    {
        std::string name; int number; std::cin >> name >> number;
        contact.insert(std::pair<int, std::string>(number, name));
        freq.insert(std::pair<int, int>(number, 0));
    }

    // Find the max frequency.
    int maxFreq = 0;
    int d; std::cin >> d;
    for(int i=0; i<n; i++)
    {
        int num; std::cin >> num;
        freq[num]++;
        if(freq[num] > maxFreq)
            maxFreq = freq[num];
    }

    // Map is sorted. First occurance of max frequency is answer.
    std::string name = "";
    for(auto it=freq.begin(); it!=freq.end(); it++)
    {
        if(it->second == maxFreq)
        {
            name = contact[it->first];
            break;
        }
    }
    std::cout << name;

    return 0;
}