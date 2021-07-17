"""
######################################################################################
############################ CCC '00 S2 - Babbling Brooks ############################

A mountain contains streams that can split or merge at any elevation.
Each stream is numbered 1 to n and the initial volume of each stream is given.
    "99" indicates a stream split where the stream should split left a certain volume given in percentage. The remaining volume stays in the current stream.
        A line of "99" will be followed by a line for the stream number then the volume that forks left.
    "88" indicates a merge of a stream with the stream to its right.
        A line of "88" will be followed by a line for the stream number.
    "77" indicates quit the program.
Output volume of each stream in order from stream 1 to n after "77" rounded to the nearest integer.

Sample Input
3
10
20
30
99
1
50
88
3
88
2
77

Sample Input Explanation
Line 1: n, number of streams initially. The number of streams will never exceed 100 at any point.
Line 2 to n+1: volume of each stream in order from 1 to n initially.
Line n+1+1 to end: commands for stream split, stream merge, or program quit.

Sample Output
5 55

########################################################################
############################ SOLUTION LOGIC ############################
Visualization of the Sample Input:

                  10     20    30
(99 1 50)    5     5     20    30
(88 3)       5     5           50
(88 2)       5                 55

Direct implementation, e.g., with a list or linked list.
The following code show an implementation of the singly linked list from scratch to solve the program.

#########################################################################
############################ MODUEL COMMENTS ############################
@author Vincent Zhang
@since 16 July 2021
@context Python 3 Autodidacticism

"""

"""
Node class for the BrookSinglyLinkedList class.
@author Vincent Zhang
@since 16 July 2021
"""
class BrookNode:
    """
    Initialize values upon instantiation.
    @param this Reference to BrookNode
    @param volume Volume to be set to a BrookNode
    """
    def __init__(this, volume):
        this.volume = volume
        this.next = None

"""
Singly linked list to contain the BrookNodes of the streams on the mountain.
@author Vincent Zhang
@since 16 July 2021
"""
class BrookSinglyLinkedList:
    """
    Initialize linked list value upon instantiation.
    @param self Reference to the BrookSinglyLinkedList class
    """
    def __init__(self):
        self.root = None # An empty linked list has a "None" root value.

    """
    Add to the end of the linked list.
    @param self Reference to the BrookSinglyLinkedList class
    @param node The BrookNode to append to the end of the linked list
    @return void
    """
    def append(self, node):
        # If no root, self.root.next will cause error.
        if self.root == None:
            self.root = node
            return

        # Process non-root situations.
        curr = self.root
        while curr.next != None:
            curr = curr.next
        curr.next = node

    """
    Insert BrookNode to the linked list at an index.
    @param self Reference to the BrookSinglyLinkedList class
    @param streamNumber The number of the stream to insert the node to
    @param node The node that needs to be inserted
    @return void
    """
    def insert(self, streamNumber, node):
        # Handle special case when root needs to be overriden.
        if streamNumber == 1:
            node.next = self.root
            self.root = node
            return

        # Non-root cases.
        curr = self.root
        for _ in range (streamNumber-2): # Singly linked lists do not have "prev" attribute.
            curr = curr.next
        node.next = curr.next
        curr.next = node
        
    """
    Return the node to be processed.
    @param self Reference to the BrookSinglyLinkedList class
    @param streamNumber The iteration count to find the desired BrookNode
    @return The node that needs to be processed
    """
    def findNode(self, streamNumber):
        curr = self.root
        for _ in range(streamNumber-1):
            curr = curr.next
        return curr
    """
    Method directly used by the main program to split the stream.
    @param self Reference to the BrookSinglyLinkedList class
    @param streamNumber The number of the stream to split
    @param volumePercent The percentage of the stream that needs to split left
    @return void
    """
    def splitLeft(self, streamNumber, volumePercent):
        curr = self.findNode(streamNumber)

        leftVolume = curr.volume * volumePercent * 0.01
        rightVolume = curr.volume - leftVolume

        curr.volume = rightVolume
        self.insert(streamNumber, BrookNode(leftVolume))

    """
    Method directly used by the main program to merge target stream with the stream to its right.
    @param self Reference to the BrookSinglyLinkedList class
    @param streamNumber The number of the stream that needs to merge to the right
    @return void
    """
    def mergeRight(self, streamNumber):
        # Process root case.
        if streamNumber == 1:
            volume = self.root.volume + self.root.next.volume
            self.root.next.volume = volume
            self.root = self.root.next
            return

        # Process non-root case.
        curr = self.findNode(streamNumber-1)
        volume = curr.next.volume + curr.next.next.volume
        curr.next.next.volume = volume
        curr.next = curr.next.next

    """
    Output the main program's required output.
    @param self Reference to the BrookSinglyLinkedList class
    @return void
    """
    def print(self):
        curr = self.root
        output = ""
        while(curr != None):
            output += str(round(curr.volume)) + " "
            curr = curr.next
        print(output.rstrip())

# Fast input.
import sys; input = sys.stdin.readline

"""
Main method to solve the problem.
@return void
"""
def main():
    # Store initial state.
    streams = BrookSinglyLinkedList()
    for _ in range(int(input())):
        streams.append( BrookNode( float(input()) ) )

    # Simulate stream flow.
    while 1:
        command = int(input())
        if command == 77: break
        elif command == 99: streams.splitLeft(int(input()), int(input())) # Stream number, volume percent.
        elif command == 88: streams.mergeRight(int(input())) # Stream number.
    streams.print()

# Calls main only when program is run within this module.
if __name__ == "__main__": main()