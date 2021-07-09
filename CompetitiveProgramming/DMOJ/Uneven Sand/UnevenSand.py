"""
CONCEPTS SUMMARY
1. Flushing Output & Combine Lines with Semi-Colon
    Obtain input after first printing new line then flushing output with:
    import sys; sys.stdout.flush()

2. Logic of Solving This Problem
    My solution was based on the Binary Search Tree (BST) search() method which has an average time complexity of log_2(N).
    Set a min and max and guess will always be the integer average.
    If guess > answer, min = guess + 1
    If guess < answer, max = guess - 1

PROBLEM DESCRIPTION
Uneven Sand
Kira's Strike Gundam needs to land on the desert with the exact pressure "N", where N ∈ [1, 2e9].
Guess the value for "N" with at most 31 guesses.
"Strike" will "FLOAT" with too much pressure and "SINK" with too little pressure.
Program terminates after guessing the right pressure denoted by "OK".

Sample Interaction:
>>> 1
SINKS
>>> 6
SINKS
>>> 10
SINKS
>>> 40
FLOATS
>>> 32
OK

@author Vincent Zhang
@since 09 July 2021
@context Learning Python 3
"""

"""
Performs the guessing interaction.
@return void
"""
def main():
    # Initialize a max and min.
    maxx = int(2e9)
    minn = 1

    # Max 31 guesses.
    for i in range(31):
        # Guess the integer average.
        guess = (maxx + minn) // 2
        print(guess)
        import sys; sys.stdout.flush()
        
        # Process response and adjust range.
        response = input()
        if response == "SINKS":
            minn = guess + 1
        elif response == "FLOATS":
            maxx = guess - 1
        else:
            break

# Call main() when program is called from this module.
if __name__ == "__main__": main()