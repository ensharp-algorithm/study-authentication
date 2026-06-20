#include <stdio.h>
#include <stdlib.h>

void inPlaceQuickSort(int *array, int left, int right);
int inPlacePartition(int *array, int leftIndex, int rightIndex);
void swap(int *array, int a, int b);
void printArray(int *array, int size);

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
    else if (array[end] < key)
        return n;
    return end;
}

int main()
{
    int T;

    scanf("%d", &T);
    for (int k = 0; k < T; k++)
    {
        int n, m;
        int result = 0;

        scanf("%d %d", &n, &m);

        int *nArray = (int *)malloc(sizeof(int) * n);
        for (int i = 0; i < n; i++)
            scanf("%d", nArray + i);
        inPlaceQuickSort(nArray, 0, n - 1);

        for (int i = 0; i < m; i++)
        {
            int key;
            int count, index;

            scanf("%d", &key);

            index = upperBound(nArray, n, key);
            count = n - index;
            // printf("index = %d, count = %d\n", index, count);
            result += count;
        }

        printf("%d\n", result);
        free(nArray);
    }
    return 0;
}

void inPlaceQuickSort(int *array, int left, int right)
{
    if (left >= right)
        return;

    int pivotIndex = inPlacePartition(array, left, right);
    inPlaceQuickSort(array, left, pivotIndex - 1);
    inPlaceQuickSort(array, pivotIndex + 1, right);
}

int inPlacePartition(int *array, int leftIndex, int rightIndex)
{
    int pivotIndex = (leftIndex + rightIndex) / 2;

    swap(array, leftIndex, pivotIndex);
    pivotIndex = leftIndex;
    leftIndex++;

    while (leftIndex <= rightIndex)
    {
        while (leftIndex <= rightIndex && array[leftIndex] <= array[pivotIndex])
            leftIndex++;
        while (leftIndex <= rightIndex && array[rightIndex] >= array[pivotIndex])
            rightIndex--;

        if (leftIndex < rightIndex)
            swap(array, leftIndex, rightIndex);
    }

    swap(array, rightIndex, pivotIndex);
    return rightIndex;
}

void swap(int *array, int a, int b)
{
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
}

void printArray(int *array, int size)
{
    for (int i = 0; i < size; i++)
        printf(" %d", array[i]);
    printf("\n");
}