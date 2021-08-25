// https://en.wikipedia.org/wiki/Happy_number
// Print whether "n" is happy number.

#include <iostream>
using namespace std;

bool f(int N)
{
    int o = N;
    while(1)
    {
        // Sum of square of digits.
        int copy = N;
        int sum = 0;
        
        while(copy > 0)
        {
            int digit = copy % 10;
            copy /= 10;
            int square = digit * digit;
            sum += square;
        }

        if(sum < 10 && (sum == 7 || sum == 1))
            return 1;
        else if(sum < 10)
            return 0;

        N = sum;
        if(N == o)
            return 0;
    }
    return true;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    cout << f(N);

    return 0;
}