#include <stdio.h>
#include <stdlib.h>

typedef struct heap
{
    long *data;
    int size;
} Heap;

void insertItem(Heap *heap, long key);
long removeMax(Heap *heap);
void upHeap(Heap *heap, int index);
void downHeap(Heap *heap, int index);
void printHeap(Heap *heap);
void swap(long *a, long *b);

int main()
{
    int N;
    Heap *heap = (Heap *)malloc(sizeof(Heap));

    scanf("%d", &N);
    heap->data = (long *)malloc(sizeof(long) * N + 1);
    heap->size = 0;

    for (int i = 1; i <= N; i++)
    {
        long inputData;
        long result;

        scanf("%ld", &inputData);

        if (inputData)
            insertItem(heap, inputData);
        else
        {
            result = removeMax(heap);
            if (result == -1)
                printf("0\n");
            else
                printf("%ld\n", result);
        }
    }

    free(heap->data);
    free(heap);
    return 0;
}

void insertItem(Heap *heap, long key)
{
    heap->size += 1;
    heap->data[heap->size] = key;
    upHeap(heap, heap->size);
}

long removeMax(Heap *heap)
{
    if (heap->size < 1)
        return -1;

    long result = heap->data[1];

    heap->data[1] = heap->data[heap->size];
    heap->size -= 1;

    downHeap(heap, 1);
    return result;
}

void upHeap(Heap *heap, int index)
{
    if (index / 2 < 1)
        return;

    if (heap->data[index / 2] < heap->data[index])
        swap(heap->data + index, heap->data + index / 2);
    upHeap(heap, index / 2);
}

void downHeap(Heap *heap, int index)
{
    int biggerIndex = index;
    int leftIndex = index * 2;
    int rightIndex = index * 2 + 1;

    // 최대 힙
    if (leftIndex <= heap->size && heap->data[biggerIndex] < heap->data[leftIndex])
        biggerIndex = leftIndex;
    if (rightIndex <= heap->size && heap->data[biggerIndex] < heap->data[rightIndex])
        biggerIndex = rightIndex;

    // 최소힙
    // if (leftIndex <= heap->size && heap->data[biggerIndex] > heap->data[leftIndex])
    //     biggerIndex = leftIndex;
    // if (rightIndex <= heap->size && heap->data[biggerIndex] > heap->data[rightIndex])
    //     biggerIndex = rightIndex;

    if (biggerIndex != index)
    {
        swap(heap->data + biggerIndex, heap->data + index);
        downHeap(heap, biggerIndex);
    }
}

void printHeap(Heap *heap)
{
    for (int i = 1; i <= heap->size; i++)
        printf(" %ld", heap->data[i]);
    printf("\n");
}

void swap(long *a, long *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}