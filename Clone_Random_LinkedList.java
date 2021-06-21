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
    //Time O(N)
    //Space O(1)
    HashMap<Node , Node> map;
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return head;
        }
        map = new HashMap<>();
        Node curr = head;
        while(curr != null)
        {
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }
        curr = head;
        while(curr != null)
        {
            Node temp = curr.random;
            if(temp != null) curr.next.random = temp.next;
            curr = curr.next.next;
        }
        Node prev = head;
        Node ans = prev.next;
        while(prev != null)
        {
            Node temp1 = prev.next;
            prev.next = prev.next.next;
            if(temp1.next != null) temp1.next = temp1.next.next;
            prev = prev.next;
            temp1 = temp1.next;
        }
        return ans;
    }
}