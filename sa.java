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
//o(n) time and o(n) space for hasmap
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        if (head == null ) return null;

        Node curr = head;
        Node result = new Node(head.val);
        Node currcopy = result;
        map.put(curr, currcopy);
        while(curr != null){
            Node nextNode = curr.next;
            Node randNode = curr.random;
            if(nextNode != null && !map.containsKey(nextNode)) {
                map.put(nextNode, new Node(nextNode.val));
            }
            if(randNode != null && !map.containsKey(randNode)) {
                map.put(randNode, new Node(randNode.val));
            }

            currcopy.next = map.get(nextNode);
            currcopy.random = map.get(randNode);

            curr = curr.next;
            currcopy = currcopy.next;

        }
        return result;

    }
}

