// Time Complexity : O(n)
// Space Complexity :O(n), hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// for each node, we clone its random pointer and next pointer and set the pointers to them
// to avoid duplicates and to lookup if we already clone it maintain a hashmap of the nodes to link it

class Solution {
    HashMap<Node, Node> visited = new HashMap<Node, Node>();
    
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        
        Node oldNode = head;
        
        Node newNode = new Node(oldNode.val);
        this.visited.put(oldNode, newNode);

        while(oldNode!=null){
            newNode.random = this.clone(oldNode.random);
            newNode.next = this.clone(oldNode.next);
            
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        
        return this.visited.get(head);
    }
    
    private Node clone(Node node){
        if(node!=null){
            if(this.visited.containsKey(node)){
                return this.visited.get(node);
            }
            else{
                this.visited.put(node, new Node(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }
    
}