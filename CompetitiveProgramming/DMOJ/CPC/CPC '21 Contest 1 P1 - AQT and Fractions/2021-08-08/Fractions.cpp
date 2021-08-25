#include <bits/stdc++.h>

using namespace std;

typedef long long ll;

long long gcdEuclidean(long long a, long long b)
{
    if(a == 0)
        return b;
    return gcdEuclidean(b%a, a);
}

long long multiples(int v, long long d, long long c)
{
    if(d%v != 0)
        return c;
    return multiples(v, d/v, ++c);
}

int t; long long n, d;
int main()
{
    for(cin >> t; t--;)
    {
        cin >> n >> d;
        d /= gcdEuclidean(n, d);

        long long m2 = multiples(2, d, 0);
        long long m5 = multiples(5, d, 0);
        long long reduced = d / pow(2, m2) / pow(5, m5);
        
        if(reduced == 1)
            cout << max(m2, m5) << '\n';
        else
            cout << -1 << '\n';
    }

    return 0;
}