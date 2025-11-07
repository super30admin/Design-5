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

/*
TC: O(n) -> 3n -> three passes
SC: O(1) -> constant space
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr = head;
        Node copyCurr = curr.next;
        //populate random pointers for deep copy nodes
        while (curr != null) {
            if(curr.random != null){
                copyCurr.random = curr.random.next;
            }
            curr = curr.next.next;
            //handling the edgecase for the last element in the list
            if(copyCurr.next != null)
                copyCurr = copyCurr.next.next;
        }

        curr = head;
        copyCurr = curr.next;

        //very first node of the copy current list
        // bifugrating the two list
        Node copyHead = curr.next;
        while(curr != null){
            curr.next = curr.next.next;
            if(copyCurr.next != null)
                copyCurr.next = copyCurr.next.next;
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }

}

//Another approach:
/*
 * We use a helper function to clone each node and store it in a map.
 * While traversing, we use this map to assign both next and random pointers.
 * In the end, we return the copy of the head from the map.
 * TC: O(n)
 * SC: O(n)
 */

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
        if (head == null)
            return null;
        Node copyHead = new Node(head.val);
        HashMap<Node, Node> map = new HashMap<>();
        map.put(head, copyHead);
        Node curr = head;
        Node copyCurr = copyHead;
        while (curr != null) {
            //if its not created, I will create it and add it to the map, if created take the copy from the map
            copyCurr.next = clone(curr.next, map);
            copyCurr.random = clone(curr.random, map);
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return copyHead;
    }

    private Node clone(Node node, HashMap<Node, Node> map) {
        if (node == null)
            return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}