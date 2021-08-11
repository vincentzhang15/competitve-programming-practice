{-
------------------------------------------------------------------------
---------------------------- BlueBook - Min ----------------------------
Find the min of a list of real numbers.
1 <= Size of list <= 10 000
-1000 < Size of numbers < 1000
Output answer to two decimal places.

Sample Input
2
10.1
12.3

Sample Output
10.10

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Use built-in min function or loop through list.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the min of a list of real numbers.
@author Vincent Zhang
@since 11 August 2021
@context Self-Learning Haskell
-}

import Text.Printf
main = getContents >>= \c -> printf "%.2f\n" . minimum . map (read::String->Float) . tail $ lines c