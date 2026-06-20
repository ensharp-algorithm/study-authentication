#pragma warning (disable:4996)
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>

#define TRUE	1
#define FALSE	0

typedef int Data;

typedef struct _node
{
	Data data;
	struct _node* next;
} Node;

typedef struct _listStack
{
	Node* head;
} ListStack;


typedef ListStack Stack;


void StackInit(Stack* pstack)
{
	pstack->head = NULL;
}

int SIsEmpty(Stack* pstack)
{
	if (pstack->head == NULL)
		return TRUE;
	else
		return FALSE;
}

void SPush(Stack* pstack, Data data)
{
	Node* newNode = (Node*)malloc(sizeof(Node));

	newNode->data = data;
	newNode->next = pstack->head;

	pstack->head = newNode;
}

Data SPop(Stack* pstack)
{
	Data rdata;
	Node* rnode;

	if (SIsEmpty(pstack)) {
		printf("Stack Memory Error!");
		exit(-1);
	}

	rdata = pstack->head->data;
	rnode = pstack->head;

	pstack->head = pstack->head->next;
	free(rnode);

	return rdata;
}

Data SPeek(Stack* pstack)
{
	if (SIsEmpty(pstack)) {
		printf("Stack Memory Error!");
		exit(-1);
	}

	return pstack->head->data;
}

int main()
{
	Stack stack;
	StackInit(&stack);

	int N;
	scanf("%d", &N);
	int* arr = (int*)malloc(sizeof(int) * N);

	for (int i = 0; i < N; i++)
	{
		scanf("%d", arr + i);
	}

	for (int i = 0; i < N; i++)
	{
		while (!SIsEmpty(&stack) && arr[(int)SPeek(&stack)] < arr[i])
		{
			arr[(int)SPop(&stack)] = arr[i];
		}

		SPush(&stack, (Data)i);
	}

	while (!SIsEmpty(&stack))
	{
		arr[(int)SPop(&stack)] = -1;
	}

	for (int i = 0; i < N; i++)
		printf("%d ", arr[i]);
	return 0;
}