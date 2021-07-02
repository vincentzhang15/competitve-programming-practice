"""
NEWLY LEARNT CONCEPTS SUMMARY

1. PYTHON 3.6 FORMATTED STRING PRINTING
print(f"Minimum perimeter is {perimeter} with dimensions {dimension1} x {dimension2}")

2. PROOF THAT A RECTANGLE WITH MINIMUM AREA IS A SQUARE
Minimize perimeter by finding the minimum value of the perimeter function.
Express the perimeter function in terms of one side length and area since area is constant.
Find values for which the derivative of the perimeter function is 0.
Reject negative side lengths.
Show perimeter function at x-value is minimum by showing the function decreases to the left of the point and increases to the right.
Alternatively show that the second derivative of the perimeter function > 0 since the square root of a value cannot < 0, second derivative at x=sqrt(A) will always > 0. Graph is concave up, thus minimum.

3. BOILERPLATE CODE: https://www.investopedia.com/terms/b/boilerplate.asp
BOILERPLATE TEXT: WRITTEN TEXT THAT CAN BE REUSED EASILY WITHOUT SIGNIFICANT CHANGES IN NEW CONTEXTS OR APPLICATIONS.
Analogously, boilerplate code refers to template code. In this context, __name__ == "__main__" is referred to as boilerplate code.
Boilerplate was a standardized steel plate used as a template in the construction of steam boilers during the 19th century.
"These standardized metal plates reminded editors of the often trite and unoriginal work that ad writers and others sometimes submitted for publication."

4. VOCABULARY: TRITE, HACKNEYED, STEREOTYPED, THREADBARE
https://www.merriam-webster.com/dictionary/trite
https://www.merriam-webster.com/dictionary/hackneyed
https://www.merriam-webster.com/dictionary/stereotyped
https://www.merriam-webster.com/dictionary/threadbare

"
trite: hackneyed or boring from much use : not fresh or original
hackneyed: lacking in freshness or originality
stereotyped: also : lacking originality or individuality 
threadbare: exhausted of interest or freshness

trite, hackneyed, stereotyped, threadbare mean lacking the freshness that evokes attention or interest.
trite applies to a once effective phrase or idea spoiled from long familiarity. "you win some, you lose some" is a trite expression
hackneyed stresses being worn out by overuse so as to become dull and meaningless. all of the metaphors and images in the poem are hackneyed
stereotyped implies falling invariably into the same pattern or form. views of minorities that are stereotyped and out-of-date
threadbare applies to what has been used until its possibilities of interest have been totally exhausted. a mystery novel with a threadbare plot 
"

5. Flat & Nested Data
https://community.tealiumiq.com/t5/TLC-Blog/Flat-vs-Nested-Data-Layer/ba-p/31395
"
Flat object: one level of properties or “key: value” pairs
EXAMPLE:
    var utag_data = {
        product_unit_price : [“12.99”],
        product_list_price : [“15.99”],
        product_discount   : [“0.00”]
    };
Nested object: multiple levels of data, or sub-objects
EXAMPLE:
    var digitalData = {
        page : {
            name : “Shopping Cart”,
            category : “checkout”
        },
        cart : {
            total_value : “31.98”,
            items : [
                {
                    id : “PROD123”,
                    price : {
                        unit : “12.99”,
                    }
                }
            ]
        }
    };
"

6. Data Serialization
https://docs.python-guide.org/scenarios/serialization/
https://www.tutorialspoint.com/object_oriented_python/object_oriented_python_serialization.htm
: process of converting structured data to a format that allows sharing or storage of the data in a form that allows recovery of its original structure.
secondary intention of data serialization is to minimize the data’s size which then reduces DISK space or BANDWIDTH requirements
"
In the context of data storage, serialization is the process of translating data structures or object state into a format that can be stored
(for example, in a file or memory buffer) or transmitted and reconstructed later.

In serialization, an object is transformed into a format that can be stored, so as to be able to deserialize it later and recreate the original object from the serialized format.
"


BINARY
    NumPy Array (flat data)
    Python’s NumPy array can be used to serialize and deserialize data to and from byte representation.
    EXAMPLE:
        import NumPy as np

        # Converting NumPy array to byte format
        byte_output = np.array([ [1, 2, 3], [4, 5, 6], [7, 8, 9] ]).tobytes()

        # Converting byte format back to NumPy array
        array_format = np.frombuffer(byte_output)

    Pickle (nested data)
    "
        Pickling is the process whereby a Python object hierarchy is converted into a byte stream (usually not human readable) to be written to a file,
        this is also known as Serialization. Unpickling is the reverse operation, whereby a byte stream is converted back into a working Python object hierarchy.
        Pickle is operationally simplest way to store the object. The Python Pickle module is an object-oriented way to store objects directly in a special storage format.
    "
    The native data serialization module for Python is called Pickle.
    EXAMPLE:
        import pickle

        #Here's an example dict
        grades = { 'Alice': 89, 'Bob': 72, 'Charles': 87 }

        #Use dumps to convert the object to a serialized string
        serial_grades = pickle.dumps( grades )

        #Use loads to de-serialize an object
        received_grades = pickle.loads( serial_grades )

    "
    In short we can say, pickling is a way to store and retrieve data variables into and out from files where variables can be lists, classes, etc.

    To Pickle something you must −
        import pickle
        Write a variable to file, something like
            pickle.dump(mystring, outfile, protocol),
            where 3rd argument protocol is optional

    To unpickling something you must −
        Import pickle
        Write a variable to a file, something like
            myString = pickle.load(inputfile)
    "

7. Python Pickle
https://www.datacamp.com/community/tutorials/pickle-python-tutorial
"
What is pickling?
Pickle is used for serializing and de-serializing Python object structures, also called marshalling or flattening.
Serialization refers to the process of converting an object in memory to a byte stream that can be stored on disk or sent over a network.
Later on, this character stream can then be retrieved and de-serialized back to a Python object. Pickling is not to be confused with compression!
The former is the conversion of an object from one representation (data in Random Access Memory (RAM)) to another (text on disk),
while the latter is the process of encoding data with fewer bits, in order to save disk space.

What Can You Do With pickle?
    - Save your program's state data to disk
    - send data over a Transmission Control Protocol (TCP) or socket connection
    - store python objects in a database.
    - machine learning algorithms: store predictions without rewrite or retrain the momodel.

When Not To Use pickle
    - use data across different programming languages, because python specific
    - different versions of Python
    - unpickle data from an untrusted source. Malicious code inside the file might be executed upon unpickling.

"

8. Details on __name__ == "__main__"
https://stackoverflow.com/questions/419163/what-does-if-name-main-do
"
It's boilerplate code that protects users from accidentally invoking the script when they didn't intend to. Here are some common problems when the guard is omitted from a script:
    - If you import the guardless script in another script (e.g. import my_script_without_a_name_eq_main_guard),
      then the second script will trigger the first to run at import time and using the second script's command line arguments. This is almost always a mistake.
    - If you have a custom class in the guardless script and save it to a pickle file,
      then unpickling it in another script will trigger an import of the guardless script, with the same problems outlined in the previous bullet.

Whenever the Python interpreter reads a source file, it does two things:
    - it sets a few special variables like __name__, and then
    - it executes all of the code found in the file.

If you are running your module (the source file) as the main program the interpreter will assign the hard-coded string "__main__" to the __name__ variable
    # It's as if the interpreter inserts this at the top
    # of your module when run as the main program.
    __name__ = "__main__" 
When Your Module Is Imported By Another
    # It's as if the interpreter inserts this at the top
    # of your module when it's imported from another module.
    __name__ = "foo"
"

9. Python Modules
https://stackoverflow.com/questions/3558842/if-you-import-yourself-in-python-why-dont-you-get-an-infinite-loop
"Modules are imported only once. Python realizes it already has been imported, so does not do it again."
"When Python encounters an import statement, it checks sys.modules for the presence of the module first before doing anything"
"""

"""
CCC '03 J2 - Picture Perfect
Program to find the smallest perimeter and dimensions of a rectangle given its area. Dimensions must be integers.

Sample Input:
100
15
195
0

Sample Output:
Minimum perimeter is 40 with dimensions 10 x 10
Minimum perimeter is 16 with dimensions 3 x 5
Minimum perimeter is 56 with dimensions 13 x 15

@author Vincent Zhang
@since 28 June 2021
@context Learning Python 3
"""

# Declare and initialize global variable pictures to store the current number of pictures.
pictures = 0

"""
Find one dimension which is the factor of pictures closest to the square root of picutres.
@return Integer factor which is the value closest to the side length of the square form of pictures.
"""
def findDimension():
    # Perimeter of a square is the smallest of rectangles.
    marker = int(pictures ** 0.5)

    # Thus, find the closest integer factor side length to the square form of the pictures.
    for i in range(marker, 0, -1):
        if pictures % i == 0:
            return i

"""
Finds the minimum perimeter and its dimensions.
@return void
"""
def outputMinPerimeter():
    # Obtain first dimension by the function call.
    dimension1 = findDimension()

    # Obtain second dimension by division.
    dimension2 = int(pictures) // dimension1

    # Find perimeter.
    perimeter = 2 * (dimension1 + dimension2)

    # Output result with formatted string since Python 3.6.
    print(f"Minimum perimeter is {perimeter} with dimensions {dimension1} x {dimension2}")

"""
Main method to manage input and output.
@return void
"""
def main():
    # Variable "pictures" need to be modified
    global pictures
    while True:
        pictures = float(input())
        if pictures == 0: break
        outputMinPerimeter()

# Calls the main method. This module is not imported to anywhere so the condition will always be true.
if __name__ == "__main__": main()

"""
https://www.stumblingrobot.com/2015/10/01/prove-that-the-square-has-the-smallest-perimeter-of-all-rectangles-of-a-given-area/
Proof that the rectangle with the least perimeter given its area is a square:

DEFINE VARIABLES
Let "A" be the rectangle's area.
Let "P" be the rectangle's perimeter.
Let "x" be the rectangle's dimension 1.
Let "y" be the rectangle's dimension 2.

ESTABLISH EXISTING RELATIONSHIPS
A = xy
P = 2x + 2y

FIND LOCAL EXTREMA
P(x) = 2x + 2(A/x)
P'(x) = 2 + 2A(-1)/x^2
P'(x) = 2 - 2A/x^2 = 0
x^2 = A
x = (+/-)sqrt(A)

REJECT NEGATIVE SOLUTION SINCE SIDE LENGTH CANNOT BE NEGATIVE
PERIMETER IS MINIMUM AT x IF FUNCTION P AT x IS A LOCAL MINIMUM
x = sqrt(A)
When x < sqrt(A), P'(x) < 0.
When x > sqrt(A), P'(x) > 9.

FUNCTION P AT x=sqrt(A) MUST BE LOCAL MINIMUM SINCE FUNCTION P DECREASES THEN INCREASES AROUND x=sqrt(A).
SINCE DIMENSION 1 IS sqrt(A), DIMENSION 2 MUST BE A/sqrt(A) = sqrt(A).

THUS, THE PERIMETER OF A RECTANGLE IS MINIMIZED AS A SQUARE.
"""