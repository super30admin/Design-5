//Time Complexity O(N)
//Space Complexity O(1)
//Leetcode tested

public class CopyListWithRandomPointer {
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

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node temp = head;
        while(temp!=null){
            Node next = temp.next;
            Node random = temp.random;
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            newNode.random = random;
            temp.next = newNode;
            temp = temp.next.next;
        }

        Node newhead = head.next;
        temp = head;

        while(temp!=null){
            Node next = temp.next;
            if(next.random!=null) next.random = next.random.next;
            temp = temp.next.next;
        }

        temp = head;
        while(temp!=null){
            Node copy = temp.next;
            temp.next = temp.next.next;
            if(copy.next!=null)
                copy.next = copy.next.next;

            temp = temp.next;
        }

        return newhead;

    }
}
