/*
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// CCC '00 S2 - Babbling Brooks ////////////////////////////
Streams that run down from the top of a mountain may split or join.
Streams are numbered 1 to n from left to right on the mountain at an elevation.
    "99" indicates a stream split.
        The stream number will be given, indicating that some percent of that stream should fork left while the remaning amount should stay in the current stream.
        Volume of the stream that should split left is given as a percentage.
    "88" indicates a stream merge.
        The stream number will be given, indicating that the stream at the number should merge with the stream to the right.
    "77" indicates program termination.
Output the volume for each stream rounded to the nearest integer.

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
Line 1: n, number of streams.
Line 2 to n+1: initial volume in the streams.
Line n+1 to end: commands for stream split or merge, or program termination.

Sample Output
5 55

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Simulation of the Sample Input
    10    20    30    (99 1 50)
5    5    20    30    (88 3)
5    5    50          (88 2)
5   55                (77)

Direct implementation.
Key operations:
    1. Insert at index.
        a. At end when first populating some data structure.
            LinkedList: O(1) insert.
            ArrayList: O(1) add.
        b. Somewhere in the data structure when splitting stream.
            LinkedList: O(N) find. O(1) insert.
            ArrayList: O(1) find. O(N) insert.
    2. Delete at index.
        a. Merging.
            LinkedList: O(N) find. O(1) delete.
            ArrayList: O(1) find. O(N) delete.
    3. Output rounded volume.
        a. Traverse entire data structure ncessary.
            LinkedList: O(N) traversal.
            ArrayList: O(N) traversal.

Ultimately, data structure choice is a decision between faster finding or faster insert/delete.
Since the problem states that there will be at most 100 streams at anytime,
    finding in O(N) time is not as costly as O(N) insertion/deletion.
Thus, a LinkedList is optimal.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Node class for the BrookNode doubly linked list, i.e., the BrookDoublyLinkedList class.
 * @author Vincent Zhang
 * @since 16 July 2021
 */
class BrookNode
{
    // Member/instance variables. Manifestation of encapsulation.
    private Object volume;
    private BrookNode next;
    private BrookNode prev;

    /**
     * Initialize values.
     * @param volume Volume value to set to instance variable.
     */
    public BrookNode(Object volume)
    {
        this.volume = volume;
        this.next = null;
        this.prev = null;
    }

    /**
     * Sets the volume.
     * @param volume The volume to be set
     */
    public void setVolume(Object volume)
    {
        this.volume = volume;
    }

    /**
     * Set link to next BrookNode
     * @param next The next BrookNode
     */
    public void setNext(BrookNode next)
    {
        this.next = next;
    }

    /**
     * Set link to previous BrookNode
     * @param prev The previous BrookNode
     */
    public void setPrev(BrookNode prev)
    {
        this.prev = prev;
    }

    /**
     * Get the volume of the current node.
     * @return The volume of the current node
     */
    public Object getVolume()
    {
        return volume;
    }

    /**
     * Get the next BrookNode.
     * @return next BrookNode
     */
    public BrookNode getNext()
    {
        return next;
    }

    /**
     * Get the previous BrookNode.
     * @return previous BrookNode
     */
    public BrookNode getPrev()
    {
        return prev;
    }
}

/**
 * Custom doubly linked list to simulate the Babbling Brooks.
 * @author Vincent Zhang
 * @since 16 July 2021
 */
class BrookDoublyLinkedList
{
    ////////////////////////////////
    //////// Initialization ////////
    private BrookNode root; // Reference to root of doubly linked list.
    private BrookNode end; // Reference to end of doubly linked list.
    private int size; // Number of nodes in doubly linked list.

    /**
     * Initialize values.
     */
    public BrookDoublyLinkedList()
    {
        root = null;
        end = null;
        size = 0;
    }
    ////////////////////////////////
    ////////////////////////////////


    /////////////////////////////////////////////
    //////// Typical Linked List Methods ////////
    /**
     * Determine if doubly linked list is empty.
     * @return Whether doubly linked list is empty.
     */
    public boolean isEmpty()
    {
        return root == null;
    }

    /**
     * Determine size of doubly linked list.
     * @return size of doubly linked list
     */
    public int size()
    {
        return size;
    }
    /////////////////////////////////////////////
    /////////////////////////////////////////////


    //////////////////////////
    //////// Printing ////////
    // Note: a printing method, printStreams(), is placed under "Methods Directly Used By Program Solution".
    // Note: a printing method, print(),        is placed under "Crucial Helper Methods".
    /**
     * Prints nodes in the doubly linked list.
     * Specifically, the volume of the previous node, current node, and next node.
     * @return void
     */
    public void debugPrint()
    {
        BrookNode current = root;
        while(current != null)
        {
            String output = "";
            output += current.getPrev() == null ? "null " : current.getPrev().getVolume() + " ";
            output += current.getVolume() + " ";
            output += current.getNext() == null ? "null" : current.getNext().getVolume();
            System.out.println(output);
            current = current.getNext();
        }
    }

    /**
     * Print unrounded streams to check calculation. Identical to printStreams() except the rounding.
     * @return void
     */
    public void debugPrintStreams()
    {
        BrookNode current = root;
        String output = "";
        while(current != null)
        {
            output += current.getVolume() + " ";
            current = current.getNext();
        }
        System.out.println(output.trim());

        return;
    }
    //////////////////////////
    //////////////////////////


    ///////////////////////////
    //////// Inserting ////////
    // Note: an inserting method, insert(BrookNode stream), is placed under "Methods Directly Used By Program Solution". This is the insert at end method.
    // Note: the insert() methods manifest static polymorphism, a.k.a. method overloading.
    /**
     * Set root value.
     * @param stream Value to assign to root
     * @return Whether initialization was successful
     */
    private boolean initializeRoot(BrookNode stream)
    {
        root = stream;
        end = root;
        size++;
        return true;
    }

    /**
     * Insert at the start of the doubly linked list, i.e., update root.
     * @param stream The BrookNode to be inserted
     * @return Whether insert was successful
     */
    private boolean insertRoot(BrookNode stream)
    {
        stream.setNext(root);
        root = stream;
        root.getNext().setPrev(root);
        size++;
        return true;
    }

    /**
     * Insert in middle, i.e., somewhere between root and end.
     * Reconnects the links to succesfully insert into the doubly linked list.
     * @param stream The BrookNode not part of the doubly linked list and should be inserted
     * @param current The node before which to insert the "stream"
     * @return Whether insert was successful
     */
    public boolean insert(BrookNode stream, BrookNode current)
    {
        // Swap bonds.
        /* Initial State
            --------       -------- 
            | PREV | ----> | CURR |
            |      | <---- |      |
            --------       --------
                                
                    --------
                    |STREAM|
                    |      |
                    --------
        */

        /* Set "STREAM"'s Prev & Next Bonds
            --------       -------- 
            | PREV | ----> | CURR |
            |      | <---- |      |
            --------       --------
                   ↖       ↗  
                    --------
                    |STREAM|
                    |      |
                    --------
        */
        stream.setNext(current);
        stream.setPrev(current.getPrev());

        /* Overwrite "PREV"'s Next Bond
            --------       -------- 
            | PREV |       | CURR |
            |      | <---- |      |
            --------       --------
                 ↘ ↖       ↗
                    --------
                    |STREAM|
                    |      |
                    --------
        */
        current.getPrev().setNext(stream);

        /* Overwrite "CURR"'s Prev Bond
            --------       -------- 
            | PREV |       | CURR |
            |      |       |      |
            --------       --------
                 ↘ ↖       ↗ ↙
                    --------
                    |STREAM|
                    |      |
                    --------
        */
        current.setPrev(stream);

        /* Insertion Completed State
            --------       --------       --------
            | PREV | ----> |STREAM| ----> | CURR |
            |      | <---- |      | <---- |      |
            --------       --------       --------
        */

        size++;
        return true;
    }

    /**
     * Insert BrookNode at index.
     * @param stream The BrookNode to be inserted
     * @param index The index to insert the node at
     * @return Whether insert was successful
     */
    public boolean insert(BrookNode stream, int index)
    {
        // Exceptions and end-point conditions.
        if(index < 0 || index > size)       return false;                  // If index is less than first or greater than last.
        else if(index == 0 && root == null) return initializeRoot(stream); // If doubly linked list is empty, set "stream" as "root".
        else if(index == size)              return insert(stream);         // Insert end.
        else if(index == 0)                 return insertRoot(stream);     // Insert root.
        
        // Reconnects the links.
        return insert(stream, findBrookNode(index));
    }
    ///////////////////////////
    ///////////////////////////


    ////////////////////////////////////////
    //////// Crucial Helper Methods ////////
    /**
     * Find the BrookNode that need to be processed.
     * @param index The index that determines the iterations in the traversal
     * @return The BrookNode that needs to be processed
     */
    private BrookNode findBrookNode(int index)
    {
        // Find which direction is closer. All nodes have non null prev and next because null cases have either already been dealt with or are not applicable.
        BrookNode current = null;
        if(size-index > index) { current = root; for(int i=1; i<=index; i++)      current = current.getNext(); } // Forward find.
        else                   { current = end;  for(int i=size-1; i>=index; i--) current = current.getPrev(); } // Reverse find.
        return current;
    }

    /**
     * Deletes the current node.
     * @param current The node to be deleted, and garbage collected by Java
     * @return Whether deletion was successful
     */
    public boolean delete(BrookNode current)
    {
        if(size == 0 || size == 1)
        {
            root = null;
            size = 0;
            return true;
        }

        if(current.getPrev() == null || current == root)
        {
            root = current.getNext();
            size--;
            return true;
        }

        // Cut the current node's connections.
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());

        // Let Java Garbage Collection clean up.
        current.setNext(null);
        current.setPrev(null);

        size--;
        return true;
    }

    /**
     * Fast printing for the answer to the problem.
     * @param s String to be printed
     * @return Whether printing was successful
     */
    private boolean print(String s)
    {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(s);
        pw.flush();

        return true;
    }
    ////////////////////////////////////////
    ////////////////////////////////////////


    ///////////////////////////////////////////////////////////
    //////// Methods Directly Used By Program Solution ////////
    /**
     * Insert a BrookNode to the end of the doubly linked list.
     * @param stream The node containing the value and next and prev node links
     * @return Whether insert was successful
     */
    public boolean insert(BrookNode stream)
    {
        // If doubly linked list is empty, set "stream" as "root".
        if(root == null) return initializeRoot(stream);

        // Add to end. Tracking end node improves efficiency of adding to the end of the doubly linked list by  eliminating the O(n) traversal.
        end.setNext(stream);
        stream.setPrev(end);
        end = stream;

        // Number of elements in doubly linked list + 1.
        size++;
        return true;
    }

    /**
     * Split the brook according to the problem description.
     * @param streamNumber The stream that should be split
     * @param floLeftPercent The volume of the flow that should fork left in percentage
     * @return Whether splitting was successful
     */
    public boolean splitLeft(int streamNumber, double floLeftPercent)
    {
        // Find the brook node.
        BrookNode current = findBrookNode(streamNumber-1);

        if(current.getVolume() == null)
            return false;

        // Calculate flow volume.
        double flowLeftVolume = (Double)current.getVolume() * floLeftPercent / 100.0;
        double flowRightVolume = (Double)current.getVolume() - flowLeftVolume;

        // Fork stream by inserting a new brook to the left of the current brook.
        insert(new BrookNode(flowLeftVolume), streamNumber-1);
        current.setVolume(flowRightVolume);

        return true;
    }

    /**
     * Merge a stream with the stream on the right.
     * @param streamNumber Number of the stream to be merged
     * @return Whether merging was successful
     */
    public boolean mergeRight(int streamNumber)
    {
        // Find the current brook.
        BrookNode current = findBrookNode(streamNumber-1);

        if(current.getNext() == null)
            return false;
        
        // Calculate volume.
        double combinedVolume = (double)current.getVolume() + (double)current.getNext().getVolume();

        // Merge.
        current.getNext().setVolume(combinedVolume);
        delete(current);

        return true;
    }

    /**
     * Print the rounded streams as the answer to the problem.
     * Identical to debugPrintStreams() except the rounding.
     * @return void
     */
    public void printStreams()
    {
        BrookNode current = root;
        String output = "";
        while(current != null)
        {
            output += Math.round((double)current.getVolume()) + " ";
            current = current.getNext();
        }
        print(output.trim());

        return;
    }
    //////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////
}

/**
 * Main class to solve the CCC Babbling Brooks problem.
 * @author Vincent Zhang
 * @since 16 July 2021
 */
public class BabblingBrooks
{
    //////////////////////////////////
    //////// Problem Solution ////////

    /**
     * Method that solve the problem.
     * @return void
     */
    public void run()
    {
        // Store the streams' current state.
        int n = nextInt();
        BrookDoublyLinkedList streams = new BrookDoublyLinkedList(); for(int i=0; i<n; i++) streams.insert(new BrookNode(nextDouble()));

        // Simulate the streams splitting and merging.
        while(true)
        {
            String line = nextLine();
            if(line.equals("77")) break;
            if(line.equals("99")) streams.splitLeft(nextInt(), nextDouble()); // Stream number, Left stream flow percentage.
            if(line.equals("88")) streams.mergeRight(nextInt()); // Stream number.
        }

        // Program end operations.
        closeBufferedReader();
        streams.printStreams();
    }
    //////////////////////////////////
    //////////////////////////////////


    //////////////////////////////////////
    //////// Input Speed Boosting ////////

    // Global variables for input.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    /*
        StringTokenizer:
            --> Legacy class retained for compatibility reasons.
            --> Extracts tokens split by fixed substrings while String.split() and Pattern.split() returns an array of strings delimited by a regex expression.
            --> "About twice as fast as" .split(), according to https://stackoverflow.com/questions/691184/scanner-vs-stringtokenizer-vs-string-split.
    */
    
    /**
     * Parses an input String into tokens delimited by spaces using StringTokenizer.
     * @return The next token
     */
    String nextToken()
    {
        // Get next line of data.
        while(st == null || !st.hasMoreTokens())
        {
            try {
                st = new StringTokenizer(br.readLine());
            } catch(IOException e) { e.printStackTrace(); }
        }

        // In this method, Every token in the line must be called before a new line can be obtained.
        return st.nextToken();
    }

    /**
     * Convert token from string to integer.
     * @return Integer value of the next token
     */
    int nextInt()
    {
        int n = -1;
        try {
            n = Integer.parseInt(nextToken());
        } catch(NumberFormatException e) { e.printStackTrace(); }
        return n;
    }

    /**
     * Convert token from string to double.
     * @return Double value of the next token
     */
    double nextDouble()
    {
        double d = -1;
        try {
            d = Double.parseDouble(nextToken());
        } catch(NumberFormatException e) { e.printStackTrace(); }
        return d;
    }

    /**
     * Get the entire next line.
     * @return The entire input line
     */
    String nextLine()
    {
        String s = null;
        try {
            s = br.readLine();
        } catch(IOException e) { e.printStackTrace(); }
        return s;
    }

    /**
     * Close instance of BufferedReader.
     * @return Whether closing was successful.
     */
    boolean closeBufferedReader()
    {
        try {
            br.close();
        } catch(IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //////////////////////////////////////
    //////////////////////////////////////


    //////////////////////
    //////// Main ////////

    /**
     * Instantiates BabblingBrooks, creating references from a non-static context.
     * @param args Command-line arguments
     * @return void
     */
    public static void main(String[] args)
    {
        BabblingBrooks bb = new BabblingBrooks();
        bb.run();
    }
    //////////////////////
    //////////////////////
}