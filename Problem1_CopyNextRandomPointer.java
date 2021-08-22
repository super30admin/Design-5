
// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    Map<Node,Node> copyMap;
    public Node copyRandomList(Node head) {
        
        if(head==null)
            return head;
        
        copyMap= new HashMap<>();
        
        Node cloneHead=clone(head);
        
        Node curr=head, currCopy=cloneHead;
        
        while(curr!=null)
        {
            currCopy.next=clone(curr.next);
            currCopy.random=clone(curr.random);
            curr=curr.next;
            currCopy=currCopy.next;
        }
        return cloneHead;
    }
    
    private Node clone(Node node)
    {
        if(node==null)
            return null;
        
        //deep copy already created
        if(copyMap.containsKey(node))
        {
            return copyMap.get(node);
        }
        
        //create a deep copy and return it
        
        Node newNode=new Node(node.val);
        copyMap.put(node,newNode);
        
        return newNode;
            
    }
}
*/
class Solution {
    
    public Node copyRandomList(Node head)
    {
        if(head==null)
            return head;
        
        // deep copy of every node
        Node curr=head;
        
        while(curr!=null)
        {
            //deep copy pointing to next node
            Node newCloneNode=clone(curr);
            newCloneNode.next=curr.next;
            curr.next=newCloneNode;
            curr=curr.next.next;
        }
        
        //random pointers of every node
        curr=head;
        while(curr!=null)
        {
            if(curr.random!=null)
               curr.next.random=curr.random.next;
            
            curr=curr.next.next;
        }
        
        //spliting lists
        curr=head;
        Node copy=head.next;
        Node copyHead= head.next;
        
        while(curr!=null)
        {
            curr.next=curr.next.next;
            
            if(copy.next!=null)
            {
                copy.next=copy.next.next;
            }
            
            curr=curr.next;
            copy=copy.next;
        }
        return copyHead;
    }
    
    
    private Node clone(Node node)
    {
        if(node==null)
            return null;
        
        Node newNode =new Node(node.val);
        return newNode;
    }
        
}
