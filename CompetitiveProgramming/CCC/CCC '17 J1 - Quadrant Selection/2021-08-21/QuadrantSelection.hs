{-
-----------------------------------------------------------------------------------------
---------------------------- CCC '17 J1 - Quadrant Selection ----------------------------
Determine the quadrant in which a pair of non-zero integral coordinates lie.

Sample Input 1
12
5

Sample Output 1
1

Sample Input 2
9
-13

Sample Output 2
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Check half of coordinate plane, e.g., upper half, when y > 0: x > 0, x < 0.
Only 2 cases remain, both y < 0:
    Check x < 0
    Else

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to identify the quadrant of a pair of coordinates.
@author Vincent Zhang
@since 21 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Quandrant identification.
@param x X-coordinate
@param y Y-coordinate
@return Quadrant number
-}
calc :: Int -> Int -> Int
calc x y
  | x > 0 && y > 0 = 1
  | x < 0 && y > 0 = 2
  | x < 0          = 3
  | otherwise      = 4

{-
Controls IO.
@return print
-}
main :: IO ()
main = getLine >>= (\ a -> getLine >>= (print . calc a) . (read :: String -> Int)) . (read :: String -> Int)
