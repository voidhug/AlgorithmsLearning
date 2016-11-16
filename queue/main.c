#include<stdio.h>
#include "queue.h"

int main() {

    queue *myqueue = CreateQueue();
    Enqueue(myqueue, 3);
    Enqueue(myqueue, 2);
    Enqueue(myqueue, 17);
    PrintQueue(myqueue); printf("\n");

    Dequeue(myqueue);
    Enqueue(myqueue, 7);
    PrintQueue(myqueue);

    return 0;
}