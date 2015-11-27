//
//  main.cpp
//  void4C++
//
//  Created by 朱天成 on 15/11/27.
//  Copyright (c) 2015年 voidhug. All rights reserved.
//

#include <iostream>
#include <vector>

using namespace std;

void quick_sort(vector<int> &s, int l, int r) {
    if (l < r) {
        int i = l, j = r, x = s[l];
        while (i < j) {
            while(i < j && s[j] >= x) { // 从右向左找第一个小于x的数
                j--;
            }
            if(i < j) {
                s[i++] = s[j];
            }
            
            while (i < j && s[i] < x) { // 从左向右找第一个大于等于x的数
                i++;
            }
            if (i < j) {
                s[j--] = s[i];
            }
        }
        s[i] = x;
        quick_sort(s, l, i - 1);
        quick_sort(s, i + 1, r);
    }
}

int main(int argc, const char * argv[]) {
    int i, j;
    vector<int> a;
    while (cin >> i) {
        a.push_back(i);
    }
    quick_sort(a, 0, (int)a.size() - 1);
    for (j = 0; j < a.size(); ++j) {
        cout << a[j] << endl;
    }
    return 0;
}
