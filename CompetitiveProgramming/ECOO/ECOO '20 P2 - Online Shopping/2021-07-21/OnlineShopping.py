"""
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

The following solution implements method 1.

#########################################################################
############################ MODULE COMMENTS ############################
Program to find the optimal shopping list.
@author Vincent Zhang
@since 21 July 2021
@context Self-Learning Python 3
"""

import sys; input = sys.stdin.readline

"""
Main function to solve the problem.
@return void
"""
def main():
    for t in range(int(input())):
        # Store data.
        shop = {}
        for n in range(int(input())):
            for m in range(int(input())):
                item, price, quant = input().split()
                price, quant = int(price), int(quant)
                if item not in shop:
                    shop[item] = {price: quant}
                else:
                    od = shop[item]
                    od[price] = quant if price not in od else od[price] + quant
                    shop[item] = od
        """
        print("SHOP DATA ===========================================")
        for item, od in shop.items():
            print(item)
            for price, quant in od.items():
                print("  $", price, quant)
        print()
        """

        # Calculate spending.
        spend = 0
        for k in range(int(input())):
            item, quant = input().split()
            quant = int(quant)
            #print('####################### WANT: ', quant, 'OF', item, "#######################")
            for p, q in sorted(shop[item].items()):
                #print("Store:", q, "at $", p)
                q = min(q, quant)
                #print("BUY ", q, " AT $", p)
                spend += q * p
                quant -= q
                #print("SPEND $", p*q)
                #print("REMAIN", quant, item)

                if quant == 0:
                    #print("Total:", spend)
                    #print("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ PRODUCT ACQUIRED")
                    break
        print(spend)

main()