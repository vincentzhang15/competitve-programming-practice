#include <iostream>
#include <map>

int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    long sum = 0;
    std::map<int, int> treeDepth;

    int t;
    std::cin >> t;
    while(t--)
    {
        int c;
        std::cin >> c;
        int depth = 0;

        std::map<int, int>::iterator it = treeDepth.lower_bound(c);

        if(it != treeDepth.end())
            depth = std::max(depth, it->second + 1);

        if(it != treeDepth.begin())
        {
            it--;
            depth = std::max(depth, it->second + 1);
        }

        treeDepth[c] = depth;
        sum += depth;

        std::cout << sum << '\n';

    }


    return 0;
}