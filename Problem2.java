//Time Complexity: O(N)
//Space Complexity: O(1)

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

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Node index = head;
        Node next;
        while(index!=null){
            next = index.next;
            index.next = new Node(index.val);
            index.next.next = next;
            index = next;
        }

        index = head;
        Node random;

        while(index!=null){
            random = index.random;
            index.next.random = random==null?null:random.next;
            index = index.next.next;
        }


        index = head.next;
        Node ret = index;
        Node prev = head;
        while(index!=null){
            prev.next = index.next;
            prev = index.next;
            index.next = index.next==null?null:index.next.next;
            index = index.next;

        }
        return ret;

    }
}