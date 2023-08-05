public class CopyListWithRandomPointerInSpace {

        // In space - TIME O(N) AND SPACE O(1)

        public Node copyRandomList(Node head) {

            if(head == null)       return null;

            Node curr = head;
            Node currCopy;

            // establish next pointers
            // 1. insert deep copy nodes in between original nodes of list and make a hybrid list
            // until end of original list
            while(curr != null) {            // O(N)

                // make a copy of current node
                currCopy = new Node(curr.val);

                // in between insertion of copy of current node
                currCopy.next = curr.next;
                curr.next = currCopy;

                // move current to next current node of original list, which will be two nexts ahead in hybrid list
                curr = curr.next.next;
            }

            // bring current node and current copy node pointers to the beginning of hybrid list
            curr = head;
            currCopy = curr.next;

            // 2. establish random pointers
            // until end of original list
            while(curr != null) {             // O(N)

                // if random pointer of current node exists
                if(curr.random != null) {

                    // random pointer of copy of current node would have been inserted just next to random pointer of current node in hybrid list
                    currCopy.random = curr.random.next;

                }
                // move current node pointer by two steps ahead to reach next actual original list node
                curr = curr.next.next;

                // until end of copy list or hybrid list
                if(currCopy.next != null) {

                    // move current copy node pointer by two steps ahead to reach next actual copy list node
                    currCopy = currCopy.next.next;
                }

            }

            // 3. split original list and deep copy list from hybrid list

            // bring current node and current copy node pointers to the beginning of hybrid list
            curr = head;
            currCopy = curr.next;

            // store for output
            Node result = currCopy;

            // until end of original/hybrid list
            while(curr != null && currCopy != null) {              // O(N)

                // separate two lists now
                curr.next = curr.next.next;
                if(currCopy.next != null) {

                    currCopy.next = currCopy.next.next;
                }

                // move ahead in two lists (original and copy)
                curr = curr.next;
                currCopy = currCopy.next;
            }

            // output head of copy list
            return result;

        }

}

/*
TIME COMPLEXITY = O(N)
SPACE COMPLEXITY = O(1)
*/

/*

// 2. establish random pointers - alternative
        curr = head;
        currCopy = null;
        // until end of original list
        while(curr != null) {             // O(N)

            // copy lies next to original
            currCopy = curr.next;

            // if random pointer of current node exists
            if(curr.random != null) {

                  // random pointer of copy of current node would have been inserted just next to random pointer of current node in hybrid list
            currCopy.random = curr.random.next;

            }
            // move current node pointer by two steps ahead to reach next actual original list node
            curr = curr.next.next;

        }
 */