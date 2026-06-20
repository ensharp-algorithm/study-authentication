#include <stdio.h>
#include <stdlib.h>

typedef struct array
{
    int data[101];
    int size;
} Array;

void inPlaceHeapSort(Array *array);
void printArray(Array *array);
void downHeap(Array *array, int index);
void rBuildHeap(Array *array, int index);
void swap(int *a, int *b);

int main()
{
    int N, dasom;
    int count = 0;
    Array *array = (Array *)malloc(sizeof(Array));

    scanf("%d", &N);
    array->size = N - 1;
    scanf("%d", &dasom);

    for (int i = 1; i < N; i++)
        scanf("%d", array->data + i);

    rBuildHeap(array, 1);

    while (dasom <= array->data[1])
    {
        array->data[1] -= 1;
        dasom++;
        count++;
        rBuildHeap(array, 1);
        // printf("count = %d\n", count);
    }

    printf("%d\n", count);
    free(array);
    return 0;
}

/*
inPlaceHeapSort()
최대 순차힙으로 구성되어 있다면 오름차순으로 제자리 정렬하는 함수.
최소 순차힙으로 구성되어 있다면 내림차순으로 제자리 정렬하는 함수.

최대 순차힙:
기존에는 정렬 상태가 아닌 최댓 값만 root node 에 존재하는 것이기 때문에,
반복문을 돌면서 마지막 leaf node에 존재하는 최솟 값을 root node 에 올린 후,
기존의 root node 에 있던 최댓 값을 마지막 leaf node 에 짱 박아놓고 size 를 1개씩 줄여가는 형태.
-> 오름차순으로 제자리 정렬.
*/
void inPlaceHeapSort(Array *array)
{
    int originalSize = array->size;

    for (int i = originalSize; i > 0; i--)
    {
        swap(array->data + i, array->data + 1);
        array->size -= 1;
        downHeap(array, 1);
    }
    array->size = originalSize;
}

void printArray(Array *array)
{
    for (int i = 1; i <= array->size; i++)
        printf(" %d", array->data[i]);
    printf("\n");
}

void downHeap(Array *array, int index)
{
    int biggerIndex = index;
    int leftIndex = index * 2;
    int rightIndex = index * 2 + 1;

    if (leftIndex <= array->size && array->data[leftIndex] > array->data[biggerIndex])
        biggerIndex = leftIndex;
    if (rightIndex <= array->size && array->data[rightIndex] > array->data[biggerIndex])
        biggerIndex = rightIndex;

    if (biggerIndex != index)
    {
        swap(array->data + biggerIndex, array->data + index);
        downHeap(array, biggerIndex);
    }
}

void rBuildHeap(Array *array, int index)
{
    if (index > array->size / 2)
        return;

    rBuildHeap(array, index * 2);
    rBuildHeap(array, index * 2 + 1);
    downHeap(array, index);
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}