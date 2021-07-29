{-
-------------------------------------------------------------------------------------------
---------------------------- DMOPC '20 Contest 5 P1 - Home Row ----------------------------
Given two strings, find the minimum keystrokes to change the first string to the second string.
Strings will always be lowercase alphabet characters.
Keystrokes available:
    1. Type a lowercase letter.
    2. Delete a letter from the end of the string.

Sample Input 1
adachi
shimamura

Sample Output
15

Sample Input 2
shinomiya
shirogane

Sample Output 2
12

------------------------------------------------------------------------
---------------------------- SOLUTION LOGIC ----------------------------
A matching prefix is the only part of the first string that does not need to be changed.
Every subsequent character in the first string needs to be deleted from the string.
Every subsequent character in the second string needs to be added to the first string.

Procedural Programming Langage Implementation (see HomeRow.py .cpp .c .java)
    Step 1: loop through characters in both strings to find the length of the equal prefix.
    Step 2: calculate result.
        Method 1: len(s1)+len(s2) - 2 * number of non equivalent characters.
            e.g,
              aaaaabcde    -> aaaaa bcde
              aaaaacdefghi -> aaaaa cdef    ghi
              +len                  -2*len
        Method 2: 2*non equivalent chars + diff in string lengths
            e.g,
              aaaaabcde    -> aaaaa bcde
              aaaaacdefghi -> aaaaa cdef    ghi
                                    2*len   +len

Functional Programming Language Implementation (see HomeRow.hs)
    Method 1: drop all matching characters with a recursive function.
        This leaves a list with length equal to number of non-equivalent chars.
        Apply Method 2 formula in the procedural section above.
    Method 2: find the first index where different chars occur (in forward or reverse direction).
        With the index, apply Method 1 formula in the procedural section above.
        This method is slower than Method 1 for long strings in Haskell because Haskell's (!!) operator is O(N).
        Which means, the recursive calls to find the index will be costly, especially if trying to find index at end with forward find and front index with reverse find.

-------------------------------------------------------------------------
---------------------------- MODULE COMMENTS ----------------------------
Program to find the minimum keystrokes required to make the first string identical to the second.
@author Vincent Zhang
@since 29 July 2021
@context Self-Learning Haskell
-}

module Main(main) where

{-
Function to find the index of the first occurance of a non-equivalent character in a forward direction.
@param i Starting index, index is in forward order
@param xs List to search in
@return index of first non-equivalent character.
-}
idxFwd' :: Int -> [(Char, Char)] -> Int
idxFwd' i xs
  | quit      = i -- Base case.
  | cmpr      = i -- Found.
  | otherwise = idxFwd' (i+1) xs -- Recursive case.
  where quit = i == length xs
        elem = xs !! i
        cmpr = fst elem /= snd elem

{-
Function to find the index of the first occurance of a non-equivalent character in a reverse direction.
@param n Starting index, index is in reverse order
@param xs List to search in
@return index of the first non-equivalent character
-}
idxRev' :: Int -> [(Char, Char)] -> Int
idxRev' 0 xs = length xs -- Base case.
idxRev' n xs
  | fst val /= snd val = i -- Found.
  | otherwise          = idxRev' (n-1) xs -- Recursive case.
  where i   = length xs - n
        val = xs !! i

{-
Function to find the list of characters with the common prefix removed.
@param n Number of elements left in the list
@param xs The list to operate on
@return the list of characters with the common prefix removed
-}
drop' :: Int -> [(Char, Char)] -> [(Char, Char)]
drop' _ [] = [] -- Empty list.
drop' 0 xs = xs -- Base case.
drop' n xs =
  if (fst . head) xs /= (snd . head) xs then
    xs -- Removed all possible characters. 
  else
    drop' (n-1) (tail xs) -- Recursive case.

-- Alternative one-liner (drop method).
-- main = getLine >>= \s1 -> getLine >>= \s2 -> print $ (+) (abs $ length s1 - length s2) $ (*) 2 (length $ drop' ((min (length s1) (length s2))) (zip s1 s2))
main :: IO ()
main = do
  s1 <- getLine
  s2 <- getLine
  let s = zip s1 s2 -- Create list of tuples by pairing characters in first and second string by index. Automatic truncation by least number of characters.

  {-
  -- Index method. (Slower.)
  let idx = idxFwd' 0 s -- Forward find.
  -- let idx = idxRev' (min (length s1) (length s2) ) (zip s1 s2) -- Reverse find.
  print $ length s1 + length s2 - 2 * idx
  -}

  --{-
  -- Drop method.
  let diffLen = abs $ length s1 - length s2
  let diffChr = length $ drop' (length s) s 
  print $ (+) diffLen $ (*) 2 diffChr
  ---}