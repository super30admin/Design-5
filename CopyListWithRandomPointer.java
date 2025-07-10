//Using hashmap
//TC: O(n)
//SC: O(n)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node copyHead = new Node(head.val);
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node copyCurr = copyHead;
        map.put(head, copyHead);
        while(curr.next != null){
            Node copyNode = new Node(curr.next.val);
            copyCurr.next = copyNode;
            map.put(curr.next, copyNode);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        curr = head;
        copyCurr = copyHead;
        while(curr != null){
            if(curr.random != null){
                copyCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyHead;
    }
}

//Soltion2
//TC: O(n)
//SC: O(n)

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node copyHead = new Node(head.val);
        HashMap<Node, Node> map = new HashMap<>();
        copyHead = clone(head, map);
        Node curr = head;
        Node copyCurr = copyHead;
        while(curr != null){
            copyCurr.next = clone(curr.next, map);
            if(curr.random != null){
                copyCurr.random = clone(curr.random, map);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return map.get(head);
        
    }

    private Node clone(Node curr, HashMap<Node, Node> map){
        if(curr == null)
            return null;
        if(map.containsKey(curr))
            return map.get(curr);
        Node copy = new Node(curr.val);
        map.put(curr, copy);
        return copy;
    }
}


//Without hashmap
//TC: O(n)


class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        //create deep copy and put it next to original
        Node curr = head;
        Node copyCurr = null;
        while(curr != null){
            copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            curr = curr.next.next;
        }
        //create random pointers

        curr = head;
        copyCurr = curr.next;

        while(curr != null){
            if(curr.random != null){
                copyCurr.random = curr.random.next;

            }
            curr = curr.next.next;
            if(copyCurr.next != null){
                copyCurr = copyCurr.next.next;
            }
            
        }
        
        curr = head;
        copyCurr = head.next;
        Node copyHead = head.next;
        //split the list
        while(curr != null){
            curr.next = curr.next.next;
            if(copyCurr.next != null)
            {
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
    return copyHead;
    }
}