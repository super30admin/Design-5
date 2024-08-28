import java.util.HashMap;

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

public class CopyListWithRandomPointer {
    HashMap<Node, Node> map;

    public Node copyRandomListHashMap(Node head) { //O(n) T.C single pass, O(n) S.C
        if (head == null) return null;

        this.map = new HashMap<>();
        Node curr = head; //pointer that moves
        Node copyHead = new Node(head.val); //deep copy of head node
        Node copyCurr = copyHead; //pointer on deep copy that moves
        map.put(curr, copyCurr); //add the initial head and its deep copy to map

        while (curr != null) { //traverse until end of list
            if (curr.next != null) { //only if the current node has a next
                if (map.containsKey(curr.next)) { //if map already consists the current node's deep copy
                    copyCurr.next = map.get(curr.next); //attach that copied node to current copied node's next
                } else {
                    Node newNode = new Node(curr.next.val); //create a new deep copy node
                    copyCurr.next = newNode; //and attach it to current deep copy's next
                    map.put(curr.next, newNode); //also put inside map
                }
            }

            if (curr.random != null) { //in a single pass, also checking for random pointer
                if (map.containsKey(curr.random)) { //same as above
                    copyCurr.random = map.get(curr.random);
                } else {
                    Node randomNode = new Node(curr.random.val);
                    copyCurr.random = randomNode;
                    map.put(curr.random, randomNode);
                }
            }

            curr = curr.next; //move curr to its next
            copyCurr = copyCurr.next; //and copy curr to its next
        }
        return copyHead;
    }

    public Node copyRandomList(Node head) { //O(3n) T.C triple pass, O(1) S.C
        if (head == null) return null;

        Node curr = head;

        //Combine the lists. i.e., node1 -> node1copy -> node2 -> node2copy...
        while (curr != null) {
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next; //make deep copy's next point to current node's next
            curr.next = copyCurr; //make current node's next point to its deep copy
            curr = curr.next.next;
        }

        curr = head; //reset curr
        //attach random pointers
        while (curr != null) {
            if (curr.random != null) { //if current has a random
                curr.next.random = curr.random.next; //curr node's copy's random point to curr node's random's copy
            }
            curr = curr.next.next;
        }

        curr = head;
        Node copyHead = curr.next;
        Node copyCurr = copyHead;

        //Break the combined list to 2 separate lists
        while (curr != null) {
            curr.next = curr.next.next; //attach curr's next to correct next in line
            assert copyCurr != null;
            if (copyCurr.next != null) { //if currCopy has a next, means there are still valid nodes
                copyCurr.next = copyCurr.next.next; //attach to currCopy's next all deep copy nodes
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }

    public static void main(String[] args) {
        // Creating sample input list
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        // Setting up next pointers
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Setting up random pointers
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        // Create a deep copy of the list
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        Node copiedListHead = copyListWithRandomPointer.copyRandomList(node1);

        // Print original and copied lists for comparison
        System.out.println("Original list:");
        printList(node1);
        System.out.println("\nCopied list:");
        printList(copiedListHead);

        Node copiedListHead2 = copyListWithRandomPointer.copyRandomListHashMap(node1);
        // Print original and copied lists for comparison
        System.out.println("Original list:");
        printList(node1);
        System.out.println("\nCopied list:");
        printList(copiedListHead2);
    }

    // Utility method to print the list
    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.println("Node value: " + temp.val + ", Random value: " + randomVal);
            temp = temp.next;
        }
    }
}