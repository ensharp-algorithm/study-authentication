#include <stdio.h>
#include <stdlib.h>

/*
3차원 BFS - deque
*/

typedef struct vertex
{
    int name;
    int i, j, k;
    int value;
} Vertex;

typedef struct node
{
    Vertex *data;
    struct node *next;
} Node;

typedef struct deque
{
    Node *front;
    Node *rear;
} Deque;

Vertex *createVertex(int i, int j, int k, int value);
void initDeque();
Node *createNode(Vertex *vertex);
int isEmptyDeque();
void pushFrontDeque(Vertex *vertex);
void pushBackDeque(Vertex *vertex);
Vertex *popFrontDeque();
Vertex *popBackDeque();
void printDeque();

int isMovable(int _x, int _y, int _z);
void solve();

Deque *deque;
int graph[100][100][100];
int z, x, y;
int directionX[6] = {-1, 1, 0, 0, 0, 0};
int directionY[6] = {0, 0, -1, 1, 0, 0};
int directionZ[6] = {0, 0, 0, 0, -1, 1};

int main()
{
    initDeque();
    scanf("%d %d %d", &x, &y, &z);

    for (int i = 0; i < z; i++)
    {
        for (int j = 0; j < y; j++)
        {
            for (int k = 0; k < x; k++)
            {
                scanf("%d", &graph[i][j][k]);
                if (graph[i][j][k] == 1)
                    pushBackDeque(createVertex(k, j, i, 1));
            }
        }
    }

    solve();
    return 0;
}

int isMovable(int _x, int _y, int _z)
{
    if ((0 <= _x && _x < x) && (0 <= _y && _y < y) && (0 <= _z && _z < z))
    {
        return 1;
    }
    return 0;
}

void solve()
{
    int max = 0;

    while (!isEmptyDeque())
    {
        Vertex *vertex = popFrontDeque();
        int currentX = vertex->i;
        int currentY = vertex->j;
        int currentZ = vertex->k;

        for (int i = 0; i < 6; i++)
        {
            int dx = currentX + directionX[i];
            int dy = currentY + directionY[i];
            int dz = currentZ + directionZ[i];

            if (isMovable(dx, dy, dz) && graph[dz][dy][dx] == 0)
            {
                // printf("dx = %d, dy = %d, dz = %d, current = %d\n", dx, dy, dz, graph[currentZ][currentY][currentX]);

                pushBackDeque(createVertex(dx, dy, dz, graph[dz][dy][dx]));
                graph[dz][dy][dx] = graph[currentZ][currentY][currentX] + 1;
            }
        }
    }

    for (int i = 0; i < z; i++)
    {
        for (int j = 0; j < y; j++)
        {
            for (int k = 0; k < x; k++)
            {
                // printf("%d ", graph[i][j][k]);

                if (graph[i][j][k] == 0)
                {
                    printf("-1\n");
                    return;
                }

                if (max < graph[i][j][k])
                    max = graph[i][j][k];
            }
            // printf("\n");
        }
    }

    printf("%d\n", max - 1);
}

Vertex *createVertex(int i, int j, int k, int value)
{
    Vertex *newVertex = (Vertex *)malloc(sizeof(Vertex));
    newVertex->i = i;
    newVertex->j = j;
    newVertex->k = k;
    newVertex->value = value;
    return newVertex;
}

void initDeque()
{
    deque = (Deque *)malloc(sizeof(Deque));
    deque->front = NULL;
    deque->rear = NULL;
}

Node *createNode(Vertex *vertex)
{
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->data = vertex;
    newNode->next = NULL;
    return newNode;
}

int isEmptyDeque()
{
    return deque->front == NULL;
}

void pushFrontDeque(Vertex *vertex)
{
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->data = vertex;
    newNode->next = deque->front;
    deque->front = newNode;

    if (deque->rear == NULL)
    {
        deque->rear = newNode;
    }
}

void pushBackDeque(Vertex *vertex)
{
    Node *newNode = (Node *)malloc(sizeof(Node));
    newNode->data = vertex;
    newNode->next = NULL;

    if (isEmptyDeque())
    {
        deque->front = newNode;
        deque->rear = newNode;
        return;
    }

    deque->rear->next = newNode;
    deque->rear = newNode;
}

Vertex *popFrontDeque()
{
    if (isEmptyDeque())
    {
        return NULL;
    }

    Vertex *data = deque->front->data;
    Node *temp = deque->front;
    deque->front = deque->front->next;
    free(temp);

    if (deque->front == NULL)
    {
        deque->rear = NULL;
    }

    return data;
}

Vertex *popBackDeque()
{
    if (isEmptyDeque())
    {
        return NULL;
    }

    Vertex *result = deque->rear->data;
    Node *prevNodeOfRearNode = deque->front;

    // deque 에 1개의 node 만 존재할 때
    if (deque->front->next == NULL)
    {
        deque->front = NULL;
        deque->rear = NULL;
        return result;
    }

    while (prevNodeOfRearNode->next != deque->rear)
    {
        prevNodeOfRearNode = prevNodeOfRearNode->next;
    }

    deque->rear = prevNodeOfRearNode;
    prevNodeOfRearNode->next = NULL;
    return result;
}

void printDeque()
{
    Node *current = deque->front;

    printf("Deque = ");
    while (current != NULL)
    {
        printf("%d ", (current->data->value) + 1);
        current = current->next;
    }
    printf("\n");
}