import java.util.*;

public class CopyList {
    
    HashMap<Node, Node> map; 
    
    private Node getCopyNode(Node current) {
        if(current == null) return null;
        Node newNode = new Node(current.val);
        if(map.containsKey(current)) {
            return map.get(current);
        } else {
            map.put(current, newNode);
        }
        return newNode;
    }
    

    //TC: O(N) - Traversing all the old list and creating a new list.
    //SC: O(N) - HashMap to save the pointers.
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        //Traverse head and create a new list
        //Check if the current node key exist or not. If exists, return the value
        //Else create a new node and save.
        map = new HashMap();
        Node result = getCopyNode(head);
        Node copyPointer = result;
        Node current = head;
        
        while(current!=null) {
            copyPointer.next = getCopyNode(current.next);
            copyPointer.random = getCopyNode(current.random);
            copyPointer = copyPointer.next;
            current = current.next;
        }
        return result;
         
    }
    public static void main(String[] args) {

    }
}
