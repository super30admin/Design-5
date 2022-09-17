//Time Complexity: O(n)
//Space Complexity: O(1)

//we're making deep copy of each element and putting them just next to current Node.
//so this way we don't need any hashmap and we'can reduce the space complexity.

class copyList {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr = head;

        //1.making a deep copy and putting them juts next to that node.
        while(curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next ;
            curr.next = newNode;
            curr = curr.next.next;
        }

        //2.making connection for the random pointer
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //3.separating both list from each other.
        curr = head;
        Node copyhead = curr.next;
        Node copyCurr = copyhead;
        while(curr!=null){
            curr.next = curr.next.next;
            if(copyCurr.next !=null){
                copyCurr.next = copyCurr.next.next;
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }
        return copyhead;
    }
}