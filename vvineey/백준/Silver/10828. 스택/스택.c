#pragma warning(disable:4996)
#include <stdio.h>
#include<stdlib.h>
#include <stdbool.h>
#include <string.h>
 
typedef struct stacktype {
	int top;
	int* arr;
}StackType;




int isEmpty(StackType* stack) {
	if (stack->top == -1) {
		return 1;
	}
	else return 0;
}

void push(StackType* stack, int elem) {
	stack->top++;
	stack->arr[stack->top] = elem;
}

int pop(StackType* stack) {
	if (stack->top == -1) {
		return -1;
	}
	else {
		stack->top--;
		return stack->arr[stack->top + 1];
	}
}


int top(StackType* stack) {
	if (stack->top == -1) {
		return -1;
	}
	else {
		return stack->arr[stack->top];
	}
}

int main() {
	int test, elem;
	char testCase[6] = { NULL };
	StackType* stack = (StackType*)malloc(sizeof(StackType));
	stack->top = -1;

	scanf("%d", &test);

	stack->arr = (int**)malloc(sizeof(int*) * test);


	for (int i = 0; i < test; i++) {
		getchar();
		scanf("%s", testCase);

		if (strcmp(testCase, "push") == 0) {
			scanf("%d", &elem);
			push(stack, elem);
		}
		else if (strcmp(testCase, "pop") == 0) {
			printf("%d\n", pop(stack));
		}
		else if (strcmp(testCase, "size") == 0) {
			printf("%d\n", stack->top + 1);
		}
		else if (strcmp(testCase, "empty") == 0) {
			printf("%d\n", isEmpty(stack));
		}
		else if (strcmp(testCase, "top") == 0) {
			printf("%d\n", top(stack));
		}

	}
}