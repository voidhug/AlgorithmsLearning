#ifndef QUEUE_QUEUE_H
#define QUEUE_QUEUE_H


#include<limits.h>

#define QUEUE_SUCCESS 0
#define QUEUE_FAILURE INT_MIN

typedef struct qNode {
    struct qNode *next;
    void* data;
} qNode;

typedef struct queue {
    struct qNode *front, *rear;
} queue;

qNode *getNewqNode(void* );
queue * CreateQueue();
int Enqueue(queue *, void* );
int Dequeue(queue *);
void PrintQueue(queue *);
void destroy(queue *q);

#endif //QUEUE_QUEUE_H
