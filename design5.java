//time O(N) and space O(N)

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;

        Map<Node,Node> map = new HashMap<>();
        Node curr = head;
        Node copyCurr = new Node(curr.val);
        map.put(curr,copyCurr);

        while(curr!=null){
            if(curr.next!=null){
                if(!map.containsKey(curr.next)){
                    Node copy = new Node(curr.next.val);
                    map.put(curr.next, copy);
                }   
                copyCurr.next = map.get(curr.next);
            }
            

            if(curr.random!=null){
                if(!map.containsKey(curr.random)){
                    Node copy = new Node(curr.random.val);
                    map.put(curr.random, copy);
                }
                copyCurr.random = map.get(curr.random);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return map.get(head);
        
    }
}
