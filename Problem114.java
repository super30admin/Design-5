//TC: O(n)
//SC: O(1)
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
        if (head == null) {
            return null;
        }

        // Step 1: Create new nodes and interweave them with original nodes
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val); // Create new node
            newNode.next = current.next; // Set new node's next to current's next
            current.next = newNode; // Insert new node after current
            current = newNode.next; // Move to the next original node
        }

        // Step 2: Set the random pointers for the new nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next; // Set the random pointer for the copied node
            }
            current = current.next.next; // Move to the next original node
        }

        // Step 3: Separate the original list and the copied list
        current = head;
        Node newHead = head.next; // Head of the new copied list
        Node copyCurrent = newHead;

        while (current != null) {
            current.next = current.next.next; // Restore the original list's next pointers
            if (copyCurrent.next != null) {
                copyCurrent.next = copyCurrent.next.next; // Separate the copied list's next pointers
            }
            current = current.next; // Move to the next original node
            copyCurrent = copyCurrent.next; // Move to the next copied node
        }

        return newHead; // Return the head of the deep copied list
    }

    // Utility method for printing the list (for testing)
    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            String randomVal = (current.random != null) ? String.valueOf(current.random.val) : "null";
            System.out.println("Node Value: " + current.val + ", Random points to: " + randomVal);
            current = current.next;
        }
    }
}
