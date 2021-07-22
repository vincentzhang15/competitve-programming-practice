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

/**
 * Program to find the optimal shopping list.
 * @author Vincent Zhang
 * @since 21 July 2021
 */
#include <iostream>
#include <unordered_map>
#include <vector>
#include <algorithm>

/**
 * Main function to solve the problem.
 * @param argc Argument count, number of command-line arguments + 1 for program name
 * @param argv Argument vector, program name and command-line arguments
 * @return 0 Successful termination
 */
int main(int argc, char *argv[])
{
    // Disable synchronization between C and C++ standard streams, allowing C++ streams independent buffers.
    std::ios_base::sync_with_stdio(false);
    // Untie cin stream from cout stream to disable automatic flushing after each I/O operation on the other stream.
    std::cin.tie(nullptr);

    int t; std::cin >> t;
    while(t--)
    {
        std::unordered_map<std::string, std::vector<std::pair<int, int>>> shop;
        // Get store data.
        int n; std::cin >> n; // Each store.
        while(n--)
        {
            int m; std::cin >> m; // Each item.
            while(m--)
            {
                std::string i; int p, q; std::cin >> i >> p >> q;
                shop[i].emplace_back(p, q);
            }
        }

        // Find total spendings.
        int total = 0;
        int k; std::cin >> k;
        while(k--)
        {
            std::string i; int q; std::cin >> i >> q;
            std::sort(shop[i].begin(), shop[i].end());

            for(auto iShop : shop[i])
            {
                total += iShop.first * std::min(q, iShop.second);
                q -= std::min(q, iShop.second);
                if(q == 0)
                    break;
            }
        }
        std::cout << total << '\n';
    }

    return 0;
}