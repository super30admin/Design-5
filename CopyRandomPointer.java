/*
Time Complexity - O(N)
Space Complexity - O(N)
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node clone = new Node(-1);
        Node temp1 = clone;
        Node temp2 = head;
        Map<Node,Node> map = new HashMap<>();
        while(temp2 != null){
            Node node = new Node(temp2.val);
            temp1.next = node;
            map.put(temp2,node);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        temp2 = head;
        while(temp2!=null){
            Node node = map.get(temp2);
            Node random_node = temp2.random;
            if(random_node != null){
                Node node2 = map.get(random_node);
                node.random = node2;
            }
            temp2 = temp2.next;
        }
        return clone.next;
    }
}