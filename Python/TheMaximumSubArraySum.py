# -*- coding: utf-8 -*-

'''
最大子数组和
给定数组 a[1...n]，求最大子数组和，即找出1 <= i <= j <= n，使 a[i] + a[i + 1] + ... + a[j] 最大。
'''

def ViolenceEnumeration():
    '''
    for i <- to n
        for j <- to n
            sum <- a[i] +...+ a[j]
            ans <- max(ans, sum)
    时间复杂度 O(n ^ 3)，附加空间复杂度 O(1)
    '''