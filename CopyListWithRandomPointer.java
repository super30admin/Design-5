//time complexity- O(n)
//space complexity- O(1)
public class CopyListWithRandomPointer {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public static Node copyRandomList(Node head) {
        if(head == null) return null;

        Node curr = head;
        while(curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = curr.next.next;
        }

        curr = head;
        while(curr!= null){
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = head.next;
        while(curr != null) {
            Node clone = curr.next;
            curr.next = clone.next;
            if (clone.next != null) {
                clone.next = clone.next.next;
            }
            curr = curr.next;
        }
        return newHead;
    }
    static void print(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print("Value: "+ temp.val);
            if(temp.random != null) System.out.print( "       Random connection: "+ temp.random.val);
            System.out.println();
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        System.out.println("Original:");
        print(head);

        Node newHead = copyRandomList(head);
        System.out.println();
        System.out.println("Clone: ");
        print(newHead);
    }

}
