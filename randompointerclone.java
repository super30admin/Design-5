//Time complexity:O(n)
//Space complexity:O(n)
class Solution {
    Map<Node,Node> map;
    public Node copyRandomList(Node head) {
        map=new HashMap();
        Node currCopy=clone(head);
        Node curr=head;
        while(curr!=null){
            currCopy.next=clone(curr.next);
            currCopy.random=clone(curr.random);
            curr=curr.next;
            currCopy=currCopy.next;
        }
        return map.get(head);
    }
    private Node clone(Node node){
        if(node==null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        Node newNode=new Node(node.val);
        map.put(node,newNode);
        return newNode;
    }
}