//way1
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

//In first pass: create deep copy of every node and store references in map
//In second pass: create random pointers for every newly formed deep copied nodes
//TC: O(2n)
//SC: O(n)
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        
        Map<Node,Node> map=new HashMap<>();
        Node curr=head;
        Node copycurr=new Node(curr.val);
        map.put(curr,copycurr);

        //first pass: create deep copy of all nodes and put them in map
        while(curr.next!=null){
            Node newNode=new Node(curr.next.val);
            map.put(curr.next,newNode);

            copycurr.next=newNode;
            curr=curr.next;
            copycurr=copycurr.next;
        }

        curr=head;
        copycurr=map.get(head);
        //second pass: create random pointers for every deepcopied node
        while(curr!=null){
            if(curr.random!=null){
                copycurr.random=map.get(curr.random);
            }
            curr=curr.next;
            copycurr=copycurr.next;
        }

        return map.get(head);
        
    }
}


//way2
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
//One pass
//For every node, check whether it is already present in map or not
//if not, create a deepcopy. Add in map
//make connections by getting the node from map
//TC: O(n)
//Sc: O(n)
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        
        Map<Node,Node> map=new HashMap<>();
        //first node
        Node curr=head;
        //first nodes deepcopy
        Node copycurr=new Node(head.val);
        
        map.put(curr,copycurr);
        //first node's random and it's deep copy
        if(curr.random!=null){
            if(!(map.containsKey(curr.random))){
                    map.put(curr.random,new Node(curr.random.val));
                }

            copycurr.random=map.get(curr.random);
        }

        //remaining nodes
        while(curr.next!=null){
            //next node copy
            Node node=curr.next;
            if(!(map.containsKey(node))){
                map.put(node,new Node(node.val));
            }

            copycurr.next=map.get(node);

            //random node copy
            if(node.random!=null){
                if(!(map.containsKey(node.random))){
                    map.put(node.random,new Node(node.random.val));
                }

                copycurr.next.random=map.get(node.random);
            }

            //Moving to next pointer
            curr=curr.next;
            copycurr=copycurr.next;


        }

        return map.get(head);

        
    }
}


//way3
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

//Travel through all nodes
//First pass: create deep copied node and add it to next of curr node. 
//ie currNode currNodeDeepCopy currNodeNextNodes--
//Second pass: make random pointer connections at deep copied nodes
//Third pass: form original and deepcopies lists
//TC: O(3n)
//SC: O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node curr=head;

        while(curr!=null){
            Node newnode= new Node(curr.val);
            Node temp=curr.next;
            curr.next=newnode;
            newnode.next=temp;
            curr=curr.next.next;
        }

        curr=head;

        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        curr=head;
        Node currcopy=curr.next;
        Node ans=currcopy;
        while(curr!=null){
            curr.next=curr.next.next;
            if(currcopy.next!=null){
                currcopy.next=currcopy.next.next;
            }
            curr = curr.next;
            currcopy = currcopy.next;
        }

        return ans;
        
    }
}
