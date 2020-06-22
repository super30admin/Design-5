/**
 * Time complexity: O(N) N is number of node;
 * Space complexity: O(N) N is number of node;
 * 
 * Approach:
 * 1. Map the newly created nodes to the old ones.
 * 2. While creating new list, refer to the map, for next and random pointers of given node.
 */

public class CopyList {
    public Node copyRandomList(Node head) {
     
        Map<Node, Node> map = new HashMap<>();
        
        Node temp = head;
        Node randome;
        
        while(temp != null) {
            
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        
        }
        
        temp = head;
        
        while(temp != null) {
            Node n = map.get(temp);
            n.next = map.get(temp.next);
            n.random = map.get(temp.random);
            temp = temp.next;
            
        }
        
        return map.get(head);
    }

    /**
     * //Approach without extra space: Add new node in between the original nodes.
     * 
     * if(head == null)
            return head;
        
        Node temp = head;
        
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
        
        temp = head;
        while(temp != null) {
            Node newNode = temp.next;
            if(temp.random != null) {
                newNode.random = temp.random.next;
            }
            temp = temp.next.next;
        }
        
        temp = head;
        Node newHead = new Node(0);
        Node tail = newHead;
        Node n;
        while( temp!= null) {
            n = temp.next;
            
            tail.next = n;
            tail = n;
            
            temp.next = temp.next.next;
            temp = temp.next;
        }
        
        return newHead.next;
     */
}