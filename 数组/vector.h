//
// Created by 朱天成 on 2016/11/9.
//

#ifndef ALGORITHM_VECTOR_H
#define ALGORITHM_VECTOR_H

#include <stddef.h>

/****** STRUCTURE ******/

typedef struct Vector {
    size_t size;
    size_t capacity;
    size_t element_size;

    void* data;
} Vector;

typedef struct Iterator {
    void* pointer;
    size_t element_size;
} Iterator;

#endif //ALGORITHM_VECTOR_H
