-- 0^6 + 1^6 + ... + n^6 %  1000000000 = (1/42)*(n)*(n+1)*(2*n+1)*(3*n*n*n*n + 6*n*n*n - 3*n + 1) % 1000000000

module Main(main) where

main :: IO ()
main = do
    n <- (read::String->Integer) <$> getLine
    let a = n
    let b = n+1
    let c = 2*n+1
    let d = 3*n*n*n*n + 6*n*n*n - 3*n + 1
    print $ mod (div (a*b*c*d) 42) 1000000000