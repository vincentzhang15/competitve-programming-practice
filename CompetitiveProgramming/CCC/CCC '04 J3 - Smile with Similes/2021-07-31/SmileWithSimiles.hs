{-
--------------------------------------------------------------------------
---------------------------- HASKELL CONCEPTS ----------------------------
1. Process List of Input
    https://wiki.haskell.org/Tutorials/Programming_Haskell/String_IO
    https://stackoverflow.com/questions/16799755/haskell-interact-function
    https://newbedev.com/haskell-interact-function

    interact $ unlines . calc . lines
        lines: split string delimited by new line characters to list.
        unlines: combine list to string.
        interact take input and output.
2. List Comprehension
    [a ++ " as " ++ b | a <- take n d, b <- take m (reverse d)]

3. String to Type: "read"
    where n = read d1 :: Int

4. List Parameters
    (d1:d2:d)

5. Further Readings
    https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&ved=2ahUKEwjR-eDDtI3yAhUZV80KHU4hCgkQFjAEegQIBxAD&url=https%3A%2F%2Fwww.cmi.ac.in%2F~spsuresh%2Fteaching%2Fprgh19%2Flectures%2Flecture18.pdf&usg=AOvVaw277F_ueYep4iMvc03GH29m
    https://gist.github.com/nathanic/3547089
    https://cs.fit.edu/~ryan/haskell/programs/main/reverse.hs
    http://book.realworldhaskell.org/read/io.html
    https://www.cas.mcmaster.ca/~kahl/Haskell/Lines/PrelLines.lhs

#########################################################################################
############################ CCC '04 J3 - Smile with Similes ############################
Create similes with a list of adjectives and a list of nouns.
Order of output does not matter.

Sample Input
3
2
Easy
Smart
Soft
pie
rock

Sample Input Explanation
L1: n, number of adjectives.
L2: m, number of nouns.
L2+1 to L2+n: list of adjectives.
L2+n+1 to L2+n+m: list of nouns.

Sample Output
Easy as pie
Easy as rock
Smart as pie
Smart as rock
Soft as pie
Soft as rock

########################################################################
############################ SOLUTION LOGIC ############################
Loop through adjectives and nouns in nested loop and print.

Haskell Solution Logic:
    Store entire list of input.
    Match adjectives generator with nouns generator.
        Adj generator: first n items in entire list excluding first two lines.
        Noun generator: last m items in entire list. First m of reversed list.

##########################################################################
############################ PROGRAM COMMENTS ############################
Program creates similes with adjectives and nouns.
@author Vincent Zhang
@since 31 July 2021
@context Self-Learning Haskell
-}

module Main(main) where

main :: IO ()
main = interact $ unlines . calc . lines
  where calc (d1:d2:d) = [a ++ " as " ++ b | a <- take n d, b <- take m (reverse d)]
          where n = read d1 :: Int
                m = read d2 :: Int