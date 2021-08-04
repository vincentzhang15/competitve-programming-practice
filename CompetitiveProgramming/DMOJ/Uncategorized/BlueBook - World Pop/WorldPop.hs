{-
--------------------------------------------------------------------------
---------------------------- HASKELL CONCEPTS ----------------------------
1. EXPONENTIAL OPERATORS
    https://stackoverflow.com/questions/6400568/exponentiation-in-haskell
    1. (^) :: (Num a, Integral b) => a -> b -> a
        "non-negative integral exponentiation"
    2. (^^) :: (Fractional a, Integral b) => a -> b -> a
        "integer exponentiation"
    3. (**) :: Floating a => a -> a -> a
        "floating-point exponentiation"

2. HASKELL PRELUDE round x
    https://stackoverflow.com/questions/10738569/round-to-nearest-integer-strange-results
    "round x returns the nearest integer to x, the even integer if x is equidistant between two integers."
    "in accordance with the IEEE Standard for Floating-Point Arithmetic."
    "
        ghci> round (0.5 :: Double)
        0
        ghci> round (1.5 :: Double)
        2
    "

------------------------------------------------------------------------------
---------------------------- BlueBook - World Pop ----------------------------
World population increases p% every year. Population was n in year y.
Estimate popluation in final year.

Sample Input
1.6
1987
5000000000
2087

Sample Input Explanation
Line 1: r, growth rate.
Line 2: y, start years.
Line 3: n, population at start year.
Line 4: e, end year.

Sample Output
24453487116

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Find n * (r/100+1)^(e-y) rounded to nearest integer.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to estimate population.
@author Vincent Zhang
@since 04 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Take input as double.
@return input double
-}
readDouble :: IO Double
readDouble = readLn :: IO Double

{-
Take input as integer.
@return input int
-}
readInt :: IO Int
readInt = readLn :: IO Int

{-
Solves the problem.
@return Solution to the problem
-}
main :: IO ()
main = do
    rate <- readDouble
    start <- readInt
    pop <- readDouble
    end <- readInt

    print $ round $ pop * (rate / 100 + 1) ^ (end - start)