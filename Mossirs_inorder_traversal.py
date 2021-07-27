# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def inorderTraversal(self, root):

        result = []
        curr = root
        #  Until current root is empty
        #  We will check if left child is present if not then add it to the result
        #  as it will be leaf node and move current to curr right child and if present then
        #  we will treat left subtree as current root and we will go to its rightmost node and
        #  then assign its right child as current and then shift the remaining nodes accordingly
        #  and until the current node is empty we will be having inorder traversal in our result list
        while curr:

            if not curr.left:
                result.append(curr.val)
                curr = curr.right
            else:
                previous = curr.left
                while previous.right:
                    previous = previous.right

                previous.right = curr
                temp = curr
                curr = curr.left
                temp.left = None

        return result

