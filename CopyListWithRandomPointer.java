// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node copyHead = head;
        
        
        while(copyHead != null) {
            Node deepCopy = new Node(copyHead.val);
            deepCopy.next = copyHead.next;
            copyHead.next = deepCopy;
            
            copyHead = copyHead.next.next;
        }
        
        copyHead = head;
        
        while(copyHead != null) {
            if(copyHead.random != null) {
                copyHead.next.random = copyHead.random.next;
            }
            copyHead = copyHead.next.next;
        }
        
        copyHead = head;
        Node deepCopyHead = copyHead.next;
        Node result = head.next;
        
        while(copyHead != null) {
            
            copyHead.next = copyHead.next.next;
            
            if(deepCopyHead.next == null) break;

            deepCopyHead.next = deepCopyHead.next.next;
            copyHead = copyHead.next;
            deepCopyHead = deepCopyHead.next;
        }
    
        return result;
    }
}