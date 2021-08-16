{-
--------------------------------------------------------------------------
---------------------------- BlueBook - Sieve ----------------------------
For the first "N" numbers (1 <= n <= 500), print whether it is prime
denoted by "0" or "1", using the Sieve of Eratosthenes algorithm.

Sample Input
9

Sample Output
0
1
1
0
1
0
1
0
0

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Direct implementation.

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to implement the Sieve of Eratosthenes algorithm.
@author Vincent Zhang
@since 10 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Driver code for the Sieve of Eratosthenes algorithm.
@return Infinite list of primes
-}
primes :: [Int]
primes = sieve [2..]

{-
Performs the Sieve of Eratosthenes algorithm.
@param List of prospective prime numbers to perform checking on
@return Infinite list of prime numbers
-}
sieve :: [Int] -> [Int]
sieve (p:dat) = p : sieve [x | x <- dat, mod x p /= 0]

{-
Solves the problem.
@return Print result
-}
main :: IO ()
main = do
    nn <- getLine
    let n = read nn :: Int

    let prime = take n primes
    let dat = [1..n]
    let isPrime = map (\x -> elem x prime) dat
    let isPrimeInt = map (\x -> if not x then "0" else "1") isPrime
    putStr $ unlines isPrimeInt