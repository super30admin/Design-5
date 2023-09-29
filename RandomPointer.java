//TC = O(N)
//SC = O(N)
// Here we are using Map to store the new node and old node so that we will get their references.
class RandomPointer{
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        this.map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node copyCurr = copyHead;
        while(curr!= null){
            copyCurr.next = clone(curr.next);
            copyCurr.random = clone(curr.random);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }

    private Node clone(Node node){
        if(node == null) return null;
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }

}