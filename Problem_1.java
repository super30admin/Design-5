// Time Complexity :O(n)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode :
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach

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
        Node newHead=new Node(-1);
        Node temp=head;
        HashMap<Node,Node> hash=new HashMap<>();
        Node list=newHead;
        while(temp!=null){
            Node myNode=new Node(temp.val);
            newHead.next=myNode;
            newHead=newHead.next;
            hash.put(temp,myNode);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            Node node=hash.get(temp);
            node.next=hash.get(temp.next);
            node.random=hash.get(temp.random);
            temp=temp.next;
        }
        return list.next;
    }
}