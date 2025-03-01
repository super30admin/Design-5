/*
TC : O(n) n is number of nodes in list
SC : O(1)- no hashmap used or any other ds
Create a copy of curr node right after it. Copy random pointer in every alternate node.
Take out the every alternate 2nd to every alternate nth node.

 */
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
class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node curr=head;
        while(curr!=null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            newNode.random = curr.random;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr=head;
        while(curr != null){
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr=head;
        Node copyHead = head.next;
        while (curr != null) {
            Node copiedNode = curr.next;
            curr.next = curr.next.next;
            if (copiedNode.next != null) {
                copiedNode.next = copiedNode.next.next;
            }
            curr = curr.next;
        }
        return copyHead;
    }
}