//Problem 1 - > Parking Lot
// Time Complexity : O()
// Space Complexity : O()
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//Problem 2 - > Copy list random pointers
// Time Complexity : O(3n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//put new pointers in middle of two nodes. for example 1' should be between 1 and 2. and in one more iteration, it should go to check random pointers
//do one more traversal to remove the extra links added in original list.
class Solution {
    HashMap<Node, Node> map;
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        this.map=new HashMap<>();

        // Node copyhead=clone(head);
        // Node cur=head, copyCur=copyhead;

        // while(cur!=null){
        //     //handle next
        //     // if(cur.next!=null){
        //         copyCur.next=clone(cur.next);
        //     // }

        //     //random pointer
        //     // if(cur.random!=null){
        //         copyCur.random=clone(cur.random);
        //     // }

        //     cur=cur.next;
        //     copyCur=copyCur.next;
        // }
        // return copyhead;


        //Optimized Solution O(3n) O(n)

        //create node and locate them next to original
        Node cur=head;
        while(cur!=null){
            Node newNode=new Node(cur.val);
            newNode.next=cur.next;
            cur.next=newNode;
            cur=cur.next.next;
        }
        cur=head;
        Node copyHead=head.next;
        Node copyCur =copyHead;

        //handle random pointers
        while(cur!=null){
            if(cur.random!=null){
                copyCur.random=cur.random.next;
            }

            cur=cur.next.next;
            if(copyCur.next!=null)
                copyCur=copyCur.next.next;
        }

        cur=head;
        copyCur=copyHead;
        //break links
        while(cur!=null){
            cur.next=cur.next.next;
            if(copyCur.next!=null)
                copyCur.next=copyCur.next.next;

            cur=cur.next;
            copyCur=copyCur.next;
        }
        
        return copyHead;
    }

    private Node clone(Node node){
        if(node==null) return null;
        if(map.containsKey(node)){
            return map.get(node);
        }

        Node newNode= new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}