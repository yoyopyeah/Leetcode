def findSmallestDivisor(s, t):
    if not isDivisible(s, t): return -1
    i = 1
    while i <= len(t)/2:
        if len(t) % i != 0: 
            i += 1
            continue
        u = t[0: i]
        if isDivisible(t, u): return int(i)
        i += 1
    return -1

def isDivisible(s, t):
    if len(s) % len(t) != 0: 
        return False
    n = len(s) / len(t)
    print(n)
    build = ""
    while n > 0:
        build = build + t
    print(build)
    if not build == s: return False
    return True
    
if __name__ == '__main__':
    print(findSmallestDivisor("bcdbcd", "bcd"))