// TC : O(n)
// SC : O(1)


class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr = head;
        while(curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        curr = head;
        Node currCopy = head.next;
        while(true){
            if(curr.random!=null)
                currCopy.random = curr.random.next;
            if(currCopy.next==null) break;
            curr = curr.next.next;
            currCopy = currCopy.next.next;
        }
        Node res = head.next;
        curr = head;
        currCopy = head.next;
        while(true){
            curr.next = curr.next.next;
            if(currCopy.next==null) break;
            currCopy.next = currCopy.next.next;
            curr = curr.next; currCopy = currCopy.next;
        }
        return res;
    }
}