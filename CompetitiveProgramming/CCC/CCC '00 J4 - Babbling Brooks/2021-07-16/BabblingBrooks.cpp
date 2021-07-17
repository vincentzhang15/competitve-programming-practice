/*
////////////////////////////////////////////////////////////////////////
//////////////////////////// SYNTAX SUMMARY ////////////////////////////
Syntax Reference: https://www.codementor.io/@codementorteam/a-comprehensive-guide-to-implementation-of-singly-linked-list-using-c_plus_plus-ondlm5azr
1. Public Class Declaration
    struct brook_node
    {
        double volume;
        brook_node *next;
    };

    class brook_node
    {
        public:
            double volume;
            brook_node *next;
    };

2. Constructor
    brook_linked_list()
    {
        head = NULL;
        tail = NULL;
    }

3. Create Node & Pointers
    brook_node *node = new brook_node;
    node->volume = volume;
    node->next = NULL;

4. Delete Node
    delete curr;

//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////// CCC '00 S2 - Babbling Brooks ////////////////////////////
Streams run down the side of a mountain. They can merge or split.
Streams are numbered from 1 to n from left to right.
The volume in each stream is given at a particular altitude.
Output the volume in each stream after a series of splits and/or merges.

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
Line 2 to n+1: stream volume.
Line n+1+1 to end: split, merge, or quit.
    "77": quit the program.
    "88": merge the stream with the one to its right.
        Line 1 after "88": number representing the stream number to merge with the stream to its right.
    "99": split the stream left.
        Line 1 after "99": stream number to split.
        Line 2 after "99": stream volume in percentage that will split left.

Sample Output
5 55

////////////////////////////////////////////////////////////////////////
//////////////////////////// SOLUTION LOGIC ////////////////////////////
Model the streams with a data structure, e.g. vector.
The following solution models the streams with a custom singly linked list.
Process each split or merge accordingly.
*/

/**
 * Program solves the babbling brooks problem.
 * @author Vincent Zhang
 * @since 17 July 2021
 */
#include <iostream>
#include <math.h>

/**
 * Public node class for the brook singly linked list.
 * @author Vincent Zhang
 * @since 17 July 2021
 */
struct brook_node
{
    double volume;
    brook_node *next;
};

/**
 * Public linked list class to store the brook data.
 * @author Vincent Zhang
 * @since 17 July 2021
 */
struct brook_linked_list
{
    // Track the start, and track end of the linked list for easy insertion.
    brook_node *head, *tail;

    /**
     * Initialize head and tail of linked list.
     */
    brook_linked_list()
    {
        head = NULL;
        tail = NULL;
    }

    /**
     * Add node to end of linked list.
     * @param volume The volume of the new node.
     * @return void
     */
    void append(double volume)
    {
        // Create new node to store the volume info.
        brook_node *node = new brook_node;
        node->volume = volume;
        node->next = NULL;

        // Add node to end of linked list.
        if(head == NULL) // When the linked list is empty.
        {
            head = node;
            tail = node;
            node = NULL;
        }
        else
        {
            tail->next = node;
            tail = node;
        }
    }

    /**
     * Insert a node to the left of a stream number, so that the new node becomes the stream number.
     * @param stream_number The number for the stream from left to right
     * @param volume The volume in percentage that should fork left
     * @return void
     */
    void insert(int stream_number, double volume)
    {
        // Create new node to find the previous node. Used to reconnect links later.
        brook_node *prev = new brook_node;
        prev = find_prev(stream_number);

        // Make new node to store the new volume data.
        brook_node *node = new brook_node;
        node->volume = volume;

        // Reconnect links.
        node->next = prev->next;
        prev->next = node;
    }

    /**
     * Insert node at the start of the linked list.
     * @param volume The volume of the node to be inserted to the start of the linked list
     * @return void
     */
    void insert_head(double volume)
    {
        // Create new node to store the data.
        brook_node *node = new brook_node;
        node->volume = volume;

        // Reconnect links.
        node->next = head;
        head = node;
    }

    /**
     * Find the previous node of a stream number for reconnecting links.
     * @param stream_number The number of the stream to find the previous stream of
     * @return void
     */
    brook_node * find_prev(int stream_number)
    {
        // The current value is the previous of the stream number.
        brook_node *curr = new brook_node;
        curr = head;
        for(int i=1; i<stream_number-1; i++)
            curr = curr->next;
        return curr;
    }

    /**
     * Split a stream leftwards.
     * @param stream_number The number of the stream to be split
     * @param volume_percent The percentage of volume that should fork left
     * @return void
     */
    void split_left(int stream_number, double volume_percent)
    {
        // Process root case.
        if(stream_number == 1)
        {
            double volume = head->volume;
            double volume_left = volume * volume_percent * 0.01;
            double volume_right = volume - volume_left;
            head->volume = volume_right;
            insert_head(volume_left);
        }
        // Non-root case.
        else
        {
            brook_node *prev = new brook_node;
            prev = find_prev(stream_number);

            double volume = prev->next->volume;
            double volume_left = volume * volume_percent * 0.01;
            double volume_right = volume - volume_left;

            prev->next->volume = volume_right;
            insert(stream_number, volume_left);
        }
    }

    /**
     * Merge the stream with the stream on the right.
     * @param stream_number The stream that should be merged with the stream to its right
     * @return void
     */
    void merge_right(int stream_number)
    {
        // Root case.
        if(stream_number == 1)
        {
            double volume = head->volume + head->next->volume;
            head->next->volume = volume;
            head = head->next;
        }
        // Non-root case.
        else
        {
            brook_node *prev = new brook_node;
            prev = find_prev(stream_number);

            brook_node *curr = new brook_node;
            curr = prev->next;

            double volume = curr->volume + curr->next->volume;
            curr->next->volume = volume;

            prev->next = curr->next;
            curr->next = NULL;
            delete curr;
        }
    }

    /**
     * Output the rounded streams.
     * @return void
     */
    void print()
    {
        // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
        std::ios_base::sync_with_stdio(false);
        // Untie cin stream from cout stream to disable automatic flushing before each I/O operation on the other stream.
        std::cin.tie(nullptr);

        // Traverse the linked list.
        brook_node *curr = new brook_node;
        curr = head;
        while(curr != NULL)
        {
            std::cout << round(curr->volume) << ' ';
            curr = curr->next;
        }
        std::cout << "\n";
    }
};

/**
 * Main method to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv ARgument vector, program name and command-line arguments
 * @return 0 If program succesfully exits
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing before each I/O operation on the other stream.
    std::cin.tie(nullptr);

    // Store streams initial state.
    int n; std::cin >> n;
    brook_linked_list streams;
    for(int i=0; i<n; i++)
    {
        double volume; std::cin >> volume;
        streams.append(volume);
    }

    // Simulate split, merge, and quit.
    while(1)
    {
        int command; std::cin >> command;

        if(command == 77)
            break;
        else if(command == 99)
        {
            int stream_number; double volume_percent; std::cin >> stream_number >> volume_percent;
            streams.split_left(stream_number, volume_percent);
        }
        else if(command == 88)
        {
            int stream_number; std::cin >> stream_number;
            streams.merge_right(stream_number);
        }
    }
    streams.print();

    // Normal termination will return 0.
    return 0;
}