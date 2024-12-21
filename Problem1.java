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
//TC:O(3N)
//SC:O(1)
class Problem1 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Clone nodes and interleave them with the original list
        Node current = head;
        while (current != null) {
            Node clone = new Node(current.val);  // Clone the node
            clone.next = current.next;           // Set clone's next to current's next
            current.next = clone;                // Insert the clone right next to the original node
            current = clone.next;                // Move to the next original node
        }

        // Step 2: Set random pointers for the cloned nodes
        current = head;
        while (current != null && current.next != null) {
            Node next = current.next;
            Node random = current.random;
            Node newRandom = null;
            if(null != random){
                newRandom = random.next;
            }

            next.random = newRandom;
            current = current.next.next;
        }

        // Step 3: Separate the interleaved lists
        current = head;
        Node cloneHead = head.next;
        Node cloneCurrent = cloneHead;

        while(current != null && cloneCurrent != null){
            Node clonedNext = null;
            if(cloneCurrent.next !=null){
                clonedNext = cloneCurrent.next.next;
            }

            Node next = cloneCurrent.next;

            current.next = next;
            cloneCurrent.next = clonedNext;

            current = current.next;
            cloneCurrent = cloneCurrent.next;
        }

        return cloneHead;  // Return the head of the cloned list
    }
}