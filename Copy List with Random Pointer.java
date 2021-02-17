/* tc - O(n) space - O(n)
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        self.mapping = dict()
        newHead = self.clone(head)
        pnew = newHead
        pold = head
        
        while pold is not None:
            pnew.next = self.clone(pold.next)
            pnew.random = self.clone(pold.random)
            pnew = pnew.next
            pold = pold.next
        return newHead
        
    def clone(self, cur):
        if cur is None:
            return None
        
        if cur in self.mapping:
            return self.mapping[cur]
        
        node = Node(cur.val)
        self.mapping[cur] = node
        return node

class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        Node newhead = clone(head);
        Node cur = head;
        Node p1 = newhead;
        
        while (cur != null){
            p1.next = clone(cur.next);
            p1.random = clone(cur.random);
            p1 = p1.next;
            cur = cur.next;
        }
        return newhead;
    }
    private Node clone(Node cur){
        if (cur == null)
            return cur;
        
        if (map.containsKey(cur))
            return map.get(cur);
        
        Node node = new Node(cur.val);
        map.put(cur, node);
        return node;
    }
}
*/

/*        
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if head is None:
            return head
        
        cur = head
        while cur is not None:
            temp = cur.next
            cur.next = Node(cur.val)
            cur.next.next = temp
            cur = temp
        
        cur = head
        while cur is not None:
            if cur.random is not None:
                cur.next.random = cur.random.next
            cur = cur.next.next
            
        cur = head
        pnew = cur.next
        newHead = pnew
        while cur is not None:
            cur.next = cur.next.next
            if pnew.next is not None:
                pnew.next = pnew.next.next
            
            cur = cur.next
            pnew = pnew.next
            
            
        return newHead
*/

// Time - O(n) where n is size of original list
// Space - O(1)
// Logic - First created duplicate nodes within the same list so that linking random pointer should be easy task and then separated both lists
class Solution {
    
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;
        
        // create new node
        Node cur = head;
        while (cur != null){
            Node temp = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = temp;
            cur = temp;
        }
        
        // create random links
        cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        // separate lists
        cur = head;
        Node newhead = cur.next;
        Node pnew = newhead;
        
        while (cur != null){
            cur.next = cur.next.next;
            if (pnew.next != null){
                pnew.next = pnew.next.next; 
            }
            cur = cur.next;
            pnew = pnew.next;
        }
        return newhead;
    }
   
}