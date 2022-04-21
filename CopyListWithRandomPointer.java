import java.util.HashMap;
/*
Time Complexity: O(N), n is the number of nodes
Space Complexity: O(n), n is the size of the recursion stack
Run on leetcode: yes
Any difficulties: no

Approach:
1. Using recursion to copy randome and next pointers with the help of HashMap
 */
public class CopyListWithRandomPointer {

    public static class Node{
        int val;
        Node next;
        Node random;

        Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static HashMap<Node, Node> map = new HashMap<>();
    public static Node copyListWithRandomPointer(Node head){
        if(head == null){
            return null;
        }
        if(map.containsKey(head)){
            return map.get(head);
        }

        Node newNode = new Node(head.val);

        map.put(head, newNode);

        newNode.next = copyListWithRandomPointer(head.next);
        newNode.random = copyListWithRandomPointer(head.random);

        return map.get(head);
    }

}
