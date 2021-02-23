package Design-5;
// Time Complexity :O(n) n is number of nodes in the list
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public class CopyListWithRandomPointer {
    class Solution {
        public Node copyRandomList(Node head) {
            
            Map<Node,Node> map = new HashMap<>();
            Node node = head;
            while(node!=null)
            {
                map.put(node,new Node(node.val));
                node = node.next;
            }
            node = head;
            while(node!=null)
            {
                Node newNode = map.get(node);
                newNode.next = map.get(node.next);
                newNode.random = map.get(node.random);
                node = node.next;
            }
            
            return map.get(head);
        }
    }    
}
