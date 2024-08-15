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
TC --> O(n)
SC --> O(n)
*/


class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> mp = new HashMap<>();
        Node curr = head;
        while(curr!=null){
            if(!mp.containsKey(curr)){
                Node newNode = new Node(curr.val);
                mp.put(curr,newNode);
            }
            if(curr.random!=null && !mp.containsKey(curr.random)){
                Node newNode = new Node(curr.random.val);
                mp.put(curr.random, newNode);
            }

            curr = curr.next;
        }//while

        Node newHead = mp.get(head);
        curr = head;
        while(curr!=null){
            Node n = mp.get(curr);
            n.next = mp.get(curr.next);
            n.random = mp.get(curr.random);
            curr = curr.next;
        }//while

        return newHead;
    }//method
}//class