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

//Time complexity: O(n) where n is the number of nodes in the LinkedList
//Space complexity: O(1), no auxiliary space used
//Did this run on Leetcode: yes

class CopyRandomPointersList {
    private int dummyValue = 999999;

    public Node copyRandomListOptimal(Node head) {
        if (head == null) {
            return head;
        }

        Node newHead = new Node(dummyValue);
        Node current = head;
        Node currentClone = null;

        //create clones in the first pass
        while (current != null) {
            currentClone = clone(current);
            if (current == head) {
                newHead = currentClone;
            }
            Node originalNext = current.next;
            current.next = currentClone;
            currentClone.next = originalNext;

            current = current.next.next;
            currentClone = null;
        }

        //do another pass to set the random pointers
        current = head;
        currentClone = head.next;

        while (current != null) {
            Node origRandom = current.random;
            currentClone = current.next;
            if (origRandom != null) {
                currentClone.random = origRandom.next;
            }
            current = current.next.next;
        }

        //now unlink the new LL from the old one
        current = head;
        currentClone = head.next;
        while (current != null) {
            if (current.next != null) {
                current.next = current.next.next;
            }
            if (currentClone.next != null) {
                currentClone.next = currentClone.next.next;
            }
            current = current.next;
            currentClone = currentClone.next;
        }
        return newHead;
    }

    private Node clone(Node orig) {
        return new Node(orig.val);
    }

    //Time complexity: O(n) where n is the number of nodes in the LinkedList
    //Space complexity: O(n), for the HashMap
    //Did this run on Leetcode: yes
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        this.dummyValue = 99999;
        Node newHeadNode = new Node(dummyValue);

        Node originalNode = head;
        Node current = newHeadNode;
        HashMap<Node, Node> existingClonesMap = new HashMap<>();


        while (originalNode != null) {
            //check if this node has already been created.
            current.next = createCloneNode(originalNode, existingClonesMap);
            current = current.next;
            if (originalNode.random != null) {
                current.random = createCloneNode(originalNode.random, existingClonesMap);
            }
            originalNode = originalNode.next;

        }

        return newHeadNode.next;
    }

    private Node createCloneNode(Node originalNode, HashMap<Node, Node> existingClonesMap) {
        Node clone = null;
        if (existingClonesMap.containsKey(originalNode)) {
            clone = existingClonesMap.get(originalNode);
        } else {
            clone = new Node(originalNode.val);
            existingClonesMap.put(originalNode, clone);
        }
        return clone;
    }


    //recursive solution
    //Time complexity: O(n)
    //Space complexity: O(n) hashmap and the recursive stack space.
    private int dummy = 999999;
    public Node copyRandomListRecursive(Node head) {
        if(head == null){
            return head;
        }
        HashMap<Node, Node> clonesMap = new HashMap<>();
        Node dummyClone = new Node(dummy);
        dummyClone.next = copyList(head, clonesMap);
        return dummyClone.next;
    }

    private Node copyList(Node current, HashMap<Node, Node> clonesMap){
        if(current == null){
            return null;
        }
        Node currentClone = createOrGetExistingClone(current, clonesMap);
        currentClone.next = copyList(current.next, clonesMap);
        return currentClone;
    }

    private Node createOrGetExistingClone(Node original, HashMap<Node, Node> clonesMap){
        if(! clonesMap.containsKey(original)){
            Node clone = new Node(original.val);
            clonesMap.put(original, clone);
        }
        //random
        if(original.random != null){
            if(! clonesMap.containsKey(original.random)){
                Node clone = new Node(original.random.val);
                clonesMap.put(original.random, clone);
            }
            clonesMap.get(original).random = clonesMap.get(original.random);
        }
        return clonesMap.get(original);
    }

}