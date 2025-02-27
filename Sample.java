class Sample{


    /**************PROBLEM-2**************/

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
//TC:0(N)
//SC:0(1)
    class Solution {
        public Node copyRandomList(Node head) {
            Node curr=head;
            while(curr!=null){
                Node newNode=new Node(curr.val);
                newNode.next=curr.next;
                curr.next=newNode;
                curr=newNode.next;
            }

            curr=head;
            while(curr!=null){
                if(curr.random!=null){
                    curr.next.random=curr.random.next;
                }
                curr=curr.next.next;
            }

            Node original=head;
            Node copy=head.next;
            Node copyHead=head.next;
            while(original!=null){
                original.next=original.next.next;
                if(copy.next!=null){
                    copy.next=copy.next.next;
                }
                original=original.next;
                copy=copy.next;
            }
            return copyHead;
        }
    }

}