//Time Complexity: O(n)
//Space Complexity: O(n)
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
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        map=new HashMap<>();
        Node curr=head;
        Node copyHead=clone(head);
        Node currCopy=copyHead;
        while(curr!=null){
            currCopy.next=clone(curr.next);
            currCopy.random=clone(curr.random);
            curr=curr.next;
            currCopy=currCopy.next;
        }
        return copyHead;
    }
    private Node clone(Node node){
        if(node==null)
            return null;
        if(map.containsKey(node))
            return map.get(node);
        else
            map.put(node,new Node(node.val));
        return map.get(node);
    }
    
}

//Time Complexity: O(n)
//Space Complexity: O(1)
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
        if(head==null)
            return head;
        Node curr=head;
        
        //Creating deep copies next to originals
        while(curr!=null){
            Node newNode=new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=curr.next.next;
        }
        
        //assign random pointers
        curr=head;
        while(curr!=null){
            if(curr.random!=null)
                curr.next.random=curr.random.next;
            curr=curr.next.next;
        }
        
        //Split lists
        curr=head;
        Node currCopy=head.next;
        Node copyhead=head.next;
        while(curr!=null){
            curr.next=curr.next.next;
            if(currCopy.next!=null)
                currCopy.next=currCopy.next.next;
            curr=curr.next;
            currCopy=currCopy.next;
        }
        return copyhead;
    }
}
