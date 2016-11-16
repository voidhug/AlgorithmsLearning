#include<stdio.h>
#include<stdlib.h>
#include "queue.h"

qNode *getNewqNode(void* data) {
    qNode *newqNode = (qNode *)malloc(sizeof(qNode));
    if (NULL == newqNode) {
        return newqNode;
    }
    newqNode->data = data;
    newqNode->next = NULL;
    return newqNode;
}

queue *CreateQueue() {
    queue *newQueue = (queue *)malloc(sizeof(queue));
    if(NULL == newQueue) {
        return newQueue;
    }
    newQueue->front = newQueue->rear = NULL;
    return newQueue;
}

int Enqueue(queue *queueptr, void* data) {
    if(queueptr == NULL) {
        /* As of now, return the error*/
        return QUEUE_FAILURE;
    }
    qNode *newqNode = getNewqNode(data);
    if (newqNode == NULL) {
        return QUEUE_FAILURE;
    }
    /* Enqueue the new data at the tail (rear) of the queue*/
    if (queueptr->rear == NULL) {
        queueptr->rear = queueptr->front = newqNode;
        return QUEUE_SUCCESS;
    }
    queueptr->rear->next = newqNode;
    queueptr->rear = newqNode;

    return QUEUE_SUCCESS;
}


int Dequeue(queue *queueptr) {

    if(queueptr == NULL || queueptr->front == NULL) {
        return QUEUE_FAILURE;
    }
    qNode *temp = queueptr->front;
    int data = temp->data;
    queueptr->front = temp->next;
    free(temp);
    return data;
}

void PrintQueue(queue *queueptr) {
    if(queueptr == NULL || queueptr->front == NULL) {
        return ;
    }
    qNode *temp = queueptr->front;
    while(temp != NULL) {
        printf("%d \t",temp->data);
        temp=temp->next;
    }
}

//void destroy(queue *q)
//{
//    if(q == NULL)
//    {
//        return;
//    }
//    while(q->queue_head != NULL)
//    {
//        pull(q);
//    }
//    free(q);
//}

