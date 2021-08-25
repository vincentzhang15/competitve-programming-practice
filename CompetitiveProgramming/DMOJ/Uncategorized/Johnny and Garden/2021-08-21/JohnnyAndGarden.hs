module Main(main) where

import Data.List ( elemIndex )
import Data.Text ( Text, drop, pack, unpack, take )
import Data.Char ( toLower )

slice :: Int -> Int -> Text -> Text
slice start end = Data.Text.take (end-start) . Data.Text.drop start

main :: IO ()
main = do
  a <- getLine
  let b = elemIndex '.' a
  case b of
    Just b -> do
      putStr . show $ slice 0 b (pack a)
      putStr " - "
      putStr . map toLower . unpack $ slice (b+1) (length a) (pack a)
    Nothing -> do
      c <- getLine
      putStr . show $ a
      putStr " - "
      putStr . map toLower $ c
