#include<stdio.h>
#include<math.h>
int stringLength(char s[])
{
    int i=0;
    while (s[i]!='\0')
    {
        i++;
    }
    return i;
}
int main()
{
    int n;
    scanf("%d",&n);
    char str[n][100001];
    int alpha[n][26]={{}};
    for (int i = 0; i < n; i++)
    {
        scanf("%s ",str[i]);
        for (int j = 0; j < stringLength(str[i]); j++)
        {
            if(str[i][j]>='a'&&str[i][j]<='z')
            alpha[i][str[i][j]-'a']++;
            else
            alpha[i][str[i][j]-'A']++;
        }
    }
    // for (int i = 0; i < 26; i++)
    // {
    //     printf("%d ",alpha[3][i]);
    // }
    
    
    for (int j = 0; j < 26; j++)
    {
        int min=1000000;
        for (int i = 0; i < n; i++)
        {
            if (alpha[i][j]<min)
            {
                min=alpha[i][j];
            }
           
        }
        for (int f = 0; f < min; f++)
        {
            printf("%c",j+'a');
        }
        
    }
    return 0;
}