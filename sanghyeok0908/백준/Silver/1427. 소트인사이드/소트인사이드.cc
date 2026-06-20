#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

int inPlacePartition(int *array, int left, int right)
{
    int pivot = left;
    left++;

    while (left <= right)
    {
        while (left <= right && array[left] <= array[pivot])
            left++;
        while (left <= right && array[right] >= array[pivot])
            right--;

        if (left <= right)
            swap(array + left, array + right);
    }

    swap(array + pivot, array + right);
    return right;
}

void inPlaceQuickSort(int *array, int left, int right)
{
    if (left > right)
        return;

    int pivot = inPlacePartition(array, left, right);
    inPlaceQuickSort(array, left, pivot - 1);
    inPlaceQuickSort(array, pivot + 1, right);
}

int main()
{
    int N;
    int digitCount = 0;
    int *array;
    int index = 0;

    scanf("%d", &N);

    for (int i = 1; i <= N; i *= 10)
        digitCount++;

    array = (int *)malloc(sizeof(int) * digitCount);

    while (N > 0)
    {
        array[index] = N % 10;
        N /= 10;
        index++;
    }

    inPlaceQuickSort(array, 0, digitCount - 1);

    for (int i = digitCount - 1; i >= 0; i--)
        printf("%d", array[i]);
    printf("\n");
    free(array);
    return 0;
}