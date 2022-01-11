'''
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.
'''

# hardcode, two loops -> time limit exceeded
def maxArea(self, height):
    """
    :type height: List[int]
    :rtype: int
    """
    res = 0
    for i in range(len(height)):
        for j in range(i, len(height)):
            area = (j - i) * min(height[i], height[j])
            res = max(res, area)

    return res

# two pointers
def maxArea2(self, height):
    """
    :type height: List[int]
    :rtype: int
    """
    res = 0
    max_width = len(height) - 1
    l = 0; r = max_width
    for width in range(max_width, 0, -1):
        if height[l] < height[r]:
            res = max(res, width * height[l])
            l += 1
        else:
            res = max(res, width * height[r])
            r -= 1

    return res
