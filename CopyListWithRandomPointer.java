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

//TC: O(n)
//SC: O(n)
class Solution {
    Map<Node, Node> map = new HashMap();
    public Node copyRandomList(Node head) {
        Node curr = head;
        while(curr!=null){
            Node currCopy = clone(curr);
            currCopy.next = clone(curr.next);
            currCopy.random = clone(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return map.get(head);
    }
    
    private Node clone(Node node){
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        
        Node copy = new Node(node.val);
        map.put(node, copy);
        return copy;
    }
}

//TC: O(n)
//SC: O(n), please confirm if the space will be O(n) or not, as I am having n extra nodes in my list.
class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;
        if(head == null) return null;
        //make copies and store next to the original node
        while(curr!=null){
            Node temp = curr.next;
            Node currCopy = new Node(curr.val);
            curr.next = currCopy;
            currCopy.next = temp;
            curr = currCopy.next;
        }
        
        //populate random pointers
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        //split the lists
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = copyHead;
        
        while(curr != null ){
            curr.next = curr.next.next;
            if(copyCurr.next != null){
                copyCurr.next = copyCurr.next.next; 
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}
