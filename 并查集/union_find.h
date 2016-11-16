#ifndef UNION_FIND_UNION_FIND_H
#define UNION_FIND_UNION_FIND_H

const int NumSets = 10;

/*
 * Disjoint Set 不相交集 / 并查集
 * 主要操作为：查找和合并
 */
typedef int DisjSet[NumSets + 1]; // 为了下标对齐，这里设定数组大小为NumSets + 1，第0个元素起占位作用
typedef int SetType; // 父节点保存的元素的类型
typedef int ElementType;

// 初始化
void initialize(DisjSet set);

// （按树的大小）合并两个不相交集，root1和root2分别表示两棵要合并的树的根
void setUnion(DisjSet set, SetType root1, SetType root2);

// 查找x属于set中的哪个不相交集
SetType find(ElementType x, DisjSet set);

#endif //UNION_FIND_UNION_FIND_H
