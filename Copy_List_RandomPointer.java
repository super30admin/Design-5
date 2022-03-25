//By using HashMap
//TC: o(n) Asymptotic

//space o(n)

        
class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {   
        
        //o(N) space solution
        map = new HashMap<>();
        Node curr = head;
        Node copyHead = clone(curr);
        Node currCopy = copyHead;
        while(curr != null){
            currCopy.next = clone(curr.next);
            if(curr.random != null){
                currCopy.random = clone(curr.random);
            }
            curr = curr.next;
            currCopy = currCopy.next;
        }
        return copyHead;
        
    }
    private Node clone(Node node){
        if(node == null){
            return null;
        }
        
        if(map.containsKey(node)){
            return map.get(node);
        }else{
            Node cloneNode = new Node(node.val);
            map.put(node, cloneNode);
        }
        return map.get(node);
}
}