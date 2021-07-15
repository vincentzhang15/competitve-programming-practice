"""
#####################################################################################
############################ CCC '08 J2 - Do the Shuffle ############################
The C3MP music player contains a playlist of songs "ABCDE" where A, B, C, D, E are songs.
There are 4 buttons on the music player.
The user presses buttons a number of times.
    Button 1: Move first song to end of playlist.
    Button 2: Move last song to start of plalist>
    Button 3: Swap first two songs.
    Button 4: Output the songs in order.
The program terminates when button 4 is pressed.

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
Line 2k-1, k ϵ N: b, button that is pressed.
Line 2k  , k ϵ N: n, number of times button "b" is pressed.

Sample Output
B C D A E

############################ SOLUTION LOGIC ############################
Store songs in a string.
Process each button press instantly.

############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 14 July 2021
@context Python 3 Autodidacticism
"""

# Fast input.
import sys; input = sys.stdin.readline;

# Global declarations and initializations.
SONGS = 5
s = "ABCDE"

# Loop through input.
while 1:
    b = int(input())
    n = int(input())

    # Process button presses.
    if b == 1 and n % SONGS != 0:
        # Move first song to end.
        for i in range(n): s = s[1:] + s[0]
    if b == 2 and n % SONGS != 0:
        # Move last song to start.
        for i in range(n): s = s[-1] + s[:-1]
    if b == 3 and n % 2 != 0:
        # Swap first two songs.
        s = s[1] + s[0] + s[2:]
    if b == 4:
        # Output result.
        output = ""
        for i in range(len(s)): output += s[i] + " "
        
        # Print without extra space at end.
        print(output[:-1])
        break