#include<stdio.h>
#include<math.h>
int main()
{
    char a[100],b[100];
    int inta[100],intb[100];
    //fgets(a,100,stdin);
    //fgets(b,100,stdin);
    scanf("%s %s",a,b);
    int len=0;
    int la=0;
    for(int i=0;a[i]!='\0';++i)
        {
            //a[i] -= '0';
            la++;
        }
    int lb=0;
    for(int i=0;b[i]!='\0';++i)
        {
            //b[i] -= '0';
            lb++;
        }

    if (la>lb)
    {
        len=la;
        for (int i = len -lb-1; i >= 0; i--)
        {
            int diff=len-lb;
            b[i+diff]=b[i];
            b[i]='0';
        }
        
    }
    else{
    len = lb;
    for (int i = len-la-1; i >= 0; i--)
        {
            int diff=len-la;
            a[i+diff]=a[i];
            a[i]='0';
        }
    }
    puts(a);
    puts(b);
    for (int i = 0; i < len; i++)
    {
        inta[i]=a[i]-'0';
        intb[i]=b[i]-'0';
    }
    
    int sum[100]={0},carry=0,j=0;
    for (int i = len-1;; i--)
    {
        sum[j] = carry+(inta[i]+intb[i])%10;
        carry =  (inta[i]+intb[i])/10;
        j++;
        if(sum[j]==0 && carry == 0)
        break;
    }
    int t=j;
    printf("%d",t);
    for (int i = t; i >=0; i--)
    {
        //printf("%d",sum[i]);
    }
    
    
    printf("%d",len);
    return 0;
}