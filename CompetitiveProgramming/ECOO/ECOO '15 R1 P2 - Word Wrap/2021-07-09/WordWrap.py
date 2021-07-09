"""
ECOO '15 R1 P2 - Word Wrap

Program to wrap words given a string of words and a max width.
Only words that are longer than the display width are broken.
Words longer than the width starts printing on a new line.
Print each line such that the most words fit in it.
Word string contains only letter characters and space. No punctuation.

10 sets of input. Print 5 "=" after outputing result of each set.

Sample Input:
14
Spiderman Spiderman does whatever a spider can
10
Spins a web any size
11
Catches thieves just like flies
7
Look Out
7
Here comes the Spiderman

Sample Input Explanation:
Line 2n-1, n is an element of N (or Z+): display width.
Line 2n  , n is an element of N (or Z+): string of words to wrap.
Note this sample input contains only 5 sets while real contest data contains 10 sets.

Sample Output:
Spiderman
Spiderman does
whatever a
spider can
=====
Spins a
web any
size
=====
Catches
thieves
just like
flies
=====
Look
Out
=====
Here
comes
the
Spiderm
an
=====

@author Vincent Zhang
@since 09 July 2021
@context Learning Python 3
"""

# Global variables.
width = -1 # Display width.
words = [] # Words string split by space.

"""
Calculate and output the result of the wrapped words.
@return void
"""
def calc():
    # Stores the line that needs to be printed. Keeps track if a new should be printed.
    line = ""

    # Loops through every word.
    while len(words) != 0:
        word = words.pop(0)

        # For words longer than the width: print out excess characters to make the remaning characters of the word less than the width. 
        if len(word) > width:
            # Long words start on new line. Print out any currently stored words.
            if len(line) != 0:
                print(line)
                line = ""

            # Print long-word block.
            k = len(word) // width # Find the integer factor.
            for j in range(k):
                print(word[j*width:(j+1)*width])
            
            # Store extra characters as a word.
            extra = word[k*width:]
            line = extra
        # A word that is the same length as the display width or less.
        else:
            # First word in current line to be printed.
            if len(line) == 0:
                line = word
            # A word exists: check if a space and the next word fits the display. If it fits then add to the line to be outputted.
            elif len(line) + 1 + len(word) <= width:
                line += " " + word
            # If does not fit, then print out the current line and initialize the new line with the current word.
            else:
                print(line)
                line = word
        
        # Deals with ending situations. If queue is empty but line to be printed is not, print the line or else this line will never be printed.
        if len(words) == 0 and len(line) != 0:
            print(line)
            line = ""
        
"""
Controls program flow by looping 10 times: input, process, output.
@return void
"""
def main():
    global width, words
    for _ in range(10):
        width = int(input())
        words = list(input().split())
        calc()
        print("="*5)

# Guard to prevent program from running when this module is imported.
if __name__ == "__main__": main()