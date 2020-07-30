import java.util.*;
public class CopyListWithRandomPointer {
    HashMap<Node, Node> store;

    /**
     * Time Complexity :  O(n) where n is the number of nodes
     *  Space Complexity : O(n)
     */
    public Node copyRandomList(Node head) {
        if(head == null){return null;}
        store = new HashMap<>();                                                                
        Node temp = head;
        while(temp != null){
            Node curr = copyNode(temp);                                                     
            curr.random = copyNode(temp.random);                                     
            curr.next = copyNode(temp.next);                                                     
            temp = temp.next;
          }
        head = store.get(head);                                                                 
        return head;
    }
    private Node copyNode(Node temp){
        Node new_node=null;
        if(temp != null && !store.containsKey(temp)){                                           
        new_node = new Node(temp.val);
        store.put(temp, new_node);                                                              
        } else {
            return store.get(temp);                                                     
        }
        return new_node;                                                                     
    }


    /**
     * Time Complexity :  O(n) where n is the number of nodes
     *  Space Complexity : O(1)
     */
    public Node copyRandomList2(Node head) {
        if(head == null){return null;}
        Node temp = head;                                                               
        Node curr = null;
        while(temp != null){
            curr = new Node(temp.val);
            curr.next = temp.next;                                                              
            temp.next = curr;                                                                   
            temp = curr.next;                                                           
        }
        temp = head;
        curr = temp.next;
        while(temp != null){                                                                       
            if(temp.random != null) curr.random = temp.random.next;                             
            temp = curr.next;
            if(temp != null) curr = temp.next;                                                              
            }
        temp = head;
        head = temp.next;                                                                               
        curr = head;
        while(temp != null){
            temp.next = curr.next;                                                          
            temp = temp.next;
            if(temp != null) curr.next = temp.next;                                         
            curr = curr.next;
        }
        return head;
    }

}

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