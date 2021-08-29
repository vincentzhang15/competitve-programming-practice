#include <stdio.h>
#include <math.h>

int n, s;

int main()
{
    scanf("%d", &n);
    for(int i=1; i<=(int)sqrt(n); i++)
    {
        if(n % i == 0)
        {
            s += i;
            if(i * i != n)
            {
                s += n / i;
            }
        }
    }
    printf("%d\n", s * 5 - 24);
}