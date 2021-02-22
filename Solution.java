//Time Complexity: O(N)
//Space Complexity: O(N)
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
    HashMap<Node,Node> hmap;
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        hmap = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node currCopy = copyHead;
        while(curr!=null){
            currCopy.next = clone(curr.next);
            currCopy.random = clone(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
       
    }
    private Node clone(Node node){
        if(node == null)return null;
        if(hmap.containsKey(node)){
            return hmap.get(node);
        }
        Node newNode = new Node(node.val);
        hmap.put(node, newNode);
        return newNode;
    }
    
}