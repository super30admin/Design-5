import java.util.HashMap;

public class CopyListWithRandomPointerTwoPass {

        // TWO PASS - TIME O(N) AND SPACE O(N)

        public Node copyRandomList(Node head) {

            // null case
            if(head == null)     return null;

            // deep cody of head
            Node deepHead = new Node(head.val);

            // map original nodes to copy nodes
            HashMap< Node, Node > map = new HashMap<>();   // O(N) space

            map.put(head, deepHead);

            // next pointers pass
            // keep pointers of head of list and (deep) head of copy list
            Node curr = head;
            Node currCopy = deepHead;

            // if non-null next pointer exists for current node
            while(curr.next != null) {          // O(N)

                curr = curr.next;

                Node deepCurr = new Node(curr.val);

                // add next pair to map
                map.put(curr, deepCurr);

                //update current copy after adding next pointer to it
                currCopy.next = deepCurr;

                currCopy = currCopy.next;
            }

            // random pointers pass
            curr = head;
            currCopy = deepHead;

            // until we reach the end of list
            while(curr != null) {           // O(N)

                // if non-null random pointer exists for current node
                if(curr.random != null) {

                    // get random pointer of current copy as the value of key of random pointer of original copy from map
                    currCopy.random = map.get(curr.random);
                }

                // move pointers next
                curr = curr.next;
                currCopy = currCopy.next;
            }

            // output head of copy list
            return deepHead;
        }


}

/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(N)
*/