{-
    If their sum is odd, then the direction to turn is left.
    If their sum is even and not zero, then the direction to turn is right.
    If their sum is zero, then the direction to turn is the same as the previous instruction.


57234
00907
34100
99999

right 234
right 907
left 100
-}
module Main(main) where

import Control.Monad
import Data.Text as Tx(Text, drop, take, pack, unpack)

-- https://stackoverflow.com/questions/48369242/in-haskell-how-can-i-get-a-substring-of-a-text-between-two-indices
substring :: Int -> Int -> Tx.Text -> Tx.Text
substring start length = Tx.take length . Tx.drop start

slice :: Int -> Int -> Tx.Text -> Tx.Text
slice start end = Tx.take (end-start) . Tx.drop start

output :: Int -> String
output sum
  | sum == 0  = "-"
  | even sum  = "right"
  | otherwise = "left"

main :: IO ()
main = calc . init. lines getContents

calc :: [String] -> IO ()
calc = foldM_ a ""
  where
    a last line
    let arrInt = map (read . pure :: Char -> Int) line
    let sum = arrInt !! 0 + arrInt !! 1

  let sText = slice 2 5 (Tx.pack line)
  let sStr = Tx.unpack sText



  print(output sum)

  putStrLn(sStr)