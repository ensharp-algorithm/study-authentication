#include <stdio.h>
#include <stdlib.h>
/*
퀵 정렬
*/
void inPlaceQuickSort(int *array, int leftIndex, int rightIndex);
int inPlacePartition(int *array, int leftIndex, int rightIndex);

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void inPlaceQuickSort(int *array, int leftIndex, int rightIndex)
{
    if (leftIndex > rightIndex)
        return;
    int pivotIndex = inPlacePartition(array, leftIndex, rightIndex);
    inPlaceQuickSort(array, leftIndex, pivotIndex - 1);
    inPlaceQuickSort(array, pivotIndex + 1, rightIndex);
}

int inPlacePartition(int *array, int leftIndex, int rightIndex)
{
    int pivotIndex = leftIndex;
    leftIndex++;
    while (leftIndex <= rightIndex)
    {
        while (leftIndex <= rightIndex && array[leftIndex] <= array[pivotIndex])
            leftIndex++;
        while (leftIndex <= rightIndex && array[rightIndex] >= array[pivotIndex])
            rightIndex--;

        if (leftIndex < rightIndex)
            swap(array + leftIndex, array + rightIndex);
    }

    swap(array + pivotIndex, array + rightIndex);
    return rightIndex;
}

int main()
{
    int N;
    int *array;

    scanf("%d", &N);
    array = (int *)malloc(sizeof(int) * N);
    for (int i = 0; i < N; i++)
        scanf("%d", array + i);

    inPlaceQuickSort(array, 0, N - 1);

    for (int i = 0; i < N; i++)
        printf("%d\n", array[i]);
    free(array);
    return 0;
}