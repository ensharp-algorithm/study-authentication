#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#pragma warning(disable:4996)

#define TRUE	1
#define FALSE	0

/*** Heap의 정의 ****/
#define HEAP_LEN	100001

typedef int HData;

// d1의 우선순위가 높다면 0보다 큰 값
// d2의 우선순위가 높다면 0보다 작은 값
// d1과 d2의 우선순위가 같다면 0을 반환
typedef int PriorityComp(HData d1, HData d2);

typedef struct _heap
{
	PriorityComp* comp;
	int numOfData;
	HData heapArr[HEAP_LEN];
} Heap;

/*** Heap 관련 연산들 ****/
void HeapInit(Heap* ph, PriorityComp pc);
int HIsEmpty(Heap* ph);

void HInsert(Heap* ph, HData data);
HData HDelete(Heap* ph);

void HeapInit(Heap* ph, PriorityComp pc)
{
	ph->numOfData = 0;
	ph->comp = pc;
}

int HIsEmpty(Heap* ph)
{
	if (ph->numOfData == 0)
		return TRUE;
	else
		return FALSE;
}

int GetParentIDX(int idx)
{
	return idx / 2;
}

int GetLChildIDX(int idx)
{
	return idx * 2;
}

int GetRChildIDX(int idx)
{
	return GetLChildIDX(idx) + 1;
}

int GetHiPriChildIDX(Heap* ph, int idx)
{
	if (GetLChildIDX(idx) > ph->numOfData)
		return 0;

	else if (GetLChildIDX(idx) == ph->numOfData)
		return GetLChildIDX(idx);

	else
	{
		//	if(ph->heapArr[GetLChildIDX(idx)].pr 
		//				> ph->heapArr[GetRChildIDX(idx)].pr)
		if (ph->comp(ph->heapArr[GetLChildIDX(idx)],
			ph->heapArr[GetRChildIDX(idx)]) < 0)
			return GetRChildIDX(idx);
		else
			return GetLChildIDX(idx);
	}
}

void HInsert(Heap* ph, HData data)
{
	int idx = ph->numOfData + 1;

	while (idx != 1)
	{
		//	if(pr < (ph->heapArr[GetParentIDX(idx)].pr))
		if (ph->comp(data, ph->heapArr[GetParentIDX(idx)]) > 0)
		{
			ph->heapArr[idx] = ph->heapArr[GetParentIDX(idx)];
			idx = GetParentIDX(idx);
		}
		else
		{
			break;
		}
	}

	ph->heapArr[idx] = data;
	ph->numOfData += 1;
}

HData HDelete(Heap* ph)
{
	HData retData = ph->heapArr[1];
	HData lastElem = ph->heapArr[ph->numOfData];

	int parentIdx = 1;
	int childIdx;

	while (childIdx = GetHiPriChildIDX(ph, parentIdx))
	{
		//	if(lastElem.pr <= ph->heapArr[childIdx].pr)
		if (ph->comp(lastElem, ph->heapArr[childIdx]) >= 0)
			break;

		ph->heapArr[parentIdx] = ph->heapArr[childIdx];
		parentIdx = childIdx;
	}

	ph->heapArr[parentIdx] = lastElem;
	ph->numOfData -= 1;
	return retData;
}

int DataPriorityComp(int ch1, int ch2)
{
	//return ch2 - ch1;
	//	return ch1-ch2;
	int comp1 = ch1;
	int comp2 = ch2;

	if (ch1 < 0)
		comp1 = -comp1;
	if (ch2 < 0)
		comp2 = -comp2;

	if (comp1 - comp2 == 0)
	{
		if (ch1 < 0)
			return 1;
		else if (ch2 < 0)
			return -1;
		else
			return 0;
	}

	return comp2 - comp1;
}

int main(void)
{
	Heap heap;
	HeapInit(&heap, DataPriorityComp);

	//HInsert(&heap, 'A');
	//HInsert(&heap, 'B');
	//HInsert(&heap, 'C');
	//printf("%c \n", HDelete(&heap));

	//HInsert(&heap, 'A');
	//HInsert(&heap, 'B');
	//HInsert(&heap, 'C');
	//printf("%c \n", HDelete(&heap));

	//while (!HIsEmpty(&heap))
	//	printf("%c \n", HDelete(&heap));

	int N;

	scanf("%d", &N);

	for (int n = 0; n < N; n++)
	{
		int x;
		scanf("%d", &x);

		if (x == 0)
		{
			if (HIsEmpty(&heap)) 
			{
				printf("0\n");
			}
			else
			{
				printf("%d\n", HDelete(&heap));
			}
		}
		else
		{
			HInsert(&heap, (HData)x);
		}
	}

	return 0;
}
