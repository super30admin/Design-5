
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
//time complexity :O(n)
//space complexity :O(1)
/*
create deep copy of each node and place it beside original node.
connect the pointers of dummy nodes created.
split and join the original list back.
*/
class Solution {
    public Node copyRandomList(Node head) 
    {
        if(head == null){
            return null;
        }
        
        Node curr= head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        
        curr = head;
        while(curr != null){
            curr.next.random = (curr.random != null) ? curr.random.next: null;
            curr = curr.next.next;
        }
        
        Node res = head.next;
        Node curr1 = head;
        Node curr2 = head.next;
        while(curr1 != null){
            curr1.next = curr1.next.next;
            curr2.next = (curr2.next != null) ? curr2.next.next : null;
            
            curr1 = curr1.next;
            curr2 = curr2.next;
                
        }
        
        return res;
    }
}