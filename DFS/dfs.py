import copy

result = []

def dfs(data, temp, level):
    temp.append(0)
    for idx in range(0, data[level]):
        temp[-1] = idx
        if level + 1 == len(data):
            result.append(copy.copy(temp))
        else:
            dfs(data, temp, level + 1)
    temp.pop(-1)

if __name__ == "__main__":
    data = [2, 4]
    dfs(data, [], 0)
    print(result)


