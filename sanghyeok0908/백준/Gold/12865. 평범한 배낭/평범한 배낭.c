#include <stdio.h>
#include <stdlib.h>

/*
knapsack - 아이템 분할 X - DP
*/

typedef struct item
{
    int weight;
    int price;
} Item;

int maxWeight, itemCount;
Item *array;

void solve();

int main()
{
    scanf("%d %d", &itemCount, &maxWeight);
    array = (Item *)malloc(sizeof(Item) * itemCount);
    for (int i = 0; i < itemCount; i++)
    {
        scanf("%d %d", &array[i].weight, &array[i].price);
    }

    solve();
    return 0;
}

void solve()
{
    int *dp = (int *)malloc(sizeof(int) * maxWeight + 1);

    for (int i = 0; i <= maxWeight; i++)
        dp[i] = 0;

    for (int i = 0; i < itemCount; i++)
    {
        int weight = array[i].weight;
        int price = array[i].price;

        for (int j = maxWeight; j >= weight; j--)
        {
            // dp[j] = 현재까지 무게 j를 채우는 최대 price
            // dp[j - weight] + price = 현재 아이템을 선택했을 때의 price
            // dp[j - weight] = 아이템을 선택하기 전, 이미 담겨져 있는 최대 price
            if (dp[j] < dp[j - weight] + price)
                dp[j] = dp[j - weight] + price;
        }
    }

    printf("%d\n", dp[maxWeight]);
}