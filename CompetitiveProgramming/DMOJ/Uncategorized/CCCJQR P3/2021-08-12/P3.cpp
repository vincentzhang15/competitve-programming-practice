#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    unsigned long long a, b, c;
    cin >> a >> b >> c;
    cout << (a+b+c) % 42069900169420;

    return 0;    
}