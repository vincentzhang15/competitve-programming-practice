{-
-----------------------------------------------------------------------------
---------------------------- BlueBook - Interest ----------------------------
Find the account value for every year from 0 to "Y".
Interest is paid annually at the end of each year.
Interest rate is "M"%.
Principal amount is "N".
Input contains one line:
N M Y
Round answer to two decimal places.

Sample Input 1
1000 8 3

Sample Output 1
0 1000.00
1 1080.00
2 1166.40
3 1259.71

Sample Input 2
20 8 0

Sample Output 2
0 20.00

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
y0 = principal
y1 = y0*(1+ r/100)
y2 = y1*(1+ r/100)
   = y0*(1+ r/100)^2
Thus, find:
    y0*(1+ r/100)^year

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Calculates account value for every year.
@author Vincent Zhang
@since 27 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

import Text.Printf ( printf )

{-
Calculate account value.
@param y0 Principal
@param r Interest rate
@param year Current year
@return IO
-}
calc :: Double -> Double -> Double -> IO ()
calc y0 r year = printf "%d %.2f\n" ((round :: Double -> Int) year) (y0*(1+ r/100)**year)

{-
Controls iO.
@return IO
-}
main :: IO ()
main = do
    a <- map (read :: String -> Double) . words <$> getLine
    let y0 = head a
    let r = a !! 1
    let years = last a
    mapM_ (calc y0 r) [0..years]