{-
-----------------------------------------------------------------------------
---------------------------- BlueBook - Equation ----------------------------
Solve for x: ax + b = 0, given real coefficients "a" and "b".
Print answer to two decimal places.
0/0 is indeterminate. k/0 is undefined.

Sample Input 1
10
5

Sample Output 1
-0.50

Sample Input 2
13.5555
1.244685

Sample Output 2
-0.09

Sample Input 3
0
0

Sample Output 3
indeterminate

Sample Input 4
0
4

Sample Output 4
undefined

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find -b/a.

if a == 0 and b == 0:
    indeterminate
else if a == 0
    indeterminate
else
    -b/a

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Solves for x in ax+b=0 given "a" and "b".
@author Vincent Zhang
@since 27 August 2021
@context Self Learning Haskell
-}

module Main(main) where

import Text.Printf ( printf )

{-
Solves the problem.
@return IO
-}
main :: IO ()
main = do
    a <- (read :: String -> Double) <$> getLine
    b <- (read :: String -> Double) <$> getLine

    if a == 0 && b == 0 then
        putStrLn "indeterminate"
    else if a == 0 then
        putStrLn "undefined"
    else
        printf "%.2f\n" ((-1) * b / a)