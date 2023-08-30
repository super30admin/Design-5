// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Create a hashmap to store the mapping of original node to copy node
 * 2. Iterate through the original list and create a copy node for each node
 * 3. Return the head of the copy list
 */

import java.util.HashMap;

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head, copyHead = new Node(head.val);
        map.put(curr, copyHead);
        
        Node copyCurr = copyHead;
        while(curr != null){
            if(curr.next != null && !map.containsKey(curr.next)){
                map.put(curr.next, new Node(curr.next.val));
            }
            if(curr.random != null && !map.containsKey(curr.random)){
                map.put(curr.random, new Node(curr.random.val));
            }

            copyCurr.next = map.get(curr.next);
            copyCurr.random = map.get(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }
}