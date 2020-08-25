//Time : O(n) n is the number of nodes;
// Space : O(n);
//Leetcode : worked
class Solution {
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        map = new HashMap<>();
        Node currCopy = copy(head);
        Node curr = head;
        while(curr!=null){
            currCopy.next = copy(curr.next);
            currCopy.random = copy(curr.random);
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return map.get(head);
    }
    
    private Node copy(Node node){
        if(node == null) return null;
        if(!map.containsKey(node)){
            Node curr = new Node(node.val);
            map.put(node,curr);
        }
        
        return map.get(node);
    }
}