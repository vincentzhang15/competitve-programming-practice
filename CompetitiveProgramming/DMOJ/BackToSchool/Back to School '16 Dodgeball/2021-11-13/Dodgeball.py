"""
#######################################################################################
############################ Back to School '16: Dodgeball ############################
Find the number of valid groups that can be made from a list of names.
Each name will only contain english alphabet characters.
A valid group is one whose first character in each name is the same and names must be consecutive.
Output the number of valid groups modulo  1 000 000 007.

Sample Input 1
5
Sarah Timmy Turner Betty Bob

Sample Output 1
7

Sample Input 1 Explanation
The 7 groups are
Sarah
Timmy
Turner
Betty
Bob
Timmy, Turner
Betty, Bob


Sample Input 2
7
A B B B C D E

Sample Output 2
10

Sample Output 2 Explanation
The 10 groups are:
A
B
B B
B B B
B
B B
B
C
D
E


########################################################################
############################ SOLUTION LOGIC ############################
Find all subsections where there is a consecutive list of same first letter names.
Let x be the number of names in this subsequence.
The number of possible group choices is
    1 + 2 + ... + n = n * (n + 1) / 2, by sum of arithmetic series.
For example, when 3 consecutive names are the same: Ba Bb Bc, we have the following groups,
Ba
Ba Bb
Ba Bb Bc   (3)
   Bb
   Bb Bc   (2)
      Bc   (1)
where n = 3.

Efficiency note: one could increment an accumulator variable to find the length of the subsequence.
It is more efficient to keep one index, and find the name at that index, and store the name at that index.
This way, there is no need to check an unchanging name over and over again.
See code for clarification.


######################################################################
############################ ACHIEVEMENTS ############################
Fastest Python 3 Submission: 0.85s
Next 3 places: 0.89s, 0.91s, 0.94s

Most Memory Efficient Python 3 Submission: 19.7 MB
Next 3 places: 20.7 MB, 21.7 MB, 20.9 MB


##########################################################################
############################ PROGRAM COMMENTS ############################
Find the number of possible valid groups.
@author Vincent Zhang
@since 13 November 2021
@context Self-Learning Python 3
"""

def main():
    """
    Solves the problem.

    Returns:
        None
    """

    # Input
    n = int(input()) + 1
    names = input().split() # List of names.
    names.append('-') # Gaurantees last subsequence of values gets evaluated.
    
    choices = 0
    idx_prev = 0
    name = names[idx_prev][0]
    for idx_cur in range(1, n):
        if name != names[idx_cur][0]: # Efficient comparison by storing in string name.
            same_nums = idx_cur - idx_prev # Find length of subsequence.
            choices += same_nums * (same_nums + 1) // 2 # odd * even = even

            idx_prev = idx_cur # Update index.
            name = names[idx_prev][0] # Update name.
    print(choices % 1000000007)
main()