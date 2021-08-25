#include <iostream>

int n, x, y, r, a, b;
long s;
int data[10000003];

int main(int argc, char **argv)
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    std::cin >> n >> x >> y >> r;

    for(int i=0; i<r; i++)
    {
        std::cin >> a >> b;
        data[a] += 1;
        data[b+1] -= 1;
    }
    for(int i=2; i<= n; i++)
    {
        data[i] += data[i-1];
    }

    for(int i=x; i<=y; i++)
    {
        s += data[i];
    }
    std::cout << s << '\n';

    return 0;
}