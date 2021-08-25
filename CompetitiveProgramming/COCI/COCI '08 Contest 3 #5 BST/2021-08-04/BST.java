import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class BST
{
    static class Node
    {
        public int val;
        public Node left = null;
        public Node right = null;

        public Node(int val)
        {
            this.val = val;
        }
    }

    static class Tree
    {
        Node root = null;
        long count = 0;

        void insert(int val, Node cur)
        {
            if(root == null)
            {
                root = new Node(val);
                System.out.println(count);
                return;
            }

            if(cur == null)
                cur = root;

            while(true)
            {
                count++;
                if(val < cur.val)
                {
                    Node left = cur.left;
                    if(left == null)
                    {
                        cur.left = new Node(val);
                        System.out.println(count);
                        return;
                    }
                    else
                        cur = left;
                }
                else if(val > cur.val)
                {
                    Node right = cur.right;
                    if(right == null)
                    {
                        cur.right = new Node(val);
                        System.out.println(count);
                        return;
                    }
                    else
                        cur = right;
                }
            }
        }

        /*
        // Recursive insert. Will throw java.lang.StackOverflowError because recursive call too deep.
        void insert(int val, Node cur)
        {
            if(root == null)
            {
                root = new Node(val);
                System.out.println(count);
                return;
            }

            if(cur == null)
                cur = root;

            count++;
            if(val < cur.val)
            {
                // System.out.println(val + " < " + cur.val);
                if(cur.left == null)
                {
                    // System.out.println("Set " + cur.val + " left to " + val);
                    cur.left = new Node(val);
                    System.out.println(count);
                }
                else
                {
                    // System.out.println("Visit left node.");
                    insert(val, cur.left);
                }
            }
            else if(val > cur.val)
            {
                // System.out.println(val + " > " + cur.val);
                if(cur.right == null)
                {
                    // System.out.println("Set " + cur.val + " right to " + val);
                    cur.right = new Node(val);
                    System.out.println(count);
                }
                else
                {
                    // System.out.println("Visit right node.");
                    insert(val, cur.right);
                }
            }

        }
        */
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int nextInt()
    {
        try
        {
            return Integer.parseInt(br.readLine());
        }
        catch(IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
        return -1;
    }

    public static void main(String[] args)
    {
        /*
        Tree t = new Tree();

        int n = nextInt();
        for(int i=0; i<n; i++)
        {
            int v = nextInt();
            t.insert(v, null);
        }
        */

        int n = nextInt();
        for(int i=0; i<n; i++)
        {
            int v = nextInt();

        }
    }
}