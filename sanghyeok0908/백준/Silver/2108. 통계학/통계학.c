#include <stdio.h>
#include <stdlib.h>

void inPlaceQuickSort(int *array, int left, int right);
int inPlacePartition(int *array, int leftIndex, int rightIndex);
void swap(int *a, int *b);
void printArray(int *array, int size);
int getModerate(int *arr, int N, int *countArr);
int getRate(int *arr, int N);

int compare(const void *a, const void *b)
{
    int num1 = *(int *)a;
    int num2 = *(int *)b;

    if (num1 < num2)
        return -1;
    if (num1 > num2)
        return 1;
    return 0;
}

int main()
{
    int N;
    int *arr, countArr[8001] = {0};
    int maxCount = 0;

    double mean = 0;

    scanf("%d", &N);
    arr = (int *)malloc(sizeof(int) * N);

    for (int i = 0; i < N; i++)
    {
        scanf("%d", arr + i);
        mean += arr[i];
        countArr[arr[i] + 4000]++;
    }

    // inPlaceQuickSort(arr, 0, N - 1);
    qsort(arr, N, sizeof(int), compare);

    mean = mean / (N * 1.0);
    if (mean > 0)
    {
        if (((int)mean) + 0.5 <= mean)
            mean = (int)mean + 1;
        else
            mean = (int)mean;
    }
    else if (mean < 0)
    {
        if ((int)mean - 0.5 > mean)
            mean = (int)mean - 1;
        else
            mean = (int)mean;
    }

    // printf("test maxCount = %d\n", maxCount);
    // for (int i = 0; i < index; i++)
    //     printf("%d ", moderates[i]);
    // printf("\ntest index = %d\n", index);

    printf("%d\n", (int)mean);
    printf("%d\n", arr[N / 2]);
    printf("%d\n", getModerate(arr, N, countArr));
    printf("%d\n", getRate(arr, N));

    free(arr);
    return 0;
}

int getRate(int *arr, int N)
{
    int bigger, smaller;

    for (int i = 0; i < N; i++)
    {
        if (i == 0 || smaller > arr[i])
            smaller = arr[i];
        if (i == 0 || bigger < arr[i])
            bigger = arr[i];
    }
    return bigger - smaller;
}

int getModerate(int *arr, int N, int *countArr)
{
    int maxCount = 0;
    int flag = 0;

    for (int i = 0; i < 8001; i++)
        if (maxCount < countArr[i])
            maxCount = countArr[i];

    for (int i = 0; i < 8001; i++)
    {
        if (maxCount == countArr[i])
            flag++;
    }

    for (int i = 0; i < 8001; i++)
    {
        if (!countArr[i])
            continue;

        if (flag == 1)
        {
            if (maxCount == countArr[i])
                return i - 4000;
        }
        else
        {
            if (maxCount == countArr[i])
            {
                if (flag == 0)
                    return i - 4000;
                flag = 0;
            }
        }
    }
    printf("error\n");
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