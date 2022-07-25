//****112.138.COPY LIST WITH RANDOM POINTER****
//Time complexity:o(n);
//Space Complexity:0(n);
//

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
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        map=new HashMap<>();
        
        //null case
        if(head==null)
        {
            return null;
        }
        
        //Making the head of copy linkedlist(Deepcopy)
        Node copyhead=clone(head);
        //Getting a pointer for the current list head
        Node curr=head;
        Node copycurr=copyhead;
        
        //Iterating
        while(curr!=null)
        {
            copycurr.next=clone(curr.next);
            if(curr.random!=null)
            {
                copycurr.random=clone(curr.random);
            }
            curr=curr.next;
            copycurr=copycurr.next;
        }
        return copyhead;
    }
    
    private Node clone(Node node)
    {
        if(node==null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node newnode=new Node(node.val);
        map.put(node, newnode);
        return newnode;
    }
}
