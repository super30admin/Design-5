
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// Without using a HashMap. We will make the deep copy of the new nodes adjacent to the original nodes. 
// The we will find the random pointer of the original nodes and make the same connections in the new nodes. 
// Then we will disconnect the deep copy from its original nodes


class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        //create deep copies
        Node curr=head;
        while(curr!=null)
        {
            Node newNode=new Node(curr.val);
            newNode.next=curr.next;// Connect the new node to the next node of the original node
            curr.next=newNode;  //Connect the original node to the new node
            //move the curr pointer to the next pointer
            curr=curr.next.next;
        }

        //create random pointer
        curr=head;
        Node copyCurr=head.next;    
        Node copyHead=head.next;

        //random pointer
        while(curr!=null)
        {
            if(curr.random!=null)
            {
                copyCurr.random=curr.random.next;
            }
            //moving the pointer to the next node
            curr=curr.next.next;
            if (copyCurr.next!=null)
            {
                copyCurr=copyCurr.next.next;
            }
        }

        //split
        curr=head;
        copyCurr=head.next;

        while(curr!=null)
        {
            curr.next=curr.next.next;
             if (copyCurr.next!=null)
            {
                copyCurr.next=copyCurr.next.next;
            }

            //move the pointer
            curr=curr.next;
            copyCurr=copyCurr.next;
        }

        return copyHead;
    }
}


// TC: O(n) SC: O(n) 
// We will be using a hashmap to store the original nodes as the keys and the new nodes as their respective values.
// We will check if the next node is present in the hashmap, if not we add it and make the connection. If it is 
// present we make the connection and check if it has a random node as well. If yes, then we will make that connection as well.



class Solution {
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        Node copyHead=new Node(head.val);
        map.put(head,copyHead);
        Node curr=head;
        Node copyCurr=copyHead;

        while(curr!=null)
        {
            copyCurr.next=clone(curr.next,map);
            copyCurr.random= clone(curr.random,map);
            curr=curr.next;
            copyCurr=copyCurr.next;
        }
        return copyHead;
    }

    private Node clone( Node node, HashMap<Node, Node>map)
    {
        if (node==null) return null;
        // if the node is not present in the HashMap
        if(!map.containsKey(node))
        {
            Node newNode=new Node(node.val);
            map.put(node,newNode);
        }

        //return the new Node from the HashMap
        return map.get(node);

    }
}

