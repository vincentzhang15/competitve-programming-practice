#include <iostream>

int main(int argc, char **argv)
{
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(nullptr);

    long n, m;
    std::cin >> n >> m;

    long long sum = 0;
    for(int i=0; i<n; i++)
    {
        long long a, b;
        std::cin >> a >> b;

        sum = (sum + a * b) % m;
    }
    std::cout << sum << '\n';
}