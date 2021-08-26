{-
-------------------------------------------------------------------------------
---------------------------- BlueBook - Power Base ----------------------------
Given x, p, find "x" raised to the power "p" rounded to 2 decimal places.

Sample Input
3
2.0 4
4.0 2
3.0 3

Sample Output
16.00
16.00
27.00

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Loop and find power.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Evaluates an exponentiation.
@author Vincent Zhang
@since 26 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Text.Printf ( printf )

{-
Evaluates the power.
@param s Unparsed row of data
@return IO
-}
pow :: String -> IO ()
pow s = printf "%.2f\n" $ x ** y
  where v = map (read :: String -> Double) . words $ s
        x = head v
        y = last v

{-
Controls IO.
@return IO
-}
main :: IO ()
main = do
  a <- tail . lines <$> getContents
  mapM_ pow a