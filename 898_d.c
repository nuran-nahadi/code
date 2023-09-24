#include<stdio.h>
#include<math.h>
int main()
{
    long long int t;
    scanf("%lld ",&t);
    while (t--)
    {
        long long int n,e;
        long long int op=0;
        char s[10000000];
        scanf("%lld %lld ",&n,&e);
        fgets(s,1000000,stdin);
        long long int i = 0;
        for (; i < n; i++)
        {
            if (s[i] == 'B')
            {
                op++;
                i = i+ (e-1);
            }
               
        }
        printf("%lld\n", op);
    }
}