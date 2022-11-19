def binary_search(arr, key, begin = 0, end = None):
    end = len(arr) if end == None else end
    mid =  (begin + end)//2
    if(begin >= end):
        return False
    elif arr[mid] == key:
        return True
    elif key < arr[mid]:
        return binary_search(arr, key, begin, mid) 
    else:
        return binary_search(arr, key, mid + 1, end)
    
values = [1,2,3,4,5,6,7,8,9]

for value in values:
    print(binary_search(values, value))
print(binary_search(values, 150))
print(binary_search(values, -1))
