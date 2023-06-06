from random import randint

def fill_arr(first, n, d):
    list = []
    size = first + (n - 1) * d
    for i in range(first, size + 1, d):
        list.append(i)
    return list

def init_arr(size):
    list = []
    for i in range(size):
        list.append(randint(-20,21))
    return list

def between_elements(arr,max,min):
    between_arr = []
    for i in range(len(arr)):
        if arr[i] >= min and arr[i] <= max:
            between_arr.append(i)
    return between_arr
    