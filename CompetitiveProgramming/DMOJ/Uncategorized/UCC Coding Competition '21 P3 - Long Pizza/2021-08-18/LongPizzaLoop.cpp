#include <iostream>
#include <math.h>

int n, x, y, r, a, b;
long s;

int main(int argc, char *argv[])
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::cin >> n >> x >> y >> r;

    for(int i=0; i<r; i++)
    {
        std::cin >> a >> b;
        int lo = std::max(a, x);
        int hi = std::min(b, y);
        int v = hi - lo + 1;
        if(v > 0)
        {
            s += v;
        }
    }
    std::cout << s << '\n';

    return 0;
}