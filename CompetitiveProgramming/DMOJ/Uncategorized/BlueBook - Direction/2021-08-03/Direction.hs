{-
------------------------------------------------------------------------------
---------------------------- BlueBook - Direction ----------------------------
Given a direction in integer degrees N. 0 ≤ N < 360.
Print the closest cardinal direction.
Ties are broken by smaller directions.
Direction in increasing size are N, E, S, W.
I.e., choose N over E when deg <= 45
             N over W when deg >= 315

Sample Input
2
45
180

Sample Input Explanation
Line 1: T, number of tasks.
Line 2 to T+1: degrees.

Sample Output
N
S

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Process conditions.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to print the closest cardinal direction.
@author Vincent Zhang
@since 03 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Function to find the closest direction.
@param d Integer degrees.
@return String direction.
-}
calc :: Int -> String
calc d
  | d <= 45 || d >= 315 = "N"
  | d <= 135 = "E"
  | d <= 225 = "S"
  | otherwise = "W"

{-
Function to process input output.
@return void
-}
main :: IO ()
main = interact $ unlines . map (calc . read) . tail . lines