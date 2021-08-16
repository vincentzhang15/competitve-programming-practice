{-
--------------------------------------------------------------------------
---------------------------- HASKELL CONCEPTS ----------------------------
1. mapM_
    https://hackage.haskell.org/package/base-4.15.0.0/docs/Prelude.html#v:mapM_
    "
        mapM_ :: (Foldable t, Monad m) => (a -> m b) -> t a -> m ()
        Map each element of a structure to a monadic action, evaluate these actions from left to right, and ignore the results. For a version that doesn't ignore the results see mapM.
        mapM_ is just like traverse_, but specialised to monadic actions.
    "
    Ex. Print contents of list on new lines.
        >>> mapM_ print [1, 2]
        1
        2

------------------------------------------------------------------------------------
---------------------------- BlueBook - Digits and Sums ----------------------------
Output all three-digit numbers between "m" and "n" inclusive such that
the cube of the digits of the three digit-number is equal to the number itself.
Output on new lines.

100 <= m <= n <= 999, where m <= n.

Sample Input
100 200

Sample Input Explanation
m n

Sample Output
153

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
Calculate each number individually.
Extract each digit and find their sum:
    ones digit = num % 10
    tens digit = num / 10 % 10
              OR num % 100 / 10
    hundreds digit = num / 100 % 10
                  OR num % 1000 / 100 (redundant version of the former)

--------------------------------------------------------------------------
---------------------------- PROGRAM COMMENTS ----------------------------
Program to find all three digit numbers between a range whose sum of digits cubed is equal to itself.
@author Vincent Zhang
@since 08 August 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Solves the problem.
@return void
-}
main :: IO ()
main = do
    line <- words <$> getLine
    let m = read (head line) :: Int
    let n = read (last line) :: Int

    -- Find all valid numbers within range [m..n].
    let list = [x | x <- [m..n], mod x 10 ^3 + mod (div x 10) 10 ^3 + mod (div x 100) 10 ^3 == x]

    -- Alternative: putStr $ unlines $ map show list
    mapM_ print list
