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
// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes

//with extra space of map
class CopyList {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        //map to store node & it's copy
        //we will ensure that a node is not created twice
        map = new HashMap<>();
        //clone head and have current & currentCopy
        Node headCopy = clone(head);
        Node curr = head;
        Node currCopy = headCopy;
        //move to original nodes one by one
        while(curr != null){
            //create copies of next node & random node for each node
            currCopy.next = clone(curr.next);
            currCopy.random = clone(curr.random);
            //move to next nodes
            curr = curr.next;
            currCopy = currCopy.next;
        }

        return headCopy;
    }

    //clone method for creating copy of a given node
    private Node clone(Node node){
        if(node == null)
            return node;
        //if copy of node is already created then return that
        if(map.containsKey(node))
            return map.get(node);
        //else create a copy and store it in map
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}

// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes

class CopyList {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        Node curr = head;
        //create copy of node and put it next to original node
        //1->2->3 to 1->1'->2->2'->3->3'
        while(curr != null){
            //creating copy & putting it between curr node & next node
            Node currCopy = new Node(curr.val);
            currCopy.next = curr.next;
            curr.next = currCopy;
            //moving to next node
            curr = curr.next.next;
        }

        curr = head;
        //create random links for copies
        while(curr != null){
            if(curr.random != null)
                curr.next.random = curr.random.next;
            //moving to next node
            curr = curr.next.next;
        }

        //split the list
        curr = head;
        Node headCopy = head.next;
        Node currCopy = head.next;
        //1->2->3 1'->2'->3'
        while(curr != null){
            //skipping it's copy
            curr.next = curr.next.next;
            //setting copy's next
            if(currCopy.next != null){
                currCopy.next = currCopy.next.next;
            }
            //moving to next node
            curr = curr.next;
            currCopy = currCopy.next;
        }

        return headCopy;
    }
}