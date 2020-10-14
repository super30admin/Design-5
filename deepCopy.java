//Time Complexity: O(n) length of list
//Space Complexity: O(n) for the hashamp
//Did it run on leetcode: yes
/** Approach: First I have iterated the linked list and created new nodes and have put them in hashmap
hashmap contains original node as key and new node as value
Second I have connected the new nodes with taking new head
Third using the hashmap I have assigned random pointers 
Since I used a hashmap to get the reference takes only O(1) time
**/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        
        Map<Node, Node> map = new HashMap<>();
        
        Node dummy1 = head;
        
        while(dummy1!=null){
            Node newNode = new Node(dummy1.val);
            map.put(dummy1,newNode);
            dummy1 = dummy1.next;
            newNode = newNode.next;
        }
        dummy1 = head;
       
        Node newHead = map.get(head);
        Node dummy2 = newHead;
        while(dummy1.next!=null){
            dummy2.next = map.get(dummy1.next);
            dummy1 = dummy1.next;
            dummy2= dummy2.next;
        }
        
        dummy1 = head;
        dummy2 = newHead;
        
        while(dummy1!=null){
            if(map.containsKey(dummy1.random))
                dummy2.random = map.get(dummy1.random);
            else
                dummy2.random = null;
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
        }
        
        return newHead;
    }
}
