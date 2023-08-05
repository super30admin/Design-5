import java.util.HashMap;
import java.util.Map;

public class RandomPointer {
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
    //Time Complexity:O(N)
    //Space Complexity:O(1);
    public Node copyRandomListWithoutExtraSpace(Node head) {
        if(head == null){
            return null;
        }
        Node current = head;
        //copy nodes placed in between
        while(current != null){
            Node copyNode = new Node(current.val);
            copyNode.next = current.next;
            current.next = copyNode;
            current = current.next.next;

        }
        //random pointers;
        current = head;
        while(current != null){
            Node copyNode = current.next;

            if(current.random !=null){
                copyNode.random = current.random.next;
            }

            current = current.next.next;
        }
        // skip list
        Node copy = head.next;
        current = head;
        Node copyHead = head.next;
        while(current != null){
            current.next= current.next.next;
            copy.next = copy.next!= null?copy.next.next: null;


            copy = copy.next;
            current= current.next;
        }

        return copyHead;

    }
    //Time Complexity: O(N)
    //Space complexity:O(N) extra map used
    public Node copyRandomListWithExtraSpace(Node head){
        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        Node copyHead = new Node(-1);
        Node prev = copyHead;
        Node currentCopy = null;
        Node currentRandomCopy = null;
        while(current != null){

            if(!map.containsKey(current)){
                currentCopy = new Node(current.val);
                map.put(current, currentCopy);
            }
            else currentCopy = map.get(current);

            prev.next = currentCopy;
            if(current.random!=null)
            {
                if(!map.containsKey(current.random)){
                    currentRandomCopy = new Node(current.random.val);
                    map.put(current.random, currentRandomCopy);
                }
                else{
                    currentRandomCopy = map.get(current.random);
                }
                currentCopy.random = currentRandomCopy;
            }

            prev = prev.next;
            current = current.next;
        }

        return copyHead.next;
    }

}
