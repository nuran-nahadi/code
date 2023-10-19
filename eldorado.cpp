#include <stdio.h>
#include <math.h>
int key, n, x, y;
int array[10000070], smaller[10000070], bigger[10000070];
void sieve()
{
    array[0] = 1;
    array[1] = 1;
    for (int i = 2; i*i <= 10000070; i++)
    {
        if (!array[i])
            for (int j = i * 2; j < 10000070; j += i)
            {
                array[j] = 1;
            }
    }
    int l = 0, r = 0;
    for (int i = 2; i < 10000070; i++)
    {
        if (!array[i])
            l = i;
        smaller[i] = l;
    }
    for (int i = 10000070; i >= 2; i--)
    {
        if (!array[i])
            r = i;
        bigger[i] = r;
    }
    
}
int minCost(int a, int b, int number)
{
    if ((number - a) * y > (b - number) * x)
        return b;
    else
        return a;
}

int main()
{
    sieve();
    scanf("%d %d %d", &n, &x, &y);
    //scanf("%d", &a);
    //printf("%d", minCost(smaller[a], bigger[a], a));

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &key);
        if(key==1){printf("2 ");continue;}
        printf("%d ", minCost(smaller[key], bigger[key], key));
    }
}
