//
// Created by 朱天成 on 2016/11/13.
//

#ifndef STACK_LINK_STACK_H
#define STACK_LINK_STACK_H

typedef struct Stack_node
{
	void *data;
	struct Stack_node* next;
}Stack_node;

typedef struct Stack
{
	struct Stack_node* head;
}Stack;

int stack_init(struct Stack* self);
int stack_empty(struct Stack* self);
int stack_push(struct Stack* self,void *data);
void* stack_pop(struct Stack* self);

#endif //STACK_LINK_STACK_H
