{-
-------------------------------------------------------------------------------------------------
---------------------------- DWITE '09 R6 #2 - Round to power of two ----------------------------
Find the closest power of 2 for each of the 5 lines of input.
If a number is equally close to two powers of two, print the greater value.

Sample Input
0
1
2
3
5

Sample Output
1
1
2
4
4

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
2^x = y
x ln 2 = ln y
x = log_2(y)
lo = floor x
hi = lo + 1
Find closest.
Ensure to set log 0 to 0 as it is mathematically undefined.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Finds the closest power of 2.
@author Vincent Zhang
@since 14 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Solves the problem.
@param a Input line
@return print
-}
calc :: String -> IO ()
calc a = do
  let b = (read::String->Float) a
  let lo = fromIntegral $ floor $ if b == 0 then 0 else logBase 2 b
  let hi = lo + 1

  let dLo = abs $ (2 ** lo) - b
  let dHi = abs $ (2 ** hi) - b

  if dLo < dHi then
    print . floor $ 2 ** lo
  else
    print . floor $ 2 ** hi

{-
Control IO.
@return print from "calc"
-}
main :: IO ()
main = do
  dat <- lines <$> getContents
  mapM_ calc dat