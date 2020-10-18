

    /*  Explanation
    Leetcode problem link : https://leetcode.com/problems/copy-list-with-random-pointer/
    Time Complexity  : o(n) .. n is the length of the list
    Extra Space Complexity : o(n)
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
    Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Create hashmap of all the nodes.
                    B) while interating agin thru it do the follwoing.
                            hm.get(node).next = hm.get(node.next);
                            hm.get(node).random = hm.get(node.random); 
                    C) At the end, return hm.get(head);
    */  


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>();
        
        Node node = head;
        while(node!=null){
            hm.put(node,new Node(node.val));
            node = node.next;
        }
        
        node = head;
        while(node!=null){
            hm.get(node).next = hm.get(node.next);
            hm.get(node).random = hm.get(node.random);
            node = node.next;
        }
        
        return hm.get(head);
    }
}