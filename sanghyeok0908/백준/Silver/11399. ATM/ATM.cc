#include <stdio.h>
#include <stdlib.h>

typedef struct array
{
    int *elem;
    int size;
} Array;

void swap(int *a, int *b);
void inPlaceQuickSort(Array *array, int leftIndex, int rightIndex);
int inPlacePartition(Array *array, int leftIndex, int rightIndex);
void print(Array *array);

int sum(Array *array)
{
    int sum = 0;
    for (int i = 0; i < array->size; i++)
    {
        sum += array->elem[i];
        for (int j = 0; j < i; j++)
            sum += array->elem[j];
    }
    return sum;
}

int main()
{
    int N;
    Array *array = (Array *)malloc(sizeof(Array));

    scanf("%d", &N);

    array->elem = (int *)malloc(sizeof(int) * N);
    array->size = N;

    for (int i = 0; i < N; i++)
        scanf("%d", array->elem + i);

    inPlaceQuickSort(array, 0, N - 1);
    // print(array);

    printf("%d\n", sum(array));

    free(array->elem);
    free(array);
    return 0;
}

void inPlaceQuickSort(Array *array, int leftIndex, int rightIndex)
{
    if (leftIndex > rightIndex)
        return;

    int pivotIndex = inPlacePartition(array, leftIndex, rightIndex);

    inPlaceQuickSort(array, leftIndex, pivotIndex - 1);
    inPlaceQuickSort(array, pivotIndex + 1, rightIndex);
}

int inPlacePartition(Array *array, int leftIndex, int rightIndex)
{
    int pivotIndex = leftIndex;
    leftIndex++;

    while (leftIndex <= rightIndex)
    {
        while (leftIndex <= rightIndex && array->elem[leftIndex] <= array->elem[pivotIndex])
            leftIndex++;
        while (leftIndex <= rightIndex && array->elem[rightIndex] >= array->elem[pivotIndex])
            rightIndex--;

        if (leftIndex < rightIndex)
            swap(array->elem + leftIndex, array->elem + rightIndex);
    }

    swap(array->elem + pivotIndex, array->elem + rightIndex);
    return rightIndex;
}

void print(Array *array)
{
    for (int i = 0; i < array->size; i++)
        printf(" %d", array->elem[i]);
    printf("\n");
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}