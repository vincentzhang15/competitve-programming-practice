{-
-------------------------------------------------------------------------
---------------------------- BlueBook - Cost ----------------------------
Determine the cost to mail a letter based on weight.

"
 0 ≤ N ≤ 30 costs 38 cents
30 < N ≤ 50 costs 55 cents
50 < N ≤ 100 costs 73 cents
if N > 100 then the base cost is 73 cents, plus 24 cents for every additional 50 grams or part thereof.
"

Sample Input
2
5
101

Sample Input Explanation
Line 1: number of tasks.
Line 2 to n+1: tasks.

Sample Output
38
97

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Process each condition.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find mailling cost.
@author Vincent Zhang
@since 02 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Function to find the cost of mailing based on weight.
@param c String value of weight of letter
@return Integer value of cost
-}
cost :: String -> Int
cost c
    | v <= 30 = 38
    | v <= 50 = 55
    | v <= 100 = 73
    | otherwise = 73 + 24 * div (v-100+49) 50
    where v = read c :: Int

{-
Main function to process input and output.
@return void
-}
main :: IO ()
main = interact $ unlines . map (show . cost) . tail . lines