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
        
        Node dummy = new Node(-1);
        Node temp = dummy;
        map = new HashMap<>();
        temp.next = checkNode(head);
        temp = temp.next;
        while(head!=null){
            temp.next = checkNode(head.next);
            temp.random = checkNode(head.random);
            temp = temp.next;
            head = head.next;
        }
        return dummy.next;
    }
    
    private Node checkNode(Node temp){
        if(temp == null)
            return null;
        if(map.containsKey(temp)){
            return map.get(temp);
        }
        Node newNode = new Node(temp.val);
        map.put(temp,newNode);
        return newNode;
    }
}