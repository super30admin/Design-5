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

class Solution 
{
    
   Map<Node, Node> map = new HashMap<>();
    
    public Node copyRandomList(Node head) 
    {
        Map<Node, Node> map = new HashMap<>();
        
        Node dummy = new Node(-1);
        Node current = dummy;
        
        Node temp = head;
        
        while(temp != null)
        {   
            Node random = temp.random;
            Node next = temp.next;
            
            Node newNode = getNode(temp);
            Node newRandom = null;
            Node newNext = null;
            
            if(next != null)
                newNext = getNode(next);
            
            if(random != null)
                newRandom = getNode(random);
            
            newNode.random = newRandom;
            newNode.next = newNext;
            
            current.next = newNode;
            current = current.next;
            
            temp = temp.next;
            
        }
        
        return dummy.next;
        
    }
    
    private Node getNode(Node node)
    {
        Node newNode = null;
        if(!map.containsKey(node))
        {
            newNode = new Node(node.val);
            map.put(node, newNode);
        }
        else
        {
            newNode = map.get(node);
        }
        
        return newNode;
    }
}