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

time complexity O(n) space complexity O(n)
deep copy all the nodes and while copying copy their random and next pointer nodes store them in hashmap so as to not recopy them
*/

class Solution {
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        map=new HashMap<>();
        Node curr=head;
        Node newNode =clone(head);
        Node newCurr=newNode;
        while(curr!=null){
            newNode.random=clone(curr.random);
            newNode.next=clone(curr.next);
            curr=curr.next;
            newNode=newNode.next;
        }
        return newCurr;
    }
    private Node clone(Node head){
        if(head==null) return null;
        if(map.containsKey(head)) return map.get(head);
        Node newn =new Node(head.val);
        map.put(head,newn);
        return newn;
    }
}