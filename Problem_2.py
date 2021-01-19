# Copy List with Random Pointer

# Time Complexity : O(N) as iterating over list
# Space Complexity : O(1) as no extra space required
# Did this code successfully run on Leetcode : Yes with Runtime: 28 ms and Memory Usage: 14.9 MB
# Any problem you faced while coding this : After class No
# Your code here along with comments explaining your approach
# Approach
"""
The approach followed is using 3 steps:
1. Creating a new list i.e duplicate of the original list and attaching nodes.
2. To Set the random pointers such that duplicate is attached to duplicate 
    i.e if A is original and A' is duplicate similarly if B is original and B' is duplicate
    So if random of A points to B so A' should point to B'.
3. Split or break the two lists such that copy/duplicate and original are seperate.

"""
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if(head==None): # base case
            return head
        curr=head
        while(curr): # Creating a new list and attaching nodes
            temp=Node(curr.val,None,None) # duplicate node
            temp.next=curr.next 
            curr.next=temp
            curr=temp.next
        curr=head
        while(curr): # Setting the random pointers such that A'->B'
                curr.next.random=curr.random.next  if curr.random else None
                curr=curr.next.next
        curr_old=head
        new_list=head.next
        newhead=head.next
        while(curr_old): # Breaking or Splitting the new list
            curr_old.next=curr_old.next.next
            new_list.next = new_list.next.next if new_list.next else None 
            curr_old=curr_old.next
            new_list=new_list.next
        return newhead