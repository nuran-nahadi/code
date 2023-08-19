//38
//38
//38
#include <stdio.h>
#include <math.h>

int main()
{
    int n, q;
    scanf("%d %d", &n, &q);
    long long int arr[100000];
    for (int i = 0; i < n; i++)
    {
        scanf("%lld", &arr[i]);
    }
    while (q--)
    {
        long long int number;

        char a, b, c, d, e, f;
        scanf(" %c%c%c%c%c%c %lld", &a, &b, &c, &d, &e, &f, &number);
        if (a == 'S')
        {
            int hold;
            for (int i = 0; i < n; i++)
            {
                if (number == arr[i])
                {
                    printf("%d ", i);
                    hold++;
                }
                
            }
            if (hold==0)
            {
                printf("not found\n");
            }
            
            printf("\n");
        }
        else if (a == 'I')
        {
            int token = 0;
            for (int i = 0; i < n; i++)
            {
                if (number > arr[i])
                {
                    token++;
                    continue;
                }

                else

                    break;
            }

            for (int i = n; i > token - 1; i--)
            {
                arr[i + 1] = arr[i];
            }

            arr[token] = number;
            n++;
            for (int i = 0; i < n; i++)
            {
                printf("%lld ", arr[i]);
            }
            printf("\n");
        }
        else if (a == 'D')
        {
            int flag=0;
            for (int i = 0; i <= n; i++)
            {
                if (arr[i] == number)
                {
                    
                    for (int j = i; j < n; j++)
                    {
                        arr[j] = arr[j+1];
                    }
                   flag++;
                   i--; 
                }
            }
            n -= flag;
            for(int i = 0;i < n;i++)
            {
                printf("%lld ", arr[i]);
            }  
            printf("\n");
        }
    }

    return 0;
}

