#include <stdio.h>
#include <stdlib.h>

#define TRUE	1
#define FALSE	0

typedef int Data;

typedef struct _node
{
	Data data;
	struct _node * next;
} Node;

typedef struct _listStack
{
	Node * head;
} ListStack;


typedef ListStack Stack;

void StackInit(Stack * pstack)
{
	pstack->head = NULL;
}

int SIsEmpty(Stack * pstack)
{
	if(pstack->head == NULL)
		return TRUE;
	else
		return FALSE;
}

void SPush(Stack * pstack, Data data)
{
	Node * newNode = (Node*)malloc(sizeof(Node));

	newNode->data = data;
	newNode->next = pstack->head;

	pstack->head = newNode;
}

Data SPop(Stack * pstack)
{
	Data rdata;
	Node * rnode;

	if(SIsEmpty(pstack)) {
		printf("Stack Memory Error!");
		exit(-1);
	}

	rdata = pstack->head->data;
	rnode = pstack->head;

	pstack->head = pstack->head->next;
	free(rnode);

	return rdata;
}

Data SPeek(Stack * pstack)
{
	if(SIsEmpty(pstack)) {
		printf("Stack Memory Error!");
		exit(-1);
	}

	return pstack->head->data;
}

int main() {
    Stack stack;
    int T;

    StackInit(&stack);
    scanf("%d", &T);

    for(int i = 0; i < T; i++) {
        char inputs[51];
        scanf("%s", inputs);

        int j = 0;
        while(inputs[j] != '\0') {
            if(inputs[j] == '(') {
                SPush(&stack, 1);
            } else if(inputs[j] == ')') {
                if(SIsEmpty(&stack)) {
                    SPush(&stack, 0);
                    break;
                } else {
                    SPop(&stack);
                }
            }
            j++;
        }

        if(SIsEmpty(&stack) && inputs[j] == '\0') {
            printf("YES\n");
        } else {
            printf("NO\n");
        }
        
        while(!SIsEmpty(&stack)) {
            SPop(&stack);
        }
    }
}