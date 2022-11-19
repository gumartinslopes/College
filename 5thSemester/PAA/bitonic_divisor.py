def bitonic_divisor_search(s, low, high):
    mid = (low + high) // 2
    if low <= high:
        if s[mid - 1] > s[mid] and s[mid] > s[mid + 1]:
            return mid
        elif s[mid] > s[mid - 1]:
            return bitonic_divisor_search(s, mid + 1, high)
        else:
            return bitonic_divisor_search(s, low, mid - 1)

bitonic_sequence = [3,4,3,2]
n = len(bitonic_sequence)
print(bitonic_divisor_search(bitonic_sequence, 1, n-2))