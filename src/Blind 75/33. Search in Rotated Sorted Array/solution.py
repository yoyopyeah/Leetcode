'''
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
'''

def search(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: int
    """
    i = 0
    n = len(nums)
    if n == 0: return -1

    prev = nums[0]
    flag = None # flag for if target moves right (true) from 0 or left (false)
    if target > prev: flag = True
    else: flag = False

    while True:
        print("== ", i)
        if flag:
            print("moving right")
            if prev > nums[i] or nums[i] > target: return -1
        else:
            print("moving left")
            if prev < nums[i] or nums[i] < target: return -1
        prev = nums[i]
        print(prev)

        if nums[i] == target: return i
        elif target < nums[i]:
            i = i - 1
        elif target > nums[i]:
            i = i + 1

        if i < 0:
            i = n + i

        if i == 0 or i >= n: return -1

# binary search
def search2(self, nums, target):
    if not nums:
        return -1

    low, high = 0, len(nums) - 1

    while low <= high:
        mid = (low + high) / 2
        if target == nums[mid]:
            return mid

        if nums[low] <= nums[mid]:
            if nums[low] <= target <= nums[mid]:
                high = mid - 1
            else:
                low = mid + 1
        else:
            if nums[mid] <= target <= nums[high]:
                low = mid + 1
            else:
                high = mid - 1

    return -1

nums = [1, 3, 5]
print(search(nums, 4))