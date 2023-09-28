// Using : hashmap (original:deepcopy)
// TC : O(n)
// SC : O(n)
class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        this.map = new HashMap<>();
        Node copyHead = clone(head);
        Node curr = head;
        Node copyCurr = copyHead;

        while(curr != null){
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







// using : linked list linking orignal -> deepcopy
// TC : O(3n)
// SC : O(1)



class Solution {

    public Node copyRandomList(Node head) {

        if(head == null) return null;

        Node curr = head;

        while(curr!= null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr = head;
        while(curr != null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }


        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = curr.next;

        while(curr != null){
            curr.next = curr.next.next;
            // if(curr.next == null) {
            //     copyCurr.next =null;
            //     break;
            // }

            if(curr.next != null){
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;

        }
        
        return copyHead;
    
    }

}