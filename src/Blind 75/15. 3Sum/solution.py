'''
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
'''

def threeSum(nums):
    """
    :type nums: List[int]
    :rtype: List[List[int]]
    """
    res = []
    nums.sort()

    for i in range(len(nums) - 2):
        if i > 0 and nums[i] == nums[i-1]:
            continue
        j = i + 1
        k = len(nums) - 1
        while (j < k):
            sum = nums[i] + nums[j] + nums[k]
            if sum > 0:
                k -= 1
            elif sum < 0:
                j += 1
            else:
                res.append([nums[i], nums[j], nums[k]])
                while j < k and nums[j] == nums[j+1]:
                    j += 1
                while j < k and nums[k] == nums[k-1]:
                    k -= 1
                j += 1; k -= 1

    return res



nums1 = [-2,0,1,1,2]
nums2 = [1,2,-2,-1]
nums3 = [-1,0,1,2,-1,-4]
nums4 = [0,0,0,0]
nums5 = [3,0,-2,-1,1,2]
nums6 = [-1,0,1,2,-1,-4,-2,-3,3,0,4]
print(threeSum(nums6))