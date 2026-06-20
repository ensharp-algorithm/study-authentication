#include <stdio.h>
#include <stdlib.h>

typedef struct heap
{
    int size;
    int *array;
} Heap;

void insert(Heap *heap, int newValue);
int removeMax(Heap *heap);
void downHeap(Heap *heap, int index);
void upHeap(Heap *heap, int index);
void swap(int *a, int *b);

int main()
{
    int N;
    Heap *heap = (Heap *)malloc(sizeof(Heap));

    scanf("%d", &N);
    heap->array = (int *)malloc(sizeof(int) * N + 1);
    heap->size = 0;

    for (int i = 0; i < N; i++)
    {
        int inputData;
        int minValue;

        scanf("%d", &inputData);
        if (inputData)
            insert(heap, inputData);
        else
        {
            minValue = removeMax(heap);
            if (minValue == -1)
                printf("0\n");
            else
                printf("%d\n", minValue);
        }
    }
    return 0;
}

void insert(Heap *heap, int newValue)
{
    heap->size += 1;
    heap->array[heap->size] = newValue;
    upHeap(heap, heap->size);
}

int removeMax(Heap *heap)
{
    if (heap->size - 1 < 0)
        return -1;

    int result = heap->array[1];
    heap->array[1] = heap->array[heap->size];
    heap->size -= 1;
    downHeap(heap, 1);
    return result;
}

void downHeap(Heap *heap, int index)
{
    int leftIndex = index * 2;
    int rightIndex = index * 2 + 1;
    int smallerIndex = index;

    if (leftIndex <= heap->size && heap->array[leftIndex] < heap->array[smallerIndex])
        smallerIndex = leftIndex;
    if (rightIndex <= heap->size && heap->array[rightIndex] < heap->array[smallerIndex])
        smallerIndex = rightIndex;

    if (smallerIndex != index)
    {
        swap(heap->array + smallerIndex, heap->array + index);
        return downHeap(heap, smallerIndex);
    }
}

void upHeap(Heap *heap, int index)
{
    if (index / 2 < 1)
        return;

    if (heap->array[index] < heap->array[index / 2])
    {
        swap(heap->array + index, heap->array + index / 2);
        upHeap(heap, index / 2);
    }
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}