# Given a string s, return the longest palindromic substring in s.

def longestPalindrome(s):
    """
    :type s: str
    :rtype: str
    """
    res = ""

    for i in range(len(s)):
        str1 = helper(s, i, i)
        str2 = helper(s, i, i + 1)
        
        if len(res) < len(str1): res = str1
        if len(res) < len(str2): res = str2

    return res
    

# helper function that expands from center and return the longest panlindrome
def helper(s, l, r):
    res = ""
    while l >= 0 and r < len(s) and s[l] == s[r]:
        if s[l] == s[r]:
            res = s[l: r+1]
            l -= 1
            r += 1            
        else: return res
        return res



s = "ababb"
print("reached")
print(longestPalindrome(s))