// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

package Design-5;

public class Problem1 {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node copyHead = new Node(head.val);
        map.put(head, copyHead);

        Node cur = head;
        Node copyCur = copyHead;

        // copy just the list
        while(cur != null){
            if(cur.next != null){
                if(!map.containsKey(cur.next)){
                    Node copyNext = new Node(cur.next.val);
                    map.put(cur.next, copyNext);
                }
                copyCur.next = map.get(cur.next);
            }
            
            if(cur.random !=null){
                if(!map.containsKey(cur.random)){
                    Node copyRandom = new Node(cur.random.val);
                    map.put(cur.random, copyRandom);
                }
                copyCur.random = map.get(cur.random);
            }
            
            copyCur = copyCur.next;
            cur = cur.next;
        }

        return map.get(head);
    }
}
