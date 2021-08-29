#include <iostream>
#include <math.h>

int n, s;

int main()
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::cin >> n;
    for(int i=1; i<=std::sqrt(n); i++)
    {
        if(n%i == 0)
        {
            s += i;
            if(i*i != n)
                s += n/i;
        }
    }
    std::cout << (s * 5 - 24) << '\n';
}