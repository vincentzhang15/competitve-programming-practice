{-
----------------------------------------------------------------------------------------
---------------------------- BlueBook - 10 Primes on a Line ----------------------------
Print the first "m" (5 <= m <= 500) primes, 10 to a line, interspersed by spaces.

Sample Input
5

Sample Output
2 3 5 7 11

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Pre-compute primes with the Sieve of Eratosthenes algorithm:
    Every multiple of a prime is not prime.
    Start with 2, 2 is prime.
    Mark all multiples of 2 as not prime.
    The first of all subsequent primes are prime and all multiples of such numbers are composites.

--------------------------------------------------------------------------
---------------------------- Program Comments ----------------------------
Program to print the first "m" primes.
@author Vincent Zhang
@since 09 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Solves the problem.
@return void
-}
main :: IO ()
main = getLine >>= \n -> printTen $ take (read n :: Int) primes
        -- Printing.
  where printTen xs = do
          putStrLn $ unwords $ map show $ take 10 xs
          if null xs then
            putStr ""
          else
            printTen $ drop 10 xs
        -- Prime handling.
        primes = sieveEratosthenes [2..]
          where sieveEratosthenes (p:dat) = p : sieveEratosthenes [x | x <- dat, mod x p /= 0]