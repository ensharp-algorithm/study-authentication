#include <stdio.h>
#include <stdlib.h>
#pragma warning(disable:4996)

#define TRUE	1
#define FALSE	0

typedef int Data;

typedef struct _node
{
	Data data;
	struct _node* next;
	struct _node* prev;
} Node;

typedef struct _dbDLinkedList
{
	Node* head;
	Node* tail;
	Node* cur;
	int numOfData;
} DBDLinkedList;

typedef DBDLinkedList List;

void ListInit(List* plist)
{
	plist->head = (Node*)malloc(sizeof(Node));
	plist->tail = (Node*)malloc(sizeof(Node));

	plist->head->prev = NULL;
	plist->head->next = plist->tail;

	plist->tail->next = NULL;
	plist->tail->prev = plist->head;

	plist->numOfData = 0;
}

void LInsert(List* plist, Data data)
{
	Node* newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data;

	newNode->prev = plist->tail->prev;
	plist->tail->prev->next = newNode;

	newNode->next = plist->tail;
	plist->tail->prev = newNode;

	(plist->numOfData)++;
}

int LFirst(List* plist, Data* pdata)
{
	if (plist->head->next == plist->tail)
		return FALSE;

	plist->cur = plist->head->next;
	*pdata = plist->cur->data;
	return TRUE;
}

int LNext(List* plist, Data* pdata)
{
	if (plist->cur->next->next == plist->tail)
		return FALSE;

	plist->cur = plist->cur->next;
	*pdata = plist->cur->data;
	return TRUE;
}

Data LRemove(List* plist)
{
	Node* rpos = plist->cur;
	Data remv = rpos->data;

	plist->cur->prev->next = plist->cur->next;
	plist->cur->next->prev = plist->cur->prev;

	plist->cur = plist->cur->prev;    // cur의 위치를 재조정

	free(rpos);
	(plist->numOfData)--;
	return remv;
}

int LCount(List* plist)
{
	return plist->numOfData;
}

int main()
{
	List list;
	int data;

	int N, K;
	int* answer;
	int ansIdx = 0;

	ListInit(&list);
	scanf("%d %d", &N, &K);
	answer = (int*)malloc(sizeof(int*) * N);

	for (int i = 0; i < N; i++)
	{
		LInsert(&list, i + 1);
	}

	while (list.numOfData > 0)
	{
		for (int i = 0; i < K - 1; i++)
		{
			list.cur = list.head->next;
			int temp = (int) LRemove(&list);
			LInsert(&list, temp);
		}

		list.cur = list.head->next;
		answer[ansIdx++] = (int) LRemove(&list);
	}

	printf("<");
	for (int i = 0; i < ansIdx - 1; i++)
	{
		printf("%d, ", answer[i]);
	}
	printf("%d>\n", answer[ansIdx - 1]);
	return 0;
}