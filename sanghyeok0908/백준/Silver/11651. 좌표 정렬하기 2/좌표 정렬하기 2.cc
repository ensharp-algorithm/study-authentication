#include <stdio.h>
#include <stdlib.h>

int N;
int **array;

void inPlaceQuickSort(int left, int right);
int inPlacePartition(int left, int pivot, int right);
void swap(int i, int j);
void printArray();

int main()
{
    scanf("%d", &N);
    array = (int **)malloc(sizeof(int *) * N);
    for (int i = 0; i < N; i++)
    {
        array[i] = (int *)malloc(sizeof(int) * 2);
        scanf("%d %d", array[i], array[i] + 1);
    }

    inPlaceQuickSort(0, N - 1);
    printArray();

    for (int i = 0; i < N; i++)
        free(array[i]);
    free(array);
    return 0;
}

void inPlaceQuickSort(int left, int right)
{
    if (left >= right)
        return;

    int pivot = inPlacePartition(left, (left + right) / 2, right);
    inPlaceQuickSort(left, pivot - 1);
    inPlaceQuickSort(pivot + 1, right);
}

int inPlacePartition(int left, int pivot, int right)
{
    swap(left, pivot);
    pivot = left;
    left++;

    while (left <= right)
    {
        while (left <= right && (array[left][1] < array[pivot][1] || (array[left][1] == array[pivot][1] && array[left][0] < array[pivot][0])))
            left++;

        while (left <= right && (array[right][1] > array[pivot][1] || (array[right][1] == array[pivot][1] && array[right][0] > array[pivot][0])))
            right--;

        if (left < right)
            swap(left, right);
    }

    swap(pivot, right);
    return right;
}

void swap(int i, int j)
{
    int tempX = array[i][0];
    array[i][0] = array[j][0];
    array[j][0] = tempX;

    int tempY = array[i][1];
    array[i][1] = array[j][1];
    array[j][1] = tempY;
}

void printArray()
{
    for (int i = 0; i < N; i++)
        printf("%d %d\n", array[i][0], array[i][1]);
}