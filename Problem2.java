//Time = O(n)
//Space = O(n)

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

        Map<Node, Node> map = new HashMap<>(); // Initialize a HashMap to store the mapping between original nodes and their copies

        Node curr = head;

        // Create a copy of each node and store the mapping in the HashMap
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Reset the current pointer to the head of the original list
        curr = head;

        // Update the next and random pointers of each copy node based on the mapping stored in the HashMap
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        // Return the head of the copy list, which is stored in the HashMap
        return map.get(head);
    }
}
