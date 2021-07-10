"""
##############################################################################################
############################ NEWLY LEARNT PYTHON CONCEPTS SUMMARY ############################
1. Fast Python 3 Input
    In replacement for input():
    import sys; row = sys.stdin.readline()

2. List Multiplier Mistake.
    visibleRow = [0] * gridRows --> [0, 0, 0, ... , 0]
    visibleRow = [0 * gridRows] --> [0] because "0 * gridRows" is treated as multiplication.

3. Python enumerate(iterable, startIterationIndex)
    https://www.geeksforgeeks.org/enumerate-in-python/
    Adds counter to an iterable. Select iteration starting index.
    Returns an enumerate object.
    list(enumerate) creates a list of 2 object tuples of index value pairs.
    "
    >>> s1 = "geek"
    >>> print (list(enumerate(s1,2)))
    [(2, 'g'), (3, 'e'), (4, 'e'), (5, 'k')]
    "

4. Python bool(int)
    return int != 0
    i.e., 0 is False, any other int is True.

5. Python isinstance(obj, class)
    https://stackoverflow.com/questions/4260280/if-else-in-a-list-comprehension
    "
    >>> X = [1.5, 2.3, 4.4, 5.4, 'n', 1.5, 5.1, 'a']
    >>> X_str_changed = ['b' if isinstance(el, str) else el for el in X]
    "

6. List Comprehension With If/Else
    https://stackoverflow.com/questions/4260280/if-else-in-a-list-comprehension
    https://www.w3schools.com/python/python_lists_comprehension.asp
    https://stackoverflow.com/questions/2951701/is-it-possible-to-use-else-in-a-list-comprehension

    Conditional list comprehension has 2 cases:
        --> if only
            Syntax:
                for ___:
                    if ___: newList.append(VAL)
                -->
                newList = [VAL for ___ if ___]

                "EXPRESSION for ITEM in ITERABLE if CONDITION"
            Examples:
                "
                >>> [f(x) for x in sequence if condition]
                
                >>> X = [1.5, 2.3, 4.4, 5.4, 'n', 1.5, 5.1, 'a']
                >>> X_non_str = [el for el in X if not isinstance(el, str)]
                "
        --> if and else only
            Syntax:
                for ___: newList.append(ternary) --> newList = [ternary for ___]
                "EXPRESSION1 if CONDITION else EXPRESSION2 for ITEM in ITERABLE"
            Examples:
                "
                >>> [a if a else 2 for a in [0,1,0,3]]
                [2, 1, 2, 3]

                >>> [unicode(x.strip()) if x is not None else   '' for x in row]
                >>> [              f(x) if     condition else g(x) for x in sequence]

                >>> X = [1.5, 2.3, 4.4, 5.4, 'n', 1.5, 5.1, 'a']
                >>> X_str_changed = ['b' if isinstance(el, str) else el for el in X]
                "
    
    Recall: no elif allowed as ternary operation supports only if else.
    Wordaround: nest ternaries.

7. Find Indices Where a Character Appears in a String.
    for j in [col for col, char in enumerate(row) if char == 'X']:
    
    Recall: enumerate() returns enumerate object, assigning index to object in an index object pair. list(enumerate) --> [(idx, obj), ..., (idx, obj)].

8. Argument-Unpacking & Keyword-Argument-Unpacking Operators
    https://www.geeksforgeeks.org/packing-and-unpacking-arguments-in-python/
    https://docs.python.org/3/tutorial/controlflow.html#unpacking-argument-lists
    https://stackoverflow.com/questions/400739/what-does-asterisk-mean-in-python
    https://stackoverflow.com/questions/36901/what-does-double-star-asterisk-and-star-asterisk-do-for-parameters

    OVERVIEW
    "write the function call with the *-operator to unpack the arguments out of a list or tuple"
    "
    If the form *identifier is present, it is initialized to a tuple receiving any excess positional parameters, defaulting to the empty tuple.
    If the form **identifier is present, it is initialized to a new dictionary receiving any excess keyword arguments, defaulting to a new empty dictionary.
    "
    "The *args and **kwargs is a common idiom to allow arbitrary number of arguments to functions"

    SIX CASES (4: Positional/Keyword Arguments/Parameters + 1: Compound Case + 1: Extended Iterable Unpacking)
    1. Positional Parameters
        "
        The *args will give you all function parameters as a tuple:
            EXAMPLE 1:
            def foo(*args):
                for a in args:
                    print(a)        

            foo(1)
            # 1

            foo(1,2,3)
            # 1
            # 2
            # 3

            EXAMPLE 2:
            # Excess positional argument (python 2) example:
            def foo(a, b, c, *args):
                print "a = %s" % (a,)
                print "b = %s" % (b,)
                print "c = %s" % (c,)
                print args

            foo("testa", "testb", "testc", "excess", "another_excess")

            OUTPUT 2:
            a = testa
            b = testb
            c = testc
            ('excess', 'another_excess')

            EXAMPLE 3:
            def foo(a,b,c,*args):
                print "a=%s" % (a,)
                print "b=%s" % (b,)
                print "c=%s" % (c,)
                print "args=%s" % (args,)

            argtuple = ("testa","testb","testc","excess")
            foo(*argtuple)

            OUTPUT 3:
                a=testa
                b=testb
                c=testc
                args=('excess',)

            EXAMPLE 4:
            >>> def foo(*args):
            ...     print(args)
            ...
            >>> l = [1,2,3,4,5]

            EXAMPLE 5:
            >>> foo(*l)
            (1, 2, 3, 4, 5)

            EXAMPLE 6 [IMPORTANT]:
            def some_function(parm1, parm2, callback, *callback_args):
                a = 1
                b = 2
                ...
                callback(a, b, *callback_args)
                ...
            def my_callback_function(a, b, x, y, z):
                ...

            x = 5
            y = 6
            z = 7

            some_function('parm1', 'parm2', my_callback_function, x, y, z)
        "

    2. Keyword Parameters
        "
        The **kwargs will give you all keyword arguments except for those corresponding to a formal parameter as a dictionary.
            EXAMPLE 1:
            def bar(**kwargs):
                for a in kwargs:
                    print(a, kwargs[a])  

            bar(name='one', age=27)
            # name one
            # age 27
            
            EXAMPLE 2:
            # Excess keyword argument (python 2) example:
            def foo(a, b, c, **args):
                print "a = %s" % (a,)
                print "b = %s" % (b,)
                print "c = %s" % (c,)
                print args

            foo(a="testa", d="excess", c="testc", b="testb", k="another_excess")

            OUTPUT 2:
            a = testa
            b = testb
            c = testc
            {'k': 'another_excess', 'd': 'excess'}

            EXAMPLE 3:
            def foo(a,b,c,**args):
                print "a=%s" % (a,)
                print "b=%s" % (b,)
                print "c=%s" % (c,)
                print "args=%s" % (args,)

            argdict = dict(a="testa", b="testb", c="testc", excessarg="string")
            foo(**argdict)

            OUTPUT 3:
            a=testa
            b=testb
            c=testc
            args={'excessarg': 'string'}
        "
    3. Positional Arguments
        "
        Another usage of the *l idiom is to unpack argument lists when calling a function.
            def foo(bar, lee):
                print(bar, lee)

            l = [1,2]

            foo(*l)
            # 1 2
        "
    4. Keyword Arguments
        "
        It is also possible to use this the other way around:
            EXAMPLE 1:
            def foo(a, b, c):
                print(a, b, c)

            obj = {'b':10, 'c':'lee'}

            foo(100,**obj)
            # 100 10 lee

            EXAMPLE 2:
            >>> def foo(**argd):
            ...     print(argd)
            ...
            >>> d = {'a' : 'b', 'c' : 'd'}
            >>> foo(**d)
            {'a': 'b', 'c': 'd'}
        "
    5. Positional and Keyword Parameters Compound Case
        "
        Both idioms can be mixed with normal arguments to allow a set of fixed and some variable arguments:
            def foo(kind, *args, **kwargs):
            pass
        "
    6. Extended Iterable Unpacking
        "
        In Python 3 it is possible to use *l on the left side of an assignment (Extended Iterable Unpacking), though it gives a list instead of a tuple in this context:
            first, *rest = [1,2,3,4]
            first, *l, last = [1,2,3,4]
        "

9. Function Signature
    https://stackoverflow.com/questions/2965271/forced-naming-of-parameters-in-python/14298976#14298976
    https://stackoverflow.com/questions/28243832/what-is-the-meaning-of-a-forward-slash-in-a-python-method-signature-as-show
    https://stackoverflow.com/questions/36901/what-does-double-star-asterisk-and-star-asterisk-do-for-parameters

    Note: "/" to define positional-only parameters works only in Python 3.8+.
        >>> def foo(a, b, /, c, d, *, e, f, **g): print(a, b, c, d, e, f, g)
        >>> foo(1, 2, 3, d=4, e=5, f=6, g={"7":7, "8":8})
        1 2 3 4 5 6 {'g': {'7': 7, '8': 8}}
    Additional argument-unpacking not allowed anywhere.
    Must have "g=__" since keyword-only parameters after asterisk.

    "
    Also Python 3 adds new semantic (refer PEP 3102):
        def func(arg1, arg2, arg3, *, kwarg1, kwarg2):
            pass
    Such function accepts only 3 positional arguments, and everything after * can only be passed as keyword arguments.
    "

    "
    Parameters after “*” or “*identifier” are keyword-only parameters and may only be passed used keyword arguments.

    This can also be combined with **kwargs:
    def foo(pos, *, forcenamed, **kwargs):
    "

    "
    # a, b are positional-only. e,f keyword-only
    def f(a, b, /, c, d, *, e, f):
        print(a, b, c, d, e, f)

    # valid call
    f(10, 20, 30, d=40, e=50, f=60)

    # invalid calls:
    f(10, b=20, c=30, d=40, e=50, f=60)   # b cannot be a keyword argument
    f(10, 20, 30, 40, 50, f=60)           # e must be a keyword argument
    "

10. Argument Terminology
    https://stackoverflow.com/questions/9450656/positional-argument-v-s-keyword-argument
    "
    Positional arguments are arguments that can be called by their position in the function definition.
    Keyword arguments are arguments that can be called by their name.
    Required arguments are arguments that must passed to the function.
    Optional arguments are argument that can be not passed to the function. In python optional arguments are arguments that have a default value.
    "

    "
        def fn (a, b, c = 1):          # a/b required, c optional.
            return a * b + c

        print fn (1, 2)                # returns 3, positional and default/optional.
        print fn (1, 2, 3)             # returns 5, positional.
        print fn (c = 5, b = 2, a = 2) # returns 9, named/keyword.
        print fn (b = 2, a = 2)        # returns 5, named/keyword and default/optional.
        print fn (5, c = 2, b = 1)     # returns 7, positional and named/keyword.
        print fn (8, b = 0)            # returns 1, positional, named/keyword and default/optional.
    "

11. Function Default Parameter Values
    https://docs.python.org/3/tutorial/controlflow.html#unpacking-argument-lists
    https://stackoverflow.com/questions/9450656/positional-argument-v-s-keyword-argument

    OPTIONAL value for parameter when calling function with default parameter value.

    CODE:
    "
    def parrot(voltage, state='a stiff', action='voom'):
        print("-- This parrot wouldn't", action, end=' ')
        print("if you put", voltage, "volts through it.", end=' ')
        print("E's", state, "!")

    d = {"voltage": "four million", "action": "VOOM"}
    parrot(**d)
    "
    OUTPUT:
    -- This parrot wouldn't VOOM if you put four million volts through it. E's a stiff !

    EXPLANATION:
        --> "a stiff" is the function default not given through "d".
        --> Error occurs without "voltage" in "d":
            TypeError: parrot() missing 1 required positional argument: 'voltage'

12. Python zip()
    https://www.geeksforgeeks.org/python-column-wise-sum-of-nested-list/
    https://www.w3schools.com/python/ref_func_zip.asp

    "
    zip() function returns a zip object, which is an iterator of tuples where
    the first item in each passed iterator is paired together, and then
    the second item in each passed iterator are paired together etc.
    If the passed iterators have different lengths, the iterator with the least items decides the length of the new iterator.

    Syntax: zip(iterator1, iterator2, iterator3 ...)
    "

    Example 1:
        a = (1, 2, 3)
        b = [2, 4, 6, 8]
        c = {"a":"A", "b":"B", "c":"C"}

        print(tuple(zip(a, b, c)))
    Output:
        ((1, 2, 'a'), (2, 4, 'b'), (3, 6, 'c'))

    Example 2:
        areaMap = [[], [], ... ]
        colSum = sum(list(zip(*areaMap))[col])

13. Find List of Indices of Char Occurance in String
    https://stackoverflow.com/questions/11122291/how-to-find-char-in-string-and-get-all-the-indexes
    newList = [idx for idx, char in enumerate(STRING) if char == ch]

#############################################################################
############################ PROBLEM DESCRIPTION ############################
DMOPC '17 Contest 1 P1 - Fujō Neko
A grid contains objects denoted by "X" which can see vertically and horizontally.
Determine whether coordinates on this grid falls under the line of sight of any object.

Sample Input:
4 5
X....
....X
.....
..X..
4
2 3
4 4
1 1
5 4

Sample Input Explanation:
Line 1: r, c, number of rows and columns of the grid.
Line 2 to r+1: the grid where "X" is an object, and "." is an empty space.
Line r+2: q, number of queries.
Line r+3 to r+3+q: c, r, coordinates of the query representing the column and row.

Sample Output:
N
Y
Y
Y

########################################################################
############################ SOLUTION LOGIC ############################
Approach 1 [SLOW]: Perspective From Query Coodinates (map is unprocessed, so query answer is based on query coordinates)
    Represent the grid with a 2D integer list. Determine if coordinate is in line of sight by finding the row and column sum.
    rowSum = sum(areaMap[row])
    colSum = sum(list(zip(*areaMap))[col])

Appraoch 2: Perspective From Objects (checking objects' sight grid)
    Represent the grid with a 2D boolean list. The list represents whether a cell is in line of sight.
    Redundancy evident when adding a nest in looping to store "True" column and row values in the list.
    Notable mention: if only entire columns need to be changed, one could make use of the multiplier when initalizing the 2D list.
        Though, this does further manifest the redundancy.

Approach 3: Perspective From Objects (checking objects' line of sight)
    Use two 1D int/boolean lists to represnt the row and column that are visible.
    Note: 0, 1 values can be used interchangably with boolean values in Python, likewise with C++, but not in Java.

Approach 4: Perspective From Query Coordinates (finding existance of "X" in strings based on query)
    Use two 1D string lists to reprsent the row and column that are visible.

#########################################################################
############################ MODULE COMMENTS ############################
@author Vincent Zhang
@since 09 July 2021
@context Learning Python 3
"""

# Import sys module for faster input using sys.stdin.readline().
import sys

# Number of rows and columns of the grid.
gridRows, gridCols = map(int, sys.stdin.readline().split())

# Stores the rows and columns that are visible from objects.
visibleRow = [0] * gridRows
visibleCol = [0] * gridCols

# Process the map by marking visible rows and columns.
for i in range(gridRows):
    # Row in the map.
    row = sys.stdin.readline()

    # Row visible.
    if 'X' in row:
        visibleRow[i] = 1

    # Column visible.
    for j in [col for col, char in enumerate(row) if char == 'X']:
        visibleCol[j] = 1
    
# Answer queries.
queries = int(sys.stdin.readline())
for _ in range(queries):
    colCoord, rowCoord = map(int, sys.stdin.readline().split())
    print("Y") if visibleRow[rowCoord-1] or visibleCol[colCoord-1] else print("N")