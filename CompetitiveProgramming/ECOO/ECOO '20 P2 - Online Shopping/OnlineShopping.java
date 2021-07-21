/*
#######################################################################################
############################ ECOO '20 P2 - Online Shopping ############################
Find the least money required to purchase all desired items.
It is guaranteed that the total quantity of each item available in stores is greater than or equal to the quantity to be bought.

Sample Input
1
2
2
toiletpaper 1 50
catnip 2 25
1
toiletpaper 100 1
2
toiletpaper 51
catnip 10

Sample Input Explanation
Line 1: t, number of test cases.
Line 2; n, number of shops in task 1
Line 3: m, number of items in shop 1
Line 4 to m+4: i p q, item, price quantity in shop 1.
...
Line after stores: k, number of wanted items.
Line after stores + k: i q, item, quanitty of desired item.

Sample Output
170

########################################################################
############################ SOLUTION LOGIC ############################
Method 1: Merge quantities of items in shops with same price and store using a nested dictionary/Map/map.
    O(1) find item in outer dict/HashMap/unordered_map.
    (Ordered dictionary/TreeMap/map) store price and products.
    {item1, {price1 : quantity1, price1 : quantity1, ...}}
    {item2, {...}}
    {item3, {...}}
    ...

Method 2: Store individual shop quantity and price in a nested list/ArrayList<ArrayList<>>/vector<vector<>> (or list of tuples/ArrayList<Object[]>/vector<pair<>>), then sort.
    Outer map/HashMap/unordered_map contains the list of price and quantity.
    {item1, [(price1, quant1), (price2, quant2), ...]}
    ...

Note: OrderedDict does not sort automatically.
Optimization: sort only the items in the shopping cart.

The following solution implements method 2.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Program to find the optimal shopping list.
 * @author Vincent Zhang
 * @since 21 July 2021
 */
public class OnlineShopping
{
    /**
     * Pair class to store price and quantity of an item.
     * @author Vincent Zhang
     * @since 21 July 2021
     */
    class Pair implements Comparable<Pair>
    {
        int p, q;
        
        /**
         * Initialize upon instantiation.
         * @param p Price
         * @param q Quantity
         */
        public Pair(int p, int q)
        {
            this.p = p;
            this.q = q;
        }


        /**
         * compareTo method of the Comparable interface.
         * @param p Pair to compare with
         * @return Value < 0 if this.p < p.p
         */
        @Override
        public int compareTo(Pair p)
        {
            return Integer.compare(this.p, p.p);
        }
    }

    // Global declarations.
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    /**
     * Main methold to solve the problem.
     * @return void
     */
    void run()
    {
        int tt = nextInt();
        for(int t=0; t<tt; t++)
        {
            // Get shop data.
            Map<String, List<Pair>> shop = new HashMap<>();
            int nn = nextInt();
            for(int n=0; n<nn; n++)
            {
                int mm = nextInt();
                for(int m=0; m<mm; m++)
                {
                    String i = nextToken();
                    int p = nextInt();
                    int q = nextInt();

                    List<Pair> subShop = new ArrayList<>();
                    if(shop.containsKey(i))
                        subShop = shop.get(i);
                    subShop.add(new Pair(p, q));
                    shop.put(i, subShop);
                }
            }

            // Find least cost.
            int total = 0;
            int kk = nextInt();
            for(int k=0; k<kk; k++)
            {
                String i = nextToken();
                int q = nextInt();

                Collections.sort(shop.get(i));
                for(Pair pair : shop.get(i))
                {
                    total += pair.p * Math.min(pair.q, q);
                    q -= Math.min(pair.q, q);

                    if(q == 0)
                        break;
                }
            }

            // Output least cost.
            System.out.println(total);
        }
    }

    /**
     * Find the next token in input string.
     * @return The next token
     */
    String nextToken()
    {
        while(st == null || !st.hasMoreTokens())
            try
            {
                st = new StringTokenizer(br.readLine());
            } catch(IOException e) {e.printStackTrace();}
        return st.nextToken();
    }

    /**
     * Conver the next token to integer.
     * @return Integer value of the next token.
     */
    int nextInt()
    {
        int n = -1;
        try
        {
            n = Integer.parseInt(nextToken());
        } catch(NumberFormatException e) {e.printStackTrace();}
        return n;
    }

    /**
     * Instantiate OnlineShopping to reference from a non-static context.
     * @param args Command-line arguments.
     * @return void
     */
    public static void main(String[] args)
    {
        OnlineShopping os = new OnlineShopping();
        os.run();
    }
}