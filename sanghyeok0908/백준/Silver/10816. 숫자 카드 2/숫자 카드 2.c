#include <stdio.h>
#include <stdlib.h>

void inPlaceQuickSort(int *array, int left, int right);
int inPlacePartition(int *array, int leftIndex, int pivotIndex, int rightIndex);
void swap(int *a, int *b);
void printArray(int *array, int size);
int binarySearch(int *array, int n, int k);
int upperBound(int *array, int n, int k);

int cmp(const void *lhs, const void *rhs)
{
    if (*(int *)lhs > *(int *)rhs)
    {
        return 1;
    }
    else
    {
        return -1;
    }
}

int main()
{
    int N, M;
    int *arrN, *arrM;

    scanf("%d", &N);
    arrN = (int *)malloc(sizeof(int) * N);

    for (int i = 0; i < N; i++)
        scanf("%d", arrN + i);

    scanf("%d", &M);
    arrM = (int *)malloc(sizeof(int) * M);

    for (int i = 0; i < M; i++)
        scanf("%d", arrM + i);

    // inPlaceQuickSort(arrN, 0, N - 1);
    qsort(arrN, N, sizeof(int), cmp);

    for (int i = 0; i < M; i++)
    {
        int lower = binarySearch(arrN, N, arrM[i]);
        int upper = upperBound(arrN, N, arrM[i]);

        printf("%d ", upper - lower);
    }
    printf("\n");

    free(arrN);
    free(arrM);
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

void printArray(int *array, int size)
{
    for (int i = 0; i < size; i++)
        printf(" %d", array[i]);
    printf("\n");
}

int binarySearch(int *array, int n, int key)
{
    int start = 0;
    int end = n - 1;

    while (start < end)
    {
        int mid = (start + end) / 2;

        if (key <= array[mid])
            end = mid;
        else
            start = mid + 1;
    }

    return end;
}

// key 를 초과한 최초의 index 값
int upperBound(int *array, int n, int key)
{
    int start = 0;
    int end = n - 1;

    while (start < end)
    {
        int mid = (start + end) / 2;

        if (key < array[mid])
            end = mid;
        else
            start = mid + 1;
    }

    if (array[end] == key)
        return end + 1;
    return end;
}