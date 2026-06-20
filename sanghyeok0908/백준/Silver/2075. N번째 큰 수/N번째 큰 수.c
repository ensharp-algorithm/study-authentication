#include <stdio.h>
#include <stdlib.h>

typedef struct heap
{
    int *data;
    int size;
} Heap;

void rBuildHeap(Heap *heap, int index);
void buildHeap(Heap *heap);
void downHeap(Heap *heap, int index);
void printHeap(Heap *heap);
void swap(int *a, int *b);
int removeMax(Heap *heap);

int main()
{
    int N;
    Heap *heap = (Heap *)malloc(sizeof(Heap));

    scanf("%d", &N);
    heap->data = (int *)malloc(sizeof(int) * N * N + 1);
    heap->size = N * N;

    for (int i = 1; i <= N * N; i++)
        scanf("%d", heap->data + i);

    rBuildHeap(heap, 1);
    // printHeap(heap);

    for (int i = 0; i < N - 1; i++)
        removeMax(heap);
    printf("%d\n", removeMax(heap));

    free(heap->data);
    free(heap);
    return 0;
}

void rBuildHeap(Heap *heap, int index)
{
    if (index > heap->size / 2)
        return;
    rBuildHeap(heap, index * 2);
    rBuildHeap(heap, index * 2 + 1);
    downHeap(heap, index);
}

void buildHeap(Heap *heap)
{
    for (int i = heap->size / 2; i >= 1; i--)
        downHeap(heap, i);
}

void downHeap(Heap *heap, int index)
{
    int biggerIndex = index;
    int leftIndex = index * 2;
    int rightIndex = index * 2 + 1;

    if (leftIndex > heap->size && rightIndex > heap->size)
        return;

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
        printf(" %d", heap->data[i]);
    printf("\n");
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

int removeMax(Heap *heap)
{
    if (heap->size < 1)
        return -1;

    int result = heap->data[1];

    heap->data[1] = heap->data[heap->size];
    heap->size -= 1;

    downHeap(heap, 1);
    return result;
}