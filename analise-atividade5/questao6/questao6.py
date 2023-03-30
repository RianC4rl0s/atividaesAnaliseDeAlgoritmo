def merge_sort(arr):
    if len(arr) <= 1:
        return arr, 0

    mid = len(arr) // 2
    left, left_swaps = merge_sort(arr[:mid])
    right, right_swaps = merge_sort(arr[mid:])
    merged, merge_swaps = merge(left, right)
    
    return merged, left_swaps + right_swaps + merge_swaps

def merge(left, right):
    i = j = 0
    merged = []
    swaps = 0
    
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            merged.append(left[i])
            i += 1
        else:
            merged.append(right[j])
            j += 1
            swaps += len(left) - i
            
    merged += left[i:]
    merged += right[j:]
    
    return merged, swaps

t = int(input())

for _ in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    _, swaps = merge_sort(arr)
    print(f"Optimal train swapping takes {swaps} swaps.")