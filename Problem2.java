// Time Complexity : O(n)  
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null ) return null;
        Node newHead = new Node(head.val);
        Node currentOld = head;
        Node currentNew = newHead;
        // creating a new node
        while(currentOld != null){
            if(currentOld.next!=null){
                currentNew.next = new Node(currentOld.next.val);
            }
            currentOld = currentOld.next;
            currentNew = currentNew.next;
        }

        // Interwieving the old and new nodes

        currentOld = head;
        currentNew = newHead;

        while(currentOld != null){
            Node oldNext = currentOld.next;
            Node newNext = currentNew.next;
            currentOld.next = currentNew;
            currentNew.next = oldNext;
            currentOld = oldNext;
            currentNew = newNext;
        }

        // Populate Random Pointers
        // starting with old
        currentOld = head;

        while(currentOld!=null && currentOld.next != null ){
            if(currentOld.random != null) currentOld.next.random = currentOld.random.next;
            currentOld = currentOld.next.next;
        }

        // Removing the Weaving between the nodes
        currentOld = head;

        while(currentOld!=null && currentOld.next != null ){
            Node newNext = currentOld.next;
            currentOld.next = newNext.next;
            currentOld = newNext;
        }


        return newHead;
    }