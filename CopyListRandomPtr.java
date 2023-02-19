// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Traverse through the linkedlist and create a deepcopy node next to original node
// Then update random pointers on deep copy list
// Finally separate the linked lists 

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr = head;
        while(curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        curr = head;
        Node currCopy = head.next;
        while(true){
            if(curr.random!=null)
                currCopy.random = curr.random.next;
            if(currCopy.next==null) break;
            curr = curr.next.next;
            currCopy = currCopy.next.next;
        }
        Node res = head.next;
        curr = head;
        currCopy = head.next;
        while(true){
            curr.next = curr.next.next;
            if(currCopy.next==null) break;
            currCopy.next = currCopy.next.next;
            curr = curr.next; currCopy = currCopy.next;
        }
        return res;
    }
}