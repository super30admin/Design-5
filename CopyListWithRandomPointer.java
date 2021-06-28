package Design5;

import java.util.HashMap;

/*
-------------------------------------------------------------------------------------------------------
        Time complexity :O(N) 
        space complexity:O(N) 
        Approach:
        Did this code run successfully in leetcode : yes
        problems faces : no*/

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {

        if (head == null)
            return head;

        HashMap<Node, Node> map = new HashMap<Node, Node>();
        Node CopyHead = new Node(head.val);
        map.put(head, CopyHead);

        Node curr = head;
        Node currCopy = CopyHead;

        while (curr != null) {
            if (curr.random != null && !map.containsKey(curr.random)) {
                Node randomNode = new Node(curr.random.val);
                map.put(curr.random, randomNode);
                currCopy.random = randomNode;

            } else if (curr.random != null) {
                currCopy.random = map.get(curr.random);
            }

            if (curr.next != null && !map.containsKey(curr.next)) {
                Node nextNode = new Node(curr.next.val);
                map.put(curr.next, nextNode);
                currCopy.next = nextNode;
            } else if (curr.next != null) {
                currCopy.next = map.get(curr.next);
            }

            curr = curr.next;
            currCopy = currCopy.next;
        }

        return CopyHead;

    }
    
/* -------------------------------------------------------------------------------------------------------
 Time complexity :O(N) 
 space complexity:O(1) 
 Approach:
 Did this code run successfully in leetcode : yes
 problems faces : no*/
    
    public Node copyRandomListWithoutMap(Node head) {

        if (head == null)
            return head;

        Node curr = head;
        
        //create deep copy node for each node and put it next to original node
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next =  curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        
        curr = head;
        //create random pointers
        while (curr != null) {
          
            if(curr.random != null)
            {
                curr.next.random = curr.random.next ; 
            }
            curr = curr.next.next;
            
        }
        
        //split the list and get deep copied 
        curr = head;
        Node copyHead = head.next;
        Node currCopy = copyHead;
        while(curr != null)
        {
            curr.next =curr.next.next; //skip the deep copy node in between
            if(curr.next != null)
            {
                currCopy.next = currCopy.next.next;
            }
            curr = curr.next; 
            currCopy = currCopy.next;
        }

        return copyHead ;

    }

}
