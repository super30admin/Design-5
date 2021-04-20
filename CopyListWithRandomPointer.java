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

class Solution {
    public Node copyRandomList(Node head) {
         if(head == null){
            return null;
        }
        
        Node temp = head;
        HashMap<Node, Node> map = new HashMap<>();
        
        //creating copy of all new Nodes and storing them in a hashMap for reference
        while(temp != null){
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
        }
        
        //pointing new nodes to its corressponding next and random nodes
        for(Map.Entry<Node ,Node> entry : map.entrySet()){
            Node prev = entry.getKey();
            Node curr = entry.getValue();
            
            curr.next = map.get(prev.next);
            curr.random = map.get(prev.random);
        }
        
        return map.get(head);
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)