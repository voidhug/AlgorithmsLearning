#include <stdio.h>
#include "union_find.h"

void
initialize(DisjSet set)
{
    /* 
     * 初始化时，每个根节点中保存的值就是该树的大小的负值，也就是-1 
     * 在这里，树的大小的意思是树中有多少个节点 
     * 如果节点中保存的值为正数，那么该值表示父节点在数组中的下标 
     * 
     * 注意： 
     * 数组的下标就是节点中保存的元素 
     * 数组中的元素表示父节点中保存的元素或树的大小的负值 
     */
    for (int i = NumSets; i > 0; i--)
        set[i] = -1;

    // do nothing with set[0]  
}

/* 
 * 按树的大小求并：较小的树成为较大的树的子树 
 */
void
setUnion(DisjSet set, SetType root1, SetType root2)
{
    if (set[root1] >= 0 || set[root2] >= 0)
        printf("Fail to union: Root1 and Root2 is not a root of tree");

    if (set[root1] == set[root2]) // 同一棵树  
        return;
    else
    {
        if (set[root1] > set[root2]) // -set[root1] < -set[root2]  
            set[root1] = root2;
        else // -set[root1] > -set[root2]  
            set[root2] = root1;
    }
}

SetType
find(ElementType x, DisjSet set)
{
    if (x > NumSets)
    {
        printf("x is not in DisjSet");
        return 0;
    }

    if (set[x] == 0) // 空树或该节点指向占位的第0个数组元素，因此出错  
    {
        printf("Error: set[x] can not be 0");
        return 0;
    }

    /* 
     * 在查找到某个元素后，执行路径压缩算法 
     * 注意：路径压缩算法和按大小合并算法兼容，和按树高度合并算法不兼容 
     */
    if (set[x] < 0)
        return x;
    else
        return set[x] = find(set[x], set); // 沿上查找根节点，并设为x的父节点  
}  