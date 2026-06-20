#include <stdio.h>
#include <stdlib.h>

void inPlaceQuickSort(int *array, int left, int right);
int inPlacePartition(int *array, int leftIndex, int pivotIndex, int rightIndex);
void swap(int *a, int *b);

int main()
{
    int N;
    int A[50], B[50];
    int S = 0;

    scanf("%d", &N);
    for (int i = 0; i < N; i++)
        scanf("%d", A + i);

    for (int i = 0; i < N; i++)
        scanf("%d", B + i);

    inPlaceQuickSort(A, 0, N - 1);
    inPlaceQuickSort(B, 0, N - 1);

    for (int i = 0; i < N; i++)
        S += A[i] * B[N - 1 - i];
    printf("%d\n", S);
    return 0;
}

void inPlaceQuickSort(int *array, int left, int right)
{
    if (left >= right)
        return;

    int pivotIndex = inPlacePartition(array, left, (left + right) / 2, right);
    inPlaceQuickSort(array, left, pivotIndex - 1);
    inPlaceQuickSort(array, pivotIndex + 1, right);
}

int inPlacePartition(int *array, int leftIndex, int pivotIndex, int rightIndex)
{
    swap(array + leftIndex, array + pivotIndex);
    pivotIndex = leftIndex;
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

    swap(array + rightIndex, array + pivotIndex);
    return rightIndex;
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}