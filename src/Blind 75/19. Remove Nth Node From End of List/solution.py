# Given the head of a linked list, remove the nth node from the end of the list and return its head.

# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
def removeNthFromEnd(head, n):
    fast = slow = head
    while n > 0:
        fast = fast.next
        n -= 1
    if not fast:
        return head.next
    while fast.next:
        slow = slow.next
        fast = fast.next
    slow.next = slow.next.next
    return head

head1 = [1,2,3,4,5]
head2 = [1, 2]
n = 5
print(removeNthFromEnd(head1, n))