module Main(main) where

import Data.List ( group, sort )

freq :: [Char] -> [Int]
freq = sort . map length . group . sort

calc :: [Int] -> [Int]
calc [] = []
calc x
  | length x == 1 = init x
  | otherwise     = init $ init x

main :: IO ()
main = getLine >>= \line -> print . sum . calc $ freq line