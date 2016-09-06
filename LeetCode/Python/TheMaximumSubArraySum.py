# -*- coding: utf-8 -*-

'''
第 53 题
最大子数组和
给定数组 a[1...n]，求最大子数组和，即找出1 <= i <= j <= n，使 a[i] + a[i + 1] + ... + a[j] 最大。
'''

def violenceEnumeration(array):
    '''
    for i <- 1 to n
        for j <- i to n
            sum <- a[i] +...+ a[j]
            ans <- max(ans, sum)
    时间复杂度 O(n ^ 3)，附加空间复杂度 O(1)
    '''
    n = len(array)
    ans = -100000000
    for i in range(n):
        for j in range(i, n):
            sum = 0
            for k in range(i, j + 1):
                sum += array[k]
                ans = max(ans, sum)
    return ans

def optimizationEnumeration(array):
    '''
    for i <- 1 to n
        sum <- 0
        for j <- i to n
            sum <- sum + a[j]
            ans <- max(ans, sum)
    时间复杂度 O(n ^ 2)，附加空间复杂度 O(1)
    '''
    n = len(array)
    ans = -100000000
    for i in range(n):
        sum = 0
        for j in range(i, n):
            sum += array[j]
            ans = max(ans, sum)
    return ans

def greedy(array):
    '''
    sum <- 0 ans <- 0
    for i <- 1 to n
        sum <- sum + a[i]
        ans <- max(sum, ans)
        if (sum < 0) sum <- 0
    时间复杂度 O(n)，附加空间复杂度 O(1)
    '''
    sum = 0
    ans = -100000000
    n = len(array)
    for i in range(n):
        sum += array[i]
        ans = max(sum, ans)
        if (sum < 0):
            sum = 0
    return ans


if __name__ == '__main__':
    array1 = [1, 2, 3]
    array2 = [1, -2, -3, 4]
    # print ViolenceEnumeration(array1)
    # print violenceEnumeration(array2)
    # print optimizationEnumeration(array2)
    print greedy(array1)
