// TC : O(n)
// SC : O(1)

package S30_Codes.Design_5;

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

class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node cur = head;

        while(cur != null){
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = newNode.next;
        }

        cur = head;
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node copyHead = cur.next;
        Node copyCur = cur.next;

        while(cur != null){
            cur.next = cur.next.next;
            if(cur.next != null)
                copyCur.next = cur.next.next;
            cur = cur.next;
            copyCur = copyCur.next;
        }
        return copyHead;
    }
}