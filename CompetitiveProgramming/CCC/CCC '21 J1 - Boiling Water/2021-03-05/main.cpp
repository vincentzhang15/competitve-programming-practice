#include <bits/stdc++.h>
using namespace std;

int main()
{
    cin.sync_with_stdio(0);
    cin.tie(0);
    
    int b; cin >> b;
    int p = b*5-400;
    cout << p << endl << ((p==100)?(0):((p>100)?(-1):(1))) << endl;
    //cout << (p + "\n" + ((p==100)?(0):((p>100)?(-1):(1)))) << endl;
}
