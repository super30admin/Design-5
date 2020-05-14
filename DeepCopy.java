// 138.
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        return copyOnePass(head);
    }
    
    //time - O(n)
    //space - O(n)
    private Node copyTwoPass(Node head) {
        HashMap<Node, Node> clones = new HashMap<>(); //map of each node in list to its clone
        //build clone for each node in first pass
        Node current = head;
        while(current != null)
        {
            Node clone = new Node(current.val, null, null); // clone node with just val and null for next and random
            clones.put(current, clone);
            current = current.next;
        }
        current = head;
        while(current != null)
        {
            Node clone = clones.get(current); //copy of current
            Node next = clones.get(current.next); //copy of current's next
            Node random = clones.get(current.random); //copy of current's random
            clone.next = next; //setting next and random pointers of current's copy 
            clone.random = random;
            current = current.next;
        }
        return clones.get(head);
    }
    
    //time - O(n)
    //space - O(n)
    private Node copyOnePass(Node head) {
        HashMap<Node, Node> clones = new HashMap<>(); //map of each node in list to its clone
        Node current = head;
        Node copy = clone(head, clones); //clone the head
        while(current != null)
        {
            copy.next = clone(current.next, clones); //clone the next and random of current in copied list
            copy.random = clone(current.random, clones);
            copy = copy.next;
            current = current.next;
        }
        return clone(head, clones); //or return clones.get(head)
    }
    
    //time - O(1)
    private Node clone(Node original, HashMap<Node, Node> clones) {
        if(original == null)
        {
            return null;
        }
        if(!clones.containsKey(original)) //if map doesnt contain the given node, add the node with its copy
        {
            clones.put(original, new Node(original.val, null, null));
        }
        return clones.get(original); //return copy from map
    }
}
