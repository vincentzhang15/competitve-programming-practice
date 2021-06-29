#include <bits/stdc++.h>
using namespace std;

vector<long long> primes;

vector<long long> trial_division4(long long n) {
    vector<long long> factorization;
    for (long long d : primes) {
        if (d * d > n)
            break;
        while (n % d == 0) {
            factorization.push_back(d);
            n /= d;
        }
    }
    if (n > 1)
        factorization.push_back(n);
    return factorization;
}

int main()
{
	cin.sync_with_stdio(0);
	cin.tie(0);
	
	int m, n;
	cin >> m >> n;

	int map [m+1][n+1];
	for(int i = 1; i <= m; i++)
		for(int j = 1; j <= n; j++)
			cin >> map[i][j];
}