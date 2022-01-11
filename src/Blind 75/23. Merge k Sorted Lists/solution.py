'''
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.
'''

# Divide and conquer
def mergeKLists(self, lists):
    if not lists:
        return None
    if len(lists) == 1:
        return lists[0]
    mid = len(lists) // 2
    l, r = self.mergeKLists(lists[:mid]), self.mergeKLists(lists[mid:])
    return self.merge(l, r)

def merge(self, l, r):
    dummy = p = ListNode()
    while l and r:
        if l.val < r.val:
            p.next = l
            l = l.next
        else:
            p.next = r
            r = r.next
        p = p.next
    p.next = l or r
    return dummy.next