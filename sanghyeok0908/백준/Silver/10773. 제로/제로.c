#include <stdio.h>
#include <stdlib.h>

int main()
{
	int sum = 0;
	int idx = 0;
	int K;
	scanf("%d", &K);
	int *arr = (int *)malloc(sizeof(int) * K);

	for(int i = 0; i < K; i++)
	{
		int temp;
		scanf("%d", &temp);
		if (temp == 0)
		{
			idx--;
		}
		else
		{
			arr[idx++] = temp;
		}
	}

	for(int i = 0; i < idx; i++)
	{
		sum += arr[i];
	}

	printf("%d\n", sum);
	return 0;
}