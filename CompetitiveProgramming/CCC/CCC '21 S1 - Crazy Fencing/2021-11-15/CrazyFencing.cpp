#include <iomanip>
#include <iostream>

int n, ans, b[10003], h[10003];

int main(int argc, char **argv)
{
    std::cin >> n;
    for(int i=0; i<=n; i++)
        std::cin >> b[i];
    for(int i=0; i<n; i++)
        std::cin >> h[i];
    
    for(int i=0; i<n; i++)
        ans += (b[i] + b[i+1]) * h[i];
    
    std::cout << std::fixed << std::setprecision(1) << ans / 2.0;

    return 0;
}