// Time Complexuty - O(n) n=no of node
// Space Complexity - O(n) n= no of cloned nodes in hashmap

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
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        map = new HashMap<>();
        Node temp = head;
        while(temp!=null) {
            Node curr = copyNode(temp);
            curr.random = copyNode(temp.random);
            curr.next = copyNode(temp.next);
            temp = temp.next;
        }
        head = map.get(head);
        return head;
    }
    
    private Node copyNode(Node temp) {
        Node new_node = null;
        if(temp!=null && !map.containsKey(temp)) {
            new_node = new Node(temp.val);
            map.put(temp,new_node);
        } else {
            return map.get(temp);
        }
        return new_node;
    }
}