{-
---------------------------------------------------------------------------------------
---------------------------- NEWLY LEARNT HASKELL CONCEPTS ----------------------------
1. Haskell Program Structure
    1. main = putStrLn "Hello, world!"
    2.
        module Main(main) where
        main :: IO ()
        main = do
            putStrLn "Hello, world!"

    https://stackoverflow.com/questions/11112371/to-write-or-not-to-write-module-main-where-in-haskell
    "module Main (main) where"
        is an implicit definition when nothing is specified in the header, i.e., default.

2. Output
    https://stackoverflow.com/questions/19288652/difference-between-print-and-putstrln-in-haskell
    https://self-learning-java-tutorial.blogspot.com/2016/05/haskell-print-vs-putstrln.html
    1. putStr ""
        >>> :type putStr
        putStr :: String -> IO ()
    2. putStrLn :: String -> IO ()
        e.g., putStrLn "Hello, world!"
        --> Only takes string input.
        --> Can show non-ASCII characters.
        --> Requires conversion to string for other object printing with putStrLn.
            --> Convert object to string with "show x"
    3. print :: Show a => a -> IO ()
        e.g., print(area)
        e.g., (putStrLn . show) "aaa"
        i.e., print area = putStrLn (show area)
        --> Shows unicode representation of non-ASCII characters because "show" converts strings to unicode represntation.
        --> show :: Show a => a -> String

3. Input
    1. Integer Input
        1. n <- readLn :: IO Int
        2. nStr <- getLine
           let n = (read nStr :: Int)
    2. Skip Line of Input
        import Control.Monad
        void getLine
    3. Store String Input As Integer List
        w <- map read . words <$> getLine :: IO [Int]
        words:
            Parse string to string array delimited by whitespaces.
            http://zvon.org/other/haskell/Outputprelude/words_f.html
            e.g., 
                Input: words "aa bb cc \t dd \n ee"
                Output: ["aa","bb","cc","dd","ee"]
        <$>
            https://hackage.haskell.org/package/base-4.8.2.0/docs/Data-Functor.html#v:-60--36--62-
            https://hackage.haskell.org/package/base-4.15.0.0/docs/Data-Functor.html
            "An infix synonym for fmap."
            fmap id  ==  id
            fmap (f . g)  ==  fmap f . fmap g

             ($)  ::              (a -> b) ->   a ->   b
            (<$>) :: Functor f => (a -> b) -> f a -> f b
        map:
            http://zvon.org/other/haskell/Outputprelude/map_f.html
            "returns a list constructed by appling a function (the first argument) to all items in a list passed as the second argument"
            e.g.,
                Input: map (3*) [1,2,3,4]
                Output: [3,6,9,12]
        (<$> a.k.a., fmap) vs map
            https://stackoverflow.com/questions/6824255/whats-the-point-of-map-in-haskell-when-there-is-fmap#comment-8112310
            fmap: for Functors
            map: for lists

4. Assignment (Variables are Immutable)
    https://stackoverflow.com/questions/35198897/does-mean-assigning-a-variable-in-haskell
    1. Binding
        e.g., let areaTimes10 = area * 10 :: Double
        "let var = expr"
        "assigns a value that is produced by a function (e.g., concatenating some strings)"
    2. Action Assignment
        "var <- action"
        "assigns a value that is produced by an action (e.g., reading a line from standard input)"
    Note: "in list comprehension you get the same assignment syntax as in do-notation"

5. Function Declarations
    https://stackoverflow.com/questions/35198897/does-mean-assigning-a-variable-in-haskell
    Ex1.
    "
        addTwo :: Int -> Int
        addTwo x = x + 2
    "
    Ex2.
    "
        addSquares :: Integer -> Integer
        addSquares x y = squareOfX + squareOfY
            where square z = z * z
                squareOfX = square x
                squareOfY = square y
    "
    Ex3.
    "
        addSquares :: Integer -> Integer
        addSquares x y = 
            let square z = z * z
                squareOfX = square x
                squareOfY = square y
            in squareOfX + squareOfY
    "
    Ex4.
    "
        example :: IO ()
        example = do
            putStrLn "Enter your first name:"
            firstName <- getLine

            putStrLn "Enter your lasst name:"
            lastName <- getLine

            let fullName = firstName ++ " " ++ lastName
            putStrLn ("Hello, " ++ fullName ++ "!")
    "
    Ex5.
        outputResult :: Int -> IO ()
        outputResult n =
            if even n then
                print( half )
            else
                putStrLn(shows half ".5")
            where
                half = div n 2
        outputResult( sum( zipWith (*) w (zipWith (+) (init h) (tail h)) ) )

6. Built-In Functions
    1. truncate :: (RealFrac a, Integral b) => a -> b
        e.g., let areaTimes10Int = truncate(areaTimes10) :: Int
        https://stackoverflow.com/questions/45811770/is-there-a-difference-between-floor-and-truncate-in-haskell
        "truncate x returns the integer nearest x between zero and x"
        Note:
            "floor :: Integral b => a -> b"
            "floor x returns the greatest integer not greater than x"
        truncate() vs floor()
        "
            Prelude> truncate (-3.5)
            -3
            Prelude> floor (-3.5)
            -4
        "

    2. fromIntegral :: (Integral a, Num b) => a -> b
        Converts integer to more general value i.e., Num, e.g., floating-point number.
        e.g., let areaRounded = fromIntegral(areaTimes10Int) / 10 :: Double

        https://stackoverflow.com/questions/23168462/i-dont-understand-t-for-fromintegral
        "This function converts a value of type a (which is an Integral type) to the b type
        (which is an instance of the more general Num class).
        E.g. you cannot add the integer 1 to the float 2 in Haskell without converting the former

        Prelude> (1 :: Int) + (2 :: Float)

        <interactive>:10:15:
            Couldn't match expected type `Int' with actual type `Float'
            ...
        "

    3. even :: Integral a => a -> Bool
        http://zvon.org/other/haskell/Outputprelude/even_f.html
        "
            returns True if the integral is even, False otherwise.
            e.g.,
                Input: even 12
                Output: True
        "

    4. sum :: (Foldable t, Num a) => t a -> a
        http://zvon.org/other/haskell/Outputprelude/sum_f.html
        "
            computes a sum of all elements in the list
            e.g,
                Input: sum [1,2,3,4]
                Output: 10
        "

    5. zipWith :: (a -> b -> c) -> [a] -> [b] -> [c]
        https://stackoverflow.com/questions/4743585/zipwith-function-in-haskell
        "zipWith f [a,b,c] [x,y,z] evaluates to [f a x, f b y, f c z]"

        http://zvon.org/other/haskell/Outputprelude/zipWith_f.html
        "
            makes a list, its elements are calculated from the function and the elements of input lists occuring at the same position in both lists
            Ex1.
                Input: zipWith (+) [1,2,3] [3,2,1]
                Output: [4,4,4]
            Ex2.
                Input: zipWith (**) (replicate 10 5) [1..10]
                Output: [5.0,25.0,125.0,625.0,3125.0,15625.0,78125.0,390625.1,1.95313e+06,9.76563e+06]
            Ex3.
                Input: zipWith (\x y -> 2*x + y) [1..4] [5..8]
                Output: [7,10,13,16]
        "
    
    6. init :: [a] -> [a]
        http://zvon.org/other/haskell/Outputprelude/init_f.html
        "
            it accepts a list and returns the list without its last item
            Ex1.
                Input: init [1,2,3]
                Output: [1,2]
            Ex2.
                Input: init "Hello"
                Output: "Hell"
        "

    7. tail :: [a] -> [a]
        http://zvon.org/other/haskell/Outputprelude/tail_f.html
        "
            accepts a list and returns the list without its first item
            Ex1.
                Input: tail [1,2,3]
                Output: [2,3]
        "

    8. (*) :: Num a => a -> a -> a
        http://www.zvon.org/other/haskell/Outputprelude/G_reference.html
        "
            multiplication operator
            e.g.,
                Input: 2*4*6
                Output: 48
        "

    9. (+) :: Num a => a -> a -> a
        "
            http://zvon.org/other/haskell/Outputprelude/H_o.html
            addition operator
            e.g.,
                Input: 12 + 23 + 34
                Output: 69
        "

    10. ($) :: (a -> b) -> a -> b
        https://stackoverflow.com/questions/940382/what-is-the-difference-between-dot-and-dollar-sign
        https://typeclasses.com/featured/dollar
        $ - remove parentheses
        "
        infixr 0 $
            infixr:
                tells us it’s an infix operator with right associativity.
            0:
                tells us it has the lowest precedence possible.

        In contrast, normal function application (via white space)
            is left associative and
            has the highest precedence possible (10).

        usually see the $ where standard function application wouldn’t have the necessary associativity and precedence for the context.
        And what that means is you usually see it used instead of parentheses to associate things that otherwise wouldn’t

        Ex1.
            λ> sort "julie" ++ "moronuki"
            "eijlumoronuki"

            λ> sort $ "julie" ++ "moronuki"
            "eiijklmnooruu"
        
        Ex2.
            λ> head . sort $ "julie"
            'e'

            λ> head $ sort "julie"
            'e'
        In the first case, it’s the 0-precedence of $ that matters most; in the second case,
        it’s the right-associativity that matters. In the second case, everything on the right gets
        evaluated first, and then head applies to that result.
        "

    11. (.) :: (b -> c) -> (a -> b) -> a -> c
        https://stackoverflow.com/questions/940382/what-is-the-difference-between-dot-and-dollar-sign
        . chain functions, function composition
        "
        Ex1.
            (putStrLn . show) (1 + 1)
        Ex2.
            putStrLn . show $ 1 + 1
        
        infixr 9 .
        (.) :: (b -> c) -> (a -> b) -> (a -> c)
        (f . g) x = f (g x)

        "
    
    12. (.) and ($)
        https://stackoverflow.com/questions/940382/what-is-the-difference-between-dot-and-dollar-sign
        "
        In some cases they are interchangeable, but this is not true in general. The typical example where they are is:
            f $ g $ h $ x
            ==>
            f . g . h $ x
        "

7. More Tutorials To Learn From
    http://www.scs.stanford.edu/14sp-cs240h/
    https://wiki.haskell.org/Haskell_in_5_steps

####################################################################################
############################ CCC '21 S1 - Crazy Fencing ############################
Find the area of a fence made of trapezoid wood pieces where adjacent wood edge heights are equal.

Sample Input 1
3
2 3 6 2
4 1 1

Sample Input 1 Explanation
L1: n, number of wood pieces.
L2: h1...hn+1, left and right heights of wood pieces.
L3: w1...wn, width of wood pieces.

Sample Output 1
18.5

Sample Input 2
4
6 4 9 7 3
5 2 4 1

Sample Output 2
75

########################################################################
############################ SOLUTION LOGIC ############################
Visualizing sample input 1:
              6
              |
              |
          3   |
2         |   |   2
|         |   |   |
| _ _ _ _ | _ | _ |
     4      1   1

Sum the trapezoid areas.
Sum = i=0 Σ n-1 ( w_i + w_i+1 ) * h_i / 2
Sum = 0.5 * ( i=0 Σ n-1 ( w_i + w_i+1 ) * h_i )

i.e., divide by two last since (with Input 1):
(2+3)*4/2 + (3+6)*1/2 + (6+2)*1/2
= (1/2) * [(2+3)*4 + (3+6)*1 + (6+2)*1]

In general this solution process involves 2 steps:
    Step 1: sum of (w_i + w_i+1) * h_i.
        Method 1: loop.
        Method 2:
            Step 1: Add all heights without first element with all heights without last element.
            Step 2: Multiply result by all widths.
            Step 3: Apply sum function.
            Useful for solving with Haskell.
    Step 2: divide sum by 2.
        Note: C++ will convert to scientific notation when a 7-digit number is divided by 2.0.
        Method 1: direct division.
        Method 2: int division/truncate/bitshift and check parity.

-------------------------------------------------------------------------
---------------------------- MODULE COMMENTS ----------------------------
Program to find the area of a fence.
@author Vincent Zhang
@since 27 July 2021
@context Self-Learning Haskell
-}

module Main(main) where

main :: IO ()
main = do
  -- Get input.
  n <- readLn :: IO Int
  h <- map read . words <$> getLine :: IO [Int]
  w <- map read . words <$> getLine :: IO [Int]

  -- Output area.
  print $ (fromIntegral . sum)(   zipWith  (*)  w  $zipWith(+)(init h)(tail h)   ) / 2 :: IO ()