// Time complexity O(N) 
// Space complexity O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            Node temp = curr.next;
            curr.next = newNode;
            newNode.next = temp;
            curr = curr.next.next;
        }
        
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
          
        curr = head;
        Node newList = curr.next;
        Node newHead = newList;
        while(curr!= null ){
            curr.next = curr.next.next;
            if (newList.next != null) {
                 newList.next = newList.next.next;     
            }
            curr = curr.next;
            newList = newList.next;
        }
        return newHead;
    }
}