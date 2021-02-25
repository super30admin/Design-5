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
    Map<Node,Node> map = new HashMap<Node,Node>();
    Node temp = head;
    while(temp!=null){
        map.put(temp, new Node(temp.val));
        temp = temp.next;
    }

    temp = head ; 
    while(temp!=null){
        Node clone = map.get(temp);
        clone.next = map.get(temp.next);
        clone.random = map.get(temp.random);
        temp = temp.next;
    }
    return map.get(head);
    }
}

//Time complexity : O(N)
//Space complexity : O(N)
