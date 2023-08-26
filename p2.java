// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

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
        //hashmap to keep track of node and it's deep copy
        HashMap<Node, Node> map = new HashMap<>();
        if(head == null) return null;
        Node dummy = new Node(-1);
        Node prev = dummy;
        //Traverse over all the nodes creating it's deep copy and pointing the next and random pointer
        while(head != null){
            if(!map.containsKey(head)){
                Node node = new Node(head.val);
                map.put(head,node);
            }
            if(head.random != null){
                if(!map.containsKey(head.random)){
                    map.put(head.random, new Node(head.random.val));
                }
                map.get(head).random = map.get(head.random);
            }
            prev.next = map.get(head);
            head = head.next;
            prev = prev.next;
        }

        return dummy.next;
    }
}