class Solution {// class Time of O(n) and space of O(n)
    HashMap<Node,Node> visited = new HashMap<>();
    public Node copyRandomList(Node head) {
        //Base case 
        if(head == null)
            return null;
        
        Node oldNode = head ;
        Node newNode = new Node(oldNode.val);
        visited.put(oldNode,newNode);
        
        //traverse linked list
        while(oldNode!= null){
            newNode.random = clone(oldNode.random);
            newNode.next = clone(oldNode.next);
                
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return visited.get(head) ;
    }
    private Node clone(Node node){
        //Base case
        if(node != null){
            if(visited.containsKey(node)){
                return visited.get(node);
            }else{
                visited.put(node,new Node(node.val,null ,null));
                return visited.get(node);
            }
        }
        return null;
    }
}