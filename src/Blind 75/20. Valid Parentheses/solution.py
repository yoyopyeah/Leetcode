'''
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
'''

def isValid(s):
    """
    :type s: str
    :rtype: bool
    """
    stack = []
    for char in s:
        if char == '(' or char == '{' or char == '[':
            stack.append(char)
        else:
            if len(stack) == 0:
                return False
            elif char == ')':
                if stack[-1] == '(': 
                    stack.pop()
                else: return False
            elif char == '}':
                if stack[-1] == '{': 
                    stack.pop()
                else: return False
            elif char == ']':
                if stack[-1] == '[': 
                    stack.pop()
                else: return False
                    

    if len(stack) == 0: return True
    else: return False

def isValid2(s):
    stack = []
    dict = {"]":"[", "}":"{", ")":"("}
    for char in s:
        if char in dict.values():
            stack.append(char)
        elif char in dict.keys():
            if stack == [] or dict[char] != stack.pop():
                return False
        else:
            return False
    return stack == []

s = "()"
print(isValid(s))