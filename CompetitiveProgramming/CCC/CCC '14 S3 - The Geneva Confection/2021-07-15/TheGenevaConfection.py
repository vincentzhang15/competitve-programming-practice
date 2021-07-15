"""
############################################################################################
############################ CCC '14 S3 - The Geneva Confection ############################
Candies numbered 1 to "n" are dropped from the top of a mountain to a lake at the bottom.
A branch lies between the mountain and the lake where candies can slide into in first in last out order.
Determine whether it is possible to drop all candies such that the numbers form an arithemtic sequence where the common difference is 1.

Sample Input
2
4
2
3
1
4
4
4
1
3
2

Sample Input Explanation:
Line 1: t, number of tasks.
Line 2: n[0], number of candies in task 1.
Line 3 to n[0]+2, candies in the order for dropping in task 1, i.e., Line n[0] is the first candy to be dropped, then Line n[0]-1 to Line 2.
Line n[0]+2+1: Number of candies in task 2.
etc.

Sample Output
Y
N

########################################################################
############################ SOLUTION LOGIC ############################
First obtain the list of candies in drop order, then loop in reverse order since drop order is not ascending index order.
The branch manifests the definition of a stack, thus, store candies in the branch with a stack.
For every candy drop, perform two actions:
    1. Check if the candy can be dropped to the lake. If so, do so.
        Then drop any possible candy in the branch since the lake value has now changed.
    2. If not, store the candy in the branch, with the hope of emptying after some candies are dropped.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 15 July 2021
@context Python 3 Autodidacticism
"""

# Fast input.
import sys; input = sys.stdin.readline;

"""
Main function to solve the problem.
@return void
"""
def main():
    for _ in range(int(input())):
        # Get input.
        n = int(input())
        data = [int(input()) for i in range(n)]

        # Initialize important variables.
        branch = [] # Use list as stack as python's list has the stack method pop().
        lake = 0 # Track which candy is next.

        # For every candy, perform 2 actions: drop to lake, or store in branch.
        for candy in reversed(data):
            # Check validity and store in branch if not possible.
            if candy == lake+1:
                lake += 1
                # Empty valid candies in branch. Important to prevent the blocking of valid candies.
                while len(branch) != 0 and branch[-1] == lake+1:
                    branch.pop()
                    lake += 1
            else:
                branch.append(candy)

        
        # Since candy branch dropping is the last operation before the candy looping ends,
        # if the branch is not empty then candies are stuck, thus, not possible to order correctly.
        print("Y") if len(branch) == 0 else print("N")

# Prevent incorrect command-line argument interpretation if imported in another module.
if __name__ == "__main__": main()