// Time - o(N)
//Space - o(1)
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Base case: If the list is empty, return null.
        if (head == null) return null;

        // Step 1: Create a copy of each node and interweave it with the original nodes.
        Node curr = head;
        while (curr != null) {
            // Create a new node with the same value as the current node.
            Node copy = new Node(curr.val);
            
            // Insert the copy node right after the current node.
            copy.next = curr.next;
            curr.next = copy;
            
            // Move to the next original node.
            curr = copy.next;
        }

        // Step 2: Set up the random pointers for the copied nodes.
        curr = head;
        while (curr != null) {
            // If the current node has a random pointer, set the random pointer of the copied node.
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            // Move to the next original node.
            curr = curr.next.next;
        }

        // Step 3: Separate the interwoven list into the original and copied lists.
        Node copyHead = head.next;  // The head of the copied list.
        Node copyCurr = copyHead;
        curr = head;
        
        while (curr != null) {
            // Restore the next pointer of the original node.
            curr.next = curr.next.next;
            
            // Restore the next pointer of the copied node.
            if (copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            
            // Move to the next original and copied nodes.
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        // Return the head of the copied list.
        return copyHead;
    }
}
