{-
----------------------------------------------------------------------------
---------------------------- BlueBook - Payment ----------------------------
Find the occurance frequency of integers (0 <= n <= 1000000) in each of the following ranges.
<= 9999
> 9999 && d <= 19999
> 19999 && d <= 29999
> 29999 && d <= 39999
> 39999 && d <= 49999
> 49999 && d <= 1000000

Output frequency count in order of the 6 intervals.
Line will be terminated by -1.

Sample Input
1
9999
10001
1000000
29999
-1

Sample Output
2
1
1
0
0
1

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Filter with a series of conditions.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Counts occurance freqeuncy in 6 ranges.
@author Vincent Zhang
@since 24 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Solves the problem.
@return print
-}
main :: IO ()
main = do
  a <- getContents
  let b = init . lines $ a
  let c = map (read :: String -> Int) b
  print . length $ [d | d <- c, d <= 9999]
  print . length $ [d | d <- c, d > 9999 && d <= 19999]
  print . length $ [d | d <- c, d > 19999 && d <= 29999]
  print . length $ [d | d <- c, d > 29999 && d <= 39999]
  print . length $ [d | d <- c, d > 39999 && d <= 49999]
  print . length $ [d | d <- c, d > 49999 && d <= 1000000]