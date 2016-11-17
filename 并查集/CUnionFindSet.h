#ifndef UNION_FIND2_CUNIONFINDSET_H
#define UNION_FIND2_CUNIONFINDSET_H


#include <cstdlib>

class CUnionFindSet {
private:
    int m_nN;
    int* m_pParent;
public:
    CUnionFindSet(int n);
    ~CUnionFindSet();
    void Union(int i, int j);
    int Find(int i);
    void Print() const ;
};

CUnionFindSet::CUnionFindSet(int n) {
    m_nN = n;
    m_pParent = new int[m_nN];
    for (int i = 0; i < m_nN; i++) {
        m_pParent[i] = i;
    }
}

CUnionFindSet::~CUnionFindSet() {
    if (m_pParent != NULL) {
        delete[] m_pParent;
        m_pParent = NULL;
    }
}

int CUnionFindSet::Find(int i) {
    if (i < 0 || i >= m_nN) {
        return -1;
    }
    int root = i;
    while (root != m_pParent[root]) { // 回溯
        root = m_pParent[root];
    }
    int t = i;
    int p;
    while (t != root) { // 路径压缩
        p = m_pParent[t];
        m_pParent[t] = root;
        t = p;
    }
    return root;
}

void CUnionFindSet::Union(int i, int j) {
    if (i < 0 || i >= m_nN || j < 0 || j >= m_nN) {
        return;
    }
    int ri = Find(i);
    int rj = Find(j);
    if (ri != rj) {
        m_pParent[ri] = rj;
    }
}



#endif //UNION_FIND2_CUNIONFINDSET_H
