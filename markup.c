#include<stdio.h>
#include<string.h>
void recursion(int n,int r,int t)
{
    printf("%d ",n);
    if (t==r)
    {
        return;
    }
    else
    {
        return recursion(n-1,r,t+1);
    }
}
int main()
{
    recursion(5,3,1);
}